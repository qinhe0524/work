
package com.xk.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.xk.entity.CheckPerson;
import com.xk.entity.FreeWorker;
import com.xk.entity.Task;
import com.xk.entity.TaskOrder;
import com.xk.service.CheckPersonService;
import com.xk.service.FreeWorkerService;
import com.xk.service.TaskOrderService;
import com.xk.service.TaskService;
import com.xk.util.AliFourUtils;
import com.xk.util.DateUtil;
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
* @ClassName: FreeWorkerController
* @Description: 自由职业者
* @author 自动生成
* @date 2020-10-15 下午 02:51:38 
*******************************************************
*/
@SuppressWarnings("all")
@Scope("prototype")
@Controller
@RequestMapping("/Task")
public class TaskController extends BaseController{

	@Resource
	private FreeWorkerService freeWorkerService;
	@Resource
	private TaskService taskService;
	@Resource
	private TaskOrderService taskOrderService;
	
	
	
	/**
	 * ********************************************************
	 * @Title: list
	 * @Description: 任务列表
	 * @return String
	 * @date 2020-10-15 下午 02:51:38 
	 ********************************************************
	 */
	 @RequestMapping("/list")
	public String list(){
		List<Map<String,Object>> taskList;
		if(this.getParameter("task_type")==null){
			taskList=taskService.getList("getShowtask");
		}else{
			taskList=taskService.getList("getShowTypetask",this.getParameter("task_type"));
		}
	    this.setAttribute("taskList", taskList);
	    this.setAttribute("menu", "2");//指定选中菜单
		return this.display();
	}
	 
	 @RequestMapping("/aboutus")
	 public String aboutus(){
		 return this.display();
	 }
	 
		/**
		 * ********************************************************
		 * @Title: add
		 * @Description: 任务列表
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("/add")
		public String add(){
			 String task_no=this.getParameter("task_no");
			Task task=taskService.getOne(task_no);
		    this.setAttribute("task", task);
			return this.display();
		}
	 
		 @RequestMapping("/saveTaskOrder")
		 public @ResponseBody Map saveTaskOrder(){
			 String task_no=this.getParameter("task_no");			
			 FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
			 //TODO:判断是否已经注册，暂时关闭，线上恢复
//			 String openId=this.getOpenId();
//			 if(fw==null){
//				 fw=freeWorkerService.getOne("getByOpenId",openId);
//				 if(fw==null){
//					 return this.error("请先进行自由职业者注册");
//				 }else{
//					 this.getSession().setAttribute("freeworker", fw);
//				 }
//			 }
             String worker_no=fw.getWorker_no();
             Map<String,String> marg=new HashMap<String,String>();
             marg.put("task_no", task_no);
             marg.put("worker_no", worker_no);
             TaskOrder  taskOrder=taskOrderService.getOne("getByTaskWorker",marg);
             if(taskOrder!=null){
            	 this.error("您已经报名，不能重复报名");
             }
            //TODO:此处报名成功需要短信通知自由职业者，告知其报名成功
			 return this.success("报名成功，请等待业务联系您");
			
		 }
		 
		 /**
			 * ********************************************************
			 * @Title: index
			 * @Description: 首页
			 * @return String
			 * @date 2020-10-15 下午 02:51:38 
			 ********************************************************
			 */
			@RequestMapping("/index")
			public String index(){
				 return this.display();
			}
			
			 
		 /**
			 * ********************************************************
			 * @Title: index
			 * @Description: 任务列表
			 * @return String
			 * @date 2020-10-15 下午 02:51:38 
			 ********************************************************
			 */
			@RequestMapping("/task")
			public String task(){
				 this.setAttribute("menu", "2");
				 return this.display();
			}

}

