
package com.xk.controller;


import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.baidu.ai.aip.auth.AuthService;
import com.xk.entity.Agent;
import com.xk.entity.CheckPerson;
import com.xk.entity.FreeWorker;
import com.xk.service.AgentService;
import com.xk.service.CheckPersonService;
import com.xk.service.FreeWorkerService;
import com.xk.service.TaskOrderService;
import com.xk.service.TaskService;
import com.xk.util.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.invoke.util.Wrapper;

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
@RequestMapping("/FreeWorker")
public class FreeWorkerController extends BaseController{

	@Resource
	private FreeWorkerService freeWorkerService;
	@Resource
	private TaskOrderService taskOrderService;
	@Resource
	private TaskService taskService;
	@Resource
	private CheckPersonService checkPersonService;
	@Resource
	private AgentService agentService;
	private Integer smsMinute=10; //短信验证码有效时间，单位分钟
	public static ResourceBundle comresour = ResourceBundle.getBundle("commondata");//读取配置文件


	/**
	 * 输出logo4j日志到文件
	 */
	private static Logger logger = Logger.getLogger(FreeWorkerController.class);

	/**
	 * ********************************************************
	 * @Title: add
	 * @Description: 添加、显示
	 * @return String
	 * @date 2020-10-15 下午 02:51:38 
	 ********************************************************
	 */
	 @RequestMapping("/add")
	public String add(){
		    String mobile=this.getSession().getAttribute("mobile")==null?"":this.getSession().getAttribute("mobile").toString();
		    if(mobile==null||mobile.equals("")){
		    	String login=WeChatUtils.netUrl+"FreeWorker/login";
		    	try {
					response.sendRedirect(login);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		   Map<String,String> worker_card_info=(Map<String, String>) (this.getSession().getAttribute("worker_card_info")==null?new HashMap<String,String>():this.getSession().getAttribute("worker_card_info"));
		  this.setAttribute("cardinfo", worker_card_info);
		    
		 this.setAttribute("mobile", mobile);
		return this.display();
	}
	 

	/**
		 * ********************************************************
		 * @Title: reg
		 * @Description: 添加、显示
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("/reg")
		public String reg(){
		    String mobile=this.getSession().getAttribute("mobile")==null?"":this.getSession().getAttribute("mobile").toString();
		    if(mobile==null||mobile.equals("")){
		    	String login=WeChatUtils.netUrl+"FreeWorker/login";
		    	try {
					response.sendRedirect(login);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
			return this.display();
		}
	/**
	 * ********************************************************
	 * @Title: service_agreement
	 * @Description: 自由职业者服务协议
	 * @return String
	 * @date 2020-10-15 下午 02:51:38
	 ********************************************************
	 */
	@RequestMapping("/service_agreement")
	public String service_agreement(String agree_status){
		if(agree_status!=null){
			this.setAttribute("agree_status","1");
		}else {
			this.setAttribute("agree_status","2");
		}
		return this.display();
	}

	/**
	 * ********************************************************
	 * @Title: privacy_agreement
	 * @Description: 隐私协议
	 * @return String
	 * @date 2020-10-15 下午 02:51:38
	 ********************************************************
	 */
	@RequestMapping("/privacy_agreement")
	public String privacy_agreement(String agree_status){
		if(agree_status!=null){
			this.setAttribute("agree_status","1");
		}else {
			this.setAttribute("agree_status","2");
		}
		return this.display();
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
			List<Map<String,Object>> taskList=taskService.getList("getHottask");
		    this.setAttribute("taskList", taskList);
			 this.setAttribute("menu", "1");
			 return this.display();
		}
		/**
		 * ********************************************************
		 * @Title: login
		 * @Description: 注册登录
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("/login")
		public String login(){
//			 String openId=this.getOpenId();
			 FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
			 if(fw==null){
//				 fw=freeWorkerService.getOne("getByOpenId",openId);
				 if(fw!=null){
					 this.checkAgent(fw);
					 this.getSession().setAttribute("freeworker", fw);
				 }
			 }
			 if(fw!=null){
				 	String my=WeChatUtils.netUrl+"FreeWorker/my";
			    	try {
						response.sendRedirect(my);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
			 return this.display();
		}
		 
		public void checkAgent(FreeWorker fw){
			Agent a=agentService.getOne("getOneByWorkerNo",fw.getWorker_no());
			if(a!=null){
				this.getSession().setAttribute("agent",a);
			}
			
		}
		
		/**
		 * ********************************************************
		 * @Title: my
		 * @Description: 个人中心
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("/my")
		public String my(){
			FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
			this.setAttribute("fw", fw);
			this.setAttribute("menu", "3");
			return this.display();
		}

			/**
			 * ********************************************************
			 * @Title: my_bankcard
			 * @Description:卡中心
			 * @return String
			 * @date 2020-10-15 下午 02:51:38 
			 ********************************************************
			 */
			 @RequestMapping("/my_bankcard")
			public String my_bankcard(){
				FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
				this.setAttribute("fw", fw);
				return this.display();
			} 
		/**
		 * ********************************************************
		 * @Title: my_info
		 * @Description: 我的信息
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("my_info")
		public String my_info(){
			FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
			this.setAttribute("fw", fw);
			return this.display();
		}
		 /**
		  * 百度云OCR识别
		  * @param datas
		  * @param fs
		  * @return
		  */
		 public String baidu_idcardCheck(String filepath,String fs){
			  String result= AuthService.idcardCheck(filepath, fs, this.getBaiduToken());
			  System.out.println(result);
			  return result;
		 }
		 
		 public String getBaiduToken(){
			 DataCache dc=new DataCache();
			 Object otoken= dc.getCacheObj().get("baiduToken");
			 String token="";
			 if(otoken!=null){
				 Map<String,String> oldbaiduToken=(Map<String, String>) otoken;
				 String time=oldbaiduToken.get("time");
				 Long s=DateUtil.StringToLong(time);
				 if(new Date().getTime()-s<2073600000){   // 当前时间-缓存时间<25天 不换token
					 token=oldbaiduToken.get("token");
					 System.out.println("缓存获取token----"+token);
					 return token;
				 }
			 } 
			 Map<String,String> baiduToken=new HashMap<String,String>();
			 String ak = comresour.getString("baiApiKey");//获取默认上传地址
			 String sk = comresour.getString("baiSecretKey");//获取默认上传地址
			 token=AuthService.getAuth(ak, sk);
			 System.out.println("请求获取token----"+token);
			 baiduToken.put("time", DateUtil.get4yMdHms(new Date()));
			 baiduToken.put("token", token);
			 dc.getCacheObj().add("baiduToken", baiduToken);
			 return token;
		 }
		 
		 
		 
		/**
		 * ********************************************************
		 * @Title: my_info
		 * @Description: 身份证检测
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("checkIdcard")
		 public @ResponseBody Map checkIdcard(@RequestParam String datas,@RequestParam String fs){
			 FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
			 String mobile=this.getSession().getAttribute("mobile")==null?"":this.getSession().getAttribute("mobile").toString();
			 if(mobile.equals("")){
				mobile=fw.getWorker_mobile();
			 }
			 String idcardUpload = comresour.getString("idcardUpload");//获取默认上传地址
			 String filePath=idcardUpload+"/"+mobile+"_"+fs;
			 if(datas==null||datas.equals("")){
				  return this.error("请选择图片上传");
			 }
			 String cn_fs=fs.equals("0")?"正面":"反面";
			 filePath= convertBase64ToImage(datas,filePath);
			 String result=baidu_idcardCheck(filePath,fs);
			  if(result.equals("err")){
			  	  logger.info("无法识别该身份证-"+cn_fs+"出错");
				  return this.error("无法识别该身份证-"+cn_fs+"出错");
			  }
			 Map<String,String> remap=JsonMap.jsonToMap(result);
			 if(remap==null||!remap.containsKey("image_status")||!remap.get("image_status").equals("normal")){
				 logger.info("无法识别该身份证-"+cn_fs+"出错");
				 return this.error("无法识别该身份证-"+cn_fs);
			 }
			 this.checkBaiduInfo(remap.get("words_result"),fs);
			 logger.info("身份证识别:"+remap.get("words_result")+"-"+fs);
			 return this.success("成功");
		 }
		 
		 private void checkBaiduInfo(String words_result,String fs){
			 Map<String,String> remap=JsonMap.jsonToMap(words_result);
			 try {
				 if(fs.equals("0")){
					 String name="";
					 String idcard="";
					 if(remap.containsKey("姓名")){
						 Map<String,String> namem=JsonMap.jsonToMap(remap.get("姓名"));
						 name=namem.get("words");
					 }
					 if(remap.containsKey("公民身份号码")){
						 Map<String,String> idcardm=JsonMap.jsonToMap(remap.get("公民身份号码"));
						 idcard=idcardm.get("words");

					 }
					 this.getSession().setAttribute("idcardno",idcard);
					 mes.put("idcard", idcard);
					 mes.put("name", name);
				 }else{
					 String idcard_end_date="";
					 if(remap.containsKey("失效日期")){
						 Map<String,String> idcard_end_datem=JsonMap.jsonToMap(remap.get("失效日期"));
						 idcard_end_date=idcard_end_datem.get("words");
					 }
					 this.getSession().setAttribute("idcard_end_date",idcard_end_date);
					 mes.put("idcard_end_date", idcard_end_date);
				 }
			 }catch (Exception e){
			 	logger.error(e);
			 }
		 }

		    /**
		     * base64转图片
		     * @param base64Code base64码
		     */
		    public static String convertBase64ToImage(String base64Code,String filepath){
		    	 String [] d = base64Code.split("base64,");
		    	 String dataPrix="";
		    	 String data="";
		    	 String suffix="";
                if(d != null && d.length == 2){
                    dataPrix = d[0];
                    data = d[1];
                }
                if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
                    suffix = ".jpg";
                } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
                    suffix = ".ico";
                } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
                    suffix = ".gif";
                } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
                    suffix = ".png";
                }else{
                   
                }
		        BufferedImage image = null;
		        byte[] imageByte = null;
		        try {
		            imageByte = DatatypeConverter.parseBase64Binary(data);
		            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
		            image = ImageIO.read(new ByteArrayInputStream(imageByte));
		            bis.close();
		            File outputfile = new File(filepath+suffix);
		            ImageIO.write(image, suffix.replace(".",""), outputfile);
		            return filepath+suffix;
		        } catch (IOException e) {
		            e.printStackTrace();
		            return "";
		        }
		    }
		/**
		 * ********************************************************
		 * @Title: my_agree
		 * @Description: 我的协议
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("my_agree")
		public String my_agree(){
			FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
			this.setAttribute("fw", fw);
			return this.display();
		}
		
		/**
		 * ********************************************************
		 * @Title: add_idcard
		 * @Description: 我的协议
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("add_idcard")
		public String add_idcard(){
			FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
		    String mobile=this.getSession().getAttribute("mobile")==null?"":this.getSession().getAttribute("mobile").toString();
			if(fw==null&&mobile.equals("")){
				String login=WeChatUtils.netUrl+"FreeWorker/login";
		    	try {
					response.sendRedirect(login);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error(e);
					e.printStackTrace();
				}
			}
			this.setAttribute("fw", fw==null?"0":"1");
			return this.display();
		}
			 
		
		/**
		 * ********************************************************
		 * @Title: my_concat
		 * @Description: 我的协议
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("my_concat")
		public String my_concat(){
			return this.display();
		}
		 
		/**
		 * ********************************************************
		 * @Title: my_taskorder
		 * @Description: 结算记录
		 * @return String
		 * @date 2020-10-15 下午 02:51:38 
		 ********************************************************
		 */
		 @RequestMapping("my_taskorder")
		public String my_taskorder(){
			FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
		    String worker_no=fw.getWorker_no();
		    List<Map<String,Object>> orderList=taskOrderService.getList("getWorkerOrder", worker_no);
		    this.setAttribute("orderList", orderList);
		    String order_amt=(String) taskOrderService.getObject("getWorkerOrderCount", worker_no);
		    this.setAttribute("order_amt", order_amt);
			return this.display();
		}
		 
			/**
			 * ********************************************************
			 * @Title: my_task
			 * @Description: 任务记录
			 * @return String
			 * @date 2020-10-15 下午 02:51:38 
			 ********************************************************
			 */
			 @RequestMapping("my_task")
			public String my_task(){
				FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
			    String worker_no=fw.getWorker_no();
			    List<Map<String,Object>> taskList=taskOrderService.getList("getWorkerTask", worker_no);
			    this.setAttribute("taskList", taskList);
				return this.display();
			}


	/**
	 * ********************************************************
	 * @Title: save
	 * @Description: 修改保存
	 * @return String
	 * @date 2020-10-15 下午 02:51:38 
	 ********************************************************
	 */
	 @RequestMapping("/save")
	public @ResponseBody Map save(@ModelAttribute("FreeWorker") FreeWorker  freeWorker){
		String mobile=freeWorker.getWorker_mobile();
//		String smscode=this.getParameter("smscode");
//		String session_code=this.getSession().getAttribute(mobile)!=null?this.getSession().getAttribute(mobile).toString():"";
//		if(!session_code.equals(smscode)){
//			this.getSession().removeAttribute(mobile);
//			return error("短信验证码填写错误");
//		}
		FreeWorker ck_freeWorker=freeWorkerService.getOne("getOneByCardNo",freeWorker.getWorker_cardno());
		if(ck_freeWorker!=null){
			this.getSession().removeAttribute(mobile);
			logger.info("身份证号"+freeWorker.getWorker_cardno()+"已经注册过");
			return  error("您的身份证号已经注册过");
		}
		 Map ageMap =Utils.getBirAgeSex(freeWorker.getWorker_cardno());
		 if(ageMap.get("age").toString().compareTo("18")<0 || ageMap.get("age").toString().compareTo("60")>0){
			 logger.info("自由职业者的年龄不在18-60岁之间");
			 return error("自由职业者的年龄不在18-60岁之间");
		 }
		 String mes=checkNameMoileCard(freeWorker.getWorker_name(), freeWorker.getWorker_cardno(),freeWorker.getWorker_bank_num());
        //String mes="ok";
        if(!mes.equals("ok")){
			logger.info("手机号"+freeWorker.getWorker_mobile()+"、姓名"+freeWorker.getWorker_name()+"、身份证"+freeWorker.getWorker_cardno()+"、银行卡"+freeWorker.getWorker_bank_num() +"一致性认证失败");
			return error("手机号、姓名、身份证、银行卡一致性认证失败");
        }
		String areas=this.getParameter("areas");
		String[] ary_area=areas.split("\\/");
		freeWorker.setWorker_province(ary_area[0]);
		freeWorker.setWorker_city(ary_area[1]);
		freeWorker.setWorker_bank_person(freeWorker.getWorker_name());
		this.getSession().removeAttribute(mobile);
		freeWorkerService.insert(freeWorker);
		logger.info("新增自由职业者："+freeWorker);
//		String openId=this.getOpenId();
//		Map<String,Object> userInfo=WeChatUtils.getUserInfo(openId);
		Map<String,String> updateArgs=new HashMap<String,String>();
		updateArgs.put("worker_no", freeWorker.getWorker_no());
//		updateArgs.put("wechat_open_id",openId);
//		updateArgs.put("wechat_head_img",userInfo.get("headimgurl").toString());
//		updateArgs.put("wechat_nickname",userInfo.get("nickname").toString());
		freeWorkerService.update("updateWechatInfo",updateArgs);
		logger.info("新增自由职业者修改记录："+updateArgs);
		FreeWorker fw=freeWorkerService.getOne(freeWorker.getWorker_no());
		this.getSession().setAttribute("freeworker", fw);
		return success("注册成功,即将进入个人主页..","");
	}
	 
	public String checkNameMoileCard(String name,String cardno,String bankcard){
		Map<String,String> checkcode=new HashMap<>();
		Map<String,String> sm=new HashMap<String,String>();
		sm.put("ck_cardno", cardno);
		//sm.put("ck_mobile", mobile);
		sm.put("ck_name", name);
		sm.put("ck_bankcard", bankcard);
		CheckPerson cps=checkPersonService.getOne(sm);
		Integer ck_channel=1;
		if(cps!=null){
			checkcode.put("trueCode",cps.getCk_rtcode());
			checkcode.put("msg",cps.getCk_msg());
			ck_channel=0;
		}else{
			checkcode=HuaweiFourUtils.checkBankCardThree(sm);
		}
		String mes="";
		if(checkcode.get("trueCode").equals("00000")){
			logger.info("三要素:认证成功"+sm.toString());
			mes="ok";
		}else if(checkcode.get("trueCode").equals("00064")){
			logger.info(checkcode.get("msg")+sm.toString());
			mes=checkcode.get("msg");
		}else{
			logger.info(checkcode.get("msg")+sm.toString());
			mes=checkcode.get("msg");
		}
		CheckPerson cp=new CheckPerson();
		cp.setCk_channel(ck_channel);
		cp.setCk_name(name);
		cp.setCk_mobile("00000000000");
		cp.setCk_cardno(cardno);
		cp.setCk_result(checkcode.get("trueCode").equals("00000")?1:0);
		cp.setCk_bankcard(bankcard);
		cp.setCk_ip(Utils.getIpAddress(getRequest()));
		cp.setCk_rtcode(checkcode.get("trueCode"));
		cp.setCk_msg(checkcode.get("msg"));
		try {
			checkPersonService.insert(cp);
			logger.info("认证记录:"+cp);
		}catch (Exception e){
			logger.error(e);
		}
		return mes;
	}
	
	
	
	/**
	 * ********************************************************
	 * @Title: add_idcard_save
	 * @Description: 实名认证信息确认
	 * @return String
	 * @date 2020-10-15 下午 02:51:38 
	 ********************************************************
	 */
		 @RequestMapping("/add_idcard_save")
		public @ResponseBody Map add_idcard_save(String mobile){
			 String idcardno=this.getSession().getAttribute("idcardno")==null?"":this.getSession().getAttribute("idcardno").toString();
			 String idcard_end_date=this.getSession().getAttribute("idcard_end_date")==null?"":this.getSession().getAttribute("idcard_end_date").toString();
			 //在身份证上传时，正确识别的，存入了正面 session 身份证号，反面的有效期 
			 this.getParameter("worker_cardno");
			 if(idcardno.equals("")||idcard_end_date.equals("")){
				   return this.error("请先上传身份证正反面");
			 }
			 FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
			 if(fw==null){
				 Map<String,String> worker_card_info=new HashMap<String,String>();
				 worker_card_info.put("worker_name", this.getParameter("worker_name"));
				 worker_card_info.put("worker_cardno", this.getParameter("worker_cardno"));
				 worker_card_info.put("worker_carddate", this.getParameter("worker_carddate"));
				 this.getSession().setAttribute("worker_card_info", worker_card_info);
				 mes.put("fw", "0");
			 }else{
				 Map<String,String> margs=new HashMap<String,String>();
				 margs.put("worker_no", fw.getWorker_no());
				 margs.put("worker_carddate",this.getParameter("worker_carddate"));
				 freeWorkerService.update("updateCardDate",margs);
				 fw=freeWorkerService.getOne("getOne",fw.getWorker_no());
				 this.getSession().setAttribute("freeworker", fw);
				 mes.put("fw", "1");
			 }
			
			 return this.success("操作成功");
		}
	/**
	 * ********************************************************
	 * @Title: getMobileCode
	 * @Description: 获取短信验证码
	 * @return String
	 * @date 2020-10-15 下午 02:51:38 
	 ********************************************************
	 */
		 @RequestMapping("/getMobileCode")
		public @ResponseBody Map getMobileCode(String mobile){
			  String pattern ="^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$";
	          boolean isMatch = Pattern.matches(pattern, mobile);
	          if(!isMatch){
	        	  return this.error("您的手机号填写有误");
	          }
//			Integer mobileNum=freeWorkerService.getNumber("getMobileCount",mobile);
//			if(mobileNum!=0){
//				return this.error("获取短信失败，您的手机号已经注册过");
//			}
			int num = (int) ((Math.random() * 9 + 1) * 100000);
			try {
				SendSmsResponse response = SmsDemo.sendSms(mobile,num+"");
				logger.info("手机号:"+mobile+"短信验证码:"+num);
				logger.info("Code=" + response.getCode());
				logger.info("Message=" + response.getMessage());
				logger.info("RequestId=" + response.getRequestId());
				logger.info("BizId=" + response.getBizId());
				System.out.println("短信验证码:"+num);
				System.out.println("Code=" + response.getCode());
				System.out.println("Message=" + response.getMessage());
				System.out.println("RequestId=" + response.getRequestId());
				System.out.println("BizId=" + response.getBizId());
				 if(response.getCode() != null && response.getCode().equals("OK")){
					this.getSession().setMaxInactiveInterval(smsMinute*60);
					this.getSession().setAttribute(mobile, num+"");
					return success("【成功】短信验证码发送成功","");
				 }else{
					 return error("【失败】短信验证码发送失败");
				 }
			} catch (ClientException e) {
				e.printStackTrace();
				logger.error(e);
				return this.error("发送到手机"+mobile+"失败");
			}
		
		}
	 
		 /**
			 * ********************************************************
			 * @Title: save
			 * @Description: 短信验证码登录
			 * @return String
			 * @date 2020-10-15 下午 02:51:38 
			 ********************************************************
			 */
			 @RequestMapping("/checkMobileCode")
			public @ResponseBody Map checkMobileCode(){
					String smscode=this.getParameter("smscode");
					String mobile=this.getParameter("worker_mobile");
					String session_code=this.getSession().getAttribute(mobile)!=null?this.getSession().getAttribute(mobile).toString():"";
					if(!session_code.equals(smscode)){
						this.getSession().removeAttribute(mobile);
						return error("短信验证码填写错误，请重新获取");
					}
				    FreeWorker fw=freeWorkerService.getOne("getOneByMobile",mobile);
				 if(fw!=null){
//						String openId=this.getOpenId();
//						Map<String,Object> userInfo=WeChatUtils.getUserInfo(openId);
//						System.out.println(userInfo);
//						fw.setWechat_head_img(userInfo.get("headimgurl").toString());
//						fw.setWechat_nickname(userInfo.get("nickname").toString());
//						fw.setWechat_open_id(openId);
				    	this.getSession().setAttribute("freeworker",fw);
				    	checkAgent(fw);
						Map<String,String> updateArgs=new HashMap<String,String>();
						updateArgs.put("worker_no", fw.getWorker_no());
//						updateArgs.put("wechat_open_id",openId);
//						updateArgs.put("wechat_head_img",userInfo.get("headimgurl").toString());
//						updateArgs.put("wechat_nickname",userInfo.get("nickname").toString());
						freeWorkerService.update("updateWechatInfo",updateArgs);
						mes.put("freeworker", "1");
						return this.success("短信验证验证正确");
				    }else{
				    	mes.put("freeworker", "0");
				    	this.getSession().setAttribute("mobile", mobile);
				    	 return this.success("短信验证成功，进行注册下一步");
				    }
				   
			}


	@RequestMapping(value = "/loginOut")
	public void loginOut(){
		FreeWorker fw=(FreeWorker) this.getSession().getAttribute("freeworker");
		String worker_no=fw.getWorker_no();
		freeWorkerService.update("AirOpentWechat_open_id",worker_no);
		Enumeration em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		this.memCached.clearAllCache();
		String out=WeChatUtils.netUrl+"FreeWorker/login";
		System.out.println(out);
		try {
			response.sendRedirect(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ********************************************************
	 * @Title: look_reg
	 * @Description: 我的信息
	 * @return String
	 * @date 2020-10-15 下午 02:51:38
	 ********************************************************
	 */
	@RequestMapping("look_reg")
	public String look_reg(){
		return this.display();
	}

}

