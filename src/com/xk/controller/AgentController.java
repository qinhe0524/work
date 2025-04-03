
package com.xk.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.xk.entity.Agent;
import com.xk.entity.AgentAgent;
import com.xk.entity.CheckPerson;
import com.xk.entity.Company;
import com.xk.entity.Contact;
import com.xk.entity.FreeWorker;
import com.xk.entity.Task;
import com.xk.entity.TaskOrder;
import com.xk.service.AgentAgentService;
import com.xk.service.AgentService;
import com.xk.service.CheckPersonService;
import com.xk.service.CompanyService;
import com.xk.service.ContactService;
import com.xk.service.FreeWorkerService;
import com.xk.service.TaskOrderService;
import com.xk.service.TaskService;
import com.xk.util.AliFourUtils;
import com.xk.util.DateUtil;
import com.xk.util.MemCached;
import com.xk.util.SmsDemo;
import com.xk.util.Utils;
import com.xk.util.WeChatUtils;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* ********************************************************
* @ClassName: AgentController
* @Description: 自由职业者
* @author 自动生成
* @date 2020-10-15 下午 02:51:38 
*******************************************************
*/
@SuppressWarnings("all")
@Scope("prototype")
@Controller
@RequestMapping("/Agent")
public class AgentController extends BaseController{

	@Resource
	private FreeWorkerService freeWorkerService;
	@Resource
	private AgentService agentService;
	@Resource
	private AgentAgentService agentAgentService;
	@Resource
	private ContactService contactService;
	@Resource
	private TaskOrderService taskOrderService;
	@Resource
	private CompanyService companyService;
	
	
	
	
	/**
	 * ********************************************************
	 * @Title: my
	 * @Description: 代理首页
	 * @return String
	 * @date 2020-10-15 下午 02:51:38 
	 ********************************************************
	 */
	 @RequestMapping("/my")
	public String my(){
		FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
		this.setAttribute("fw", fw);
		Agent a=(Agent) this.getSession().getAttribute("agent");
		this.setAttribute("a", a);
		Map<String,Object> ct=agentService.getOneMap("getAgentClientNum", a.getAgent_no());
		this.setAttribute("ct", ct);
		Integer yesterDayAmt=agentService.getNumber("getYesterdayAmt",a.getAgent_no());
		this.setAttribute("yesterDayAmt", yesterDayAmt);
		this.setAttribute("menu", "4");
		return this.display();
	}
	 
		
		/**
		 * ********************************************************
		 * @Title: my_info
		 * @Description: 代理基本信息
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("/my_info")
		public String my_info(){
			FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
			this.setAttribute("fw", fw);
			Agent a=(Agent) this.getSession().getAttribute("agent");
			this.setAttribute("a", a);
		
			return this.display();
		}
		
			/**
			 * ********************************************************
			 * @Title: my_agent
			 * @Description: 我的代理
			 * @return String
			 * @date 2020-10-15 下午 02:51:38 
			 ********************************************************
			 */
			 @RequestMapping("/my_agent")
			public String my_agent(){
				FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
				this.setAttribute("fw", fw);
				Agent a=(Agent) this.getSession().getAttribute("agent");
				List<Map<String,Object>> agentList=agentService.getList("getAgentsByParentNo",a.getAgent_no());
				this.setAttribute("agentList", agentList);
				return this.display();
			}
			/**
			 * ********************************************************
			 * @Title: my_client
			 * @Description: 团队客户
			 * @return String
			 * @date 2020-10-15 下午 02:51:38 
			 ********************************************************
			 */
			 @RequestMapping("/my_client")
			public String my_client(){
				FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
				this.setAttribute("fw", fw);
				Agent a=(Agent) this.getSession().getAttribute("agent");
				List<Map<String,Object>> clientList=agentService.getList("getClients",a.getAgent_no());
				this.setAttribute("clientList", clientList);
				return this.display();
			}
			
		 @RequestMapping("/my_add")
			public String my_add(){
				FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
				this.setAttribute("fw", fw);
				Agent a=(Agent) this.getSession().getAttribute("agent");
				this.setAttribute("a", a);
				return this.display();
			}
		 /**
			 * ********************************************************
			 * @Title: save
			 * @Description: 修改保存
			 * @return String
			 * @date 2020-10-08 下午 11:49:02 
			 ********************************************************
			 */
			 @RequestMapping("/save")
			public @ResponseBody Map save(@ModelAttribute("Agent") Agent  agent,@ModelAttribute("Contact") Contact contact,@ModelAttribute("Company") Company company){
				FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
				 Agent a=(Agent) this.getSession().getAttribute("agent");
				 Object worker_object=this.checkAgentMobile(contact.getCon_mobile());  //获取工作者编号
				 if(worker_object instanceof String){
					 return this.error(worker_object.toString());
				 }
				FreeWorker add_fw=(FreeWorker) worker_object;
				String worker_no=add_fw.getWorker_no();
				agent.setWorker_no(worker_no);
				agent.setCps_type(0);
				agent.setClerk(a.getClerk());
				agent.setAdduser("admin");
				agent.setAgent_label("1");
			 	String areas=this.getParameter("areas"); //区域 省/市/区
				String[] area_array=areas.split("\\/");
				agent.setProvince(area_array[0]);
				agent.setCity(area_array[1]);
				 contact.setCon_provice(area_array[0]);
				 contact.setCon_card_no(add_fw.getWorker_cardno());
				String agent_no=agent.getAgent_no();
				if(area_array.length==3)agent.setArea(area_array[2]); //有些地方无区县，如西藏某些地方
				if(agent_no==null||agent_no.equals("")){
					agent.setAddtime(DateUtil.get4yMdHms(new Date()));
					agent.setAdduser(this.getUserCode());
				}
				Integer agent_level=1;
				agent.setPagent_no(a.getAgent_no());
				if(!agent.getPagent_no().equals("0")){			
					Agent pagent=a;
					agent_level=pagent.getAgent_level()+1;
				}
				agent.setAgent_level(agent_level);
			 
				int result=agent_no==null||agent_no.equals("")?agentService.insert(agent):agentService.update(agent);
			    contact.setCon_object_no(agent.getAgent_no());
			    contact.setContact_object_type(1);
			    contact.setContact_type(0);
			    contact.setCon_wechat(add_fw.getWechat_nickname());
			    int con_result=agent_no==null||agent_no.equals("")?contactService.insert(contact):contactService.update(contact);
			    if(agent_no==null||agent_no.equals("")){ //当是添加时，添加代理业务关联表agent_agent;
					AgentAgent aa=new AgentAgent();
					aa.setAgent_level(agent_level);
					aa.setAgent_no(agent.getAgent_no());
					aa.setIs_direct(0);
					aa.setParent_no(agent.getAgent_no());
					agentAgentService.insert(aa);
				}
			    List<AgentAgent> aaList=agentAgentService.getObjectList("getAgentAgentList", a.getAgent_no());
			    for(int i=0;i<aaList.size();i++){
			    	AgentAgent aa=aaList.get(i);
			    	if(aa.getAgent_no().equals(a.getAgent_no())){
			    		aa.setIs_direct(1);
			    	}else{
			    		aa.setIs_direct(0);
			    	}
			    	aa.setAgent_level(agent_level);
			    	aa.setAgent_no(agent.getAgent_no());
			    	agentAgentService.insert(aa);
			    }
				if(agent.getIscompany()==1){ //企业性质
					company.setCom_object_no(agent.getAgent_no());
					company.setCom_object_type(0);//代理商
					int com_result=agent_no==null?companyService.insert(company):companyService.update(company);
				}
				MemCached.getInstance().delete("AgentInfo");
				return success("保存成功","");
			}

			/**
			 * ********************************************************
			 * @Title: checkAgentMobile
			 * @Description: 检测手机号是否存在，是否公众号注册了
			 * @return String
			 * @date 2020-10-08 下午 11:49:02
			 ********************************************************/
			private Object checkAgentMobile(String mobile){
				 Integer t=agentService.getNumber("agentContactNum",mobile);
				 if(t!=0){
				 	return "手机号已经注册代理，不能重复注册";
				 }
				 FreeWorker fw=freeWorkerService.getOne("getOneByMobile",mobile);
				 if(fw==null){
				 	 return "该手机号尚未注册自由职业者";
				 }
				 return fw;
			}
			/**
			 * ********************************************************
			 * @Title: getFreeMobile
			 * @Description:
			 * @return String
			 * @date 2020-10-08 下午 11:49:02
			 ********************************************************/
			@RequestMapping("/getFreeMobile")
			public @ResponseBody Map getFreeMobile(){
				 String mobile=this.getParameter("mobile");
				 if(mobile==null){
					 return this.error("手机号不能为空");
				 }
				
				 Integer t=agentService.getNumber("agentContactNum",mobile);
				 if(t!=0){
				 	return this.error("手机号已经注册代理，不能重复注册");
				 }
				 FreeWorker fw=freeWorkerService.getOne("getOneByMobile",mobile);
				 if(fw==null){
				 	 return this.error("该手机号尚未注册自由职业者");
				 }
				 return this.success(fw.getWorker_name());
			}
			 
	     /**   
		 * ********************************************************
		 * @Title: index
		 * @Description: 任务列表
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		@RequestMapping("/my_trade")
		public String my_trade(){
			 String type=this.getParameter("type")==null?"0":this.getParameter("type");
			 this.setAttribute("type", type);
			 List<Map<String,Object>> dataList=new ArrayList<Map<String,Object>>();
			 Agent a=(Agent) this.getSession().getAttribute("agent");
			 if(type.equals("0")){
				 dataList=agentService.getList("getOrderByDay",a.getAgent_no());
			 }else if(type.equals("1")){
				 dataList=agentService.getList("getOrderByClient",a.getAgent_no());
			 }else{
				 dataList=agentService.getList("getOrderByAgent",a.getAgent_no());
			 }
			 
			 this.setAttribute("dataList", dataList);
			 return this.display();
		}

}

