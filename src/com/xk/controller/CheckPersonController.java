
package com.xk.controller;


import java.util.Map;
import com.xk.entity.CheckPerson;
import com.xk.service.CheckPersonService;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* ********************************************************
* @ClassName: CheckPersonController
* @Description: 身份验证记录
* @author 自动生成
* @date 2020-11-01 下午 06:18:18 
*******************************************************
*/
@SuppressWarnings("all")
@Scope("prototype")
@Controller
@RequestMapping("/CheckPerson")
public class CheckPersonController extends BaseController{

	@Resource
	private CheckPersonService checkPersonService;

	/**
	 * ********************************************************
	 * @Title: list
	 * @Description: 表格页面
	 * @return String
	 * @date 2020-11-01 下午 06:18:18 
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
	 * @date 2020-11-01 下午 06:18:18 
	 ********************************************************
	 */
	 @RequestMapping("/list_json")
	public @ResponseBody String list_json(){
		checkPersonService.getPageList(this.getPage());
		return this.getPage().getJsonPage();
	}

	/**
	 * ********************************************************
	 * @Title: add
	 * @Description: 添加、显示
	 * @return String
	 * @date 2020-11-01 下午 06:18:18 
	 ********************************************************
	 */
	 @RequestMapping("/add")
	public String add(@RequestParam(value="id",required=false) Integer id){
		if(id!=null){
			CheckPerson checkPerson = checkPersonService.getOne(id) ;
			this.setAttribute("checkPerson",checkPerson);
		}
		return this.display();
	}

	/**
	 * ********************************************************
	 * @Title: save
	 * @Description: 修改保存
	 * @return String
	 * @date 2020-11-01 下午 06:18:18 
	 ********************************************************
	 */
	 @RequestMapping("/save")
	public @ResponseBody Map save(@ModelAttribute("CheckPerson") CheckPerson  checkPerson){
		int result=checkPerson.getId()==null?checkPersonService.insert(checkPerson):checkPersonService.update(checkPerson);
		return success("保存成功","");
	}

	/**
	 * ********************************************************
	 * @Title: delete
	 * @Description: 删除
	 * @return String
	 * @date 2020-11-01 下午 06:18:18 
	 ********************************************************
	 */
	 @RequestMapping("/delete")
	public @ResponseBody Map delete(@RequestParam Integer id){
		int result=checkPersonService.delete(id);
		return success("删除成功","");
	}

}

