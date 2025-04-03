
package com.xk.controller;


import java.util.Map;
import com.xk.entity.AgentAgent;
import com.xk.service.AgentAgentService;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* ********************************************************
* @ClassName: AgentAgentController
* @Description: 代理关系表
* @author 自动生成
* @date 2020-12-16 下午 01:48:41 
*******************************************************
*/
@SuppressWarnings("all")
@Scope("prototype")
@Controller
@RequestMapping("/AgentAgent")
public class AgentAgentController extends BaseController{

	@Resource
	private AgentAgentService agentAgentService;

	/**
	 * ********************************************************
	 * @Title: list
	 * @Description: 表格页面
	 * @return String
	 * @date 2020-12-16 下午 01:48:41 
	 ********************************************************
	 */
	 @RequestMapping("/list")
	public String list(){
		return this.display();
	}

	/**
	 * ********************************************************
	 * @Title: list_json
	 * @Description: 表格dataTable json
	 * @return String
	 * @date 2020-12-16 下午 01:48:41 
	 ********************************************************
	 */
	 @RequestMapping("/list_json")
	public @ResponseBody String list_json(){
		agentAgentService.getPageList(this.getPage());
		return this.getPage().getJsonPage();
	}

	/**
	 * ********************************************************
	 * @Title: add
	 * @Description: 添加、显示
	 * @return String
	 * @date 2020-12-16 下午 01:48:41 
	 ********************************************************
	 */
	 @RequestMapping("/add")
	public String add(@RequestParam(value="id",required=false) Integer id){
		if(id!=null){
			AgentAgent agentAgent = agentAgentService.getOne(id) ;
			this.setAttribute("agentAgent",agentAgent);
		}
		return this.display();
	}

	/**
	 * ********************************************************
	 * @Title: save
	 * @Description: 修改保存
	 * @return String
	 * @date 2020-12-16 下午 01:48:41 
	 ********************************************************
	 */
	 @RequestMapping("/save")
	public @ResponseBody Map save(@ModelAttribute("AgentAgent") AgentAgent  agentAgent){
		int result=agentAgent.getId()==null?agentAgentService.insert(agentAgent):agentAgentService.update(agentAgent);
		return success("保存成功","");
	}

	/**
	 * ********************************************************
	 * @Title: delete
	 * @Description: 删除
	 * @return String
	 * @date 2020-12-16 下午 01:48:41 
	 ********************************************************
	 */
	 @RequestMapping("/delete")
	public @ResponseBody Map delete(@RequestParam Integer id){
		int result=agentAgentService.delete(id);
		return success("删除成功","");
	}

}

