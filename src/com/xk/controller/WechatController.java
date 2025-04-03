
package com.xk.controller;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.util.WeChatUtils;

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
@RequestMapping("/Wechat")
public class WechatController extends BaseController{



	/**
	 * ********************************************************
	 * @Title: 服务器认证
	 * @Description: 微信服务器验证
	 * @return String
	 * @date 2020-10-15 下午 02:51:38 
	 ********************************************************
	 */
	 @RequestMapping("/serverCheck")
	public @ResponseBody String serverCheck(){
		String signature=this.getParameter("signature");
		String timestamp=this.getParameter("timestamp");
		String nonce=this.getParameter("nonce");
		String echostr=this.getParameter("echostr");
		if(WeChatUtils.checkSignature(signature, timestamp, nonce)){;
			 return echostr;
		}
		return "err";
	}
	
	 
	/**
	 * ********************************************************
	 * @Title: 获取授权
	 * @Description: 获取授权
	 * @return String
	 * @date 2020-10-15 下午 02:51:38 
	 ********************************************************
	 */
	 @RequestMapping("/loginWechat")
	 public void loginWechat(){
		 System.out.println("开始了额");
		 if(this.getParameter("code")!=null&&!this.getParameter("code").equals(""))
		 {
		     String openId=this.getOpenId();
			 //Map<String,Object> userInfo=WeChatUtils.getUserInfo(openId);
			 this.getSession().setAttribute("openId", openId);
			 try {
				response.sendRedirect(WeChatUtils.netUrl+this.getParameter("url").toString());
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}


	 

	 
		
}

