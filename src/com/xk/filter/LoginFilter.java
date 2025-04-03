
package com.xk.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.xk.Encryption.EncryptionDES;
import com.xk.entity.FreeWorker;
import com.xk.entity.UserInfo;
import com.xk.service.FreeWorkerService;
import com.xk.util.MemCached;
import com.xk.util.Utils;
import com.xk.util.WeChatUtils;
import com.xk.util.XssRequestWrapper;
@SuppressWarnings("all")
public class LoginFilter extends OncePerRequestFilter{

//	private static Logger logger=Logger.getLogger(String.valueOf(LoginFilter.class));

	@Override
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterchain)throws ServletException,IOException {
		//获取请求路径
		String uri = request.getRequestURI();
//		logger.info("filter==>请求路径："+uri);
		try {
			String openId=request.getSession().getAttribute("openId")==null?"":request.getSession().getAttribute("openId").toString();
//			logger.info("filter==>openId："+openId);
			if(openId.equals("")&& !uri.endsWith(".jsp") && !uri.endsWith(".css")
					&& !uri.endsWith(".js") && !uri.endsWith(".png")
					&& !uri.endsWith(".pdf")
					&& !uri.endsWith(".txt")
					&& !uri.endsWith(".jpeg") && !uri.endsWith(".jpg")
					&&!uri.endsWith("/publicGetRealData")&&!uri.endsWith("serverCheck/")&&!uri.endsWith(".woff2")&&!uri.endsWith("Wechat/loginWechat") && !uri.endsWith(".bmp") && !uri.endsWith(".gif")){
			
				uri=uri.replace("/partwechat/", "");
				String redirect_uri=WeChatUtils.netUrl+"Wechat/loginWechat?url="+uri;
				redirect_uri=URLEncoder.encode(redirect_uri);				
				String oauth2Url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WeChatUtils.appId+"&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";	
				//snsapi_base snsapi_userinfo
				//System.out.println(uri);
//				logger.info("filter==>oauth2Url:"+oauth2Url);
				response.sendRedirect(oauth2Url);
				return;
			}else{
				if(uri.indexOf("my")!=-1&&uri.indexOf(".")==-1){
					FreeWorker fw=(FreeWorker) request.getSession().getAttribute("freeworker");
//					logger.info("filter==>fw:"+fw);
				    if(fw==null||fw.equals("")){
				    	String login=WeChatUtils.netUrl+"FreeWorker/login";
//						logger.info("filter==>login:"+login);
						response.sendRedirect(login);
				    }else if(fw.getWorker_carddate()==null||fw.getWorker_carddate().equals("")){
				    	String add_idcard=WeChatUtils.netUrl+"FreeWorker/add_idcard";
//						logger.info("filter==>add_idcard:"+add_idcard);
						response.sendRedirect(add_idcard);
				    }
				}
				filterchain.doFilter(request, response);
			}
		} catch (Exception e) {
			//异常，跳转到错误界面
			e.printStackTrace();
		}
	}
}

	
