
package com.xk.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xk.entity.Clients;
import com.xk.entity.ClientsArgs;
import com.xk.entity.UserInfo;
import com.xk.dao.CarteDao;
import com.xk.dao.ClientsArgsDao;
import com.xk.dao.ClientsDao;
import com.xk.dao.UserInfoDao;
import com.xk.service.UserInfoService;

import com.xk.util.DateUtil;

import com.xk.util.CommonUtil;

import com.xk.util.Encryption;
import com.xk.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ********************************************************
* @ClassName: UserInfoServiceImpl
* @Description: 用户信息
* @author 自动生成
* @date 2016-01-12 下午 04:34:32 
*******************************************************
*/
@SuppressWarnings("all")
@Service
@Transactional
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo,Integer> implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private CarteDao carteDao;//菜单
	@Autowired
	private ClientsDao clientsDao;//菜单
	@Autowired
	private ClientsArgsDao clientsArgsDao;//菜单
	@Autowired
	public void setBaseDao(UserInfoDao uDao) {
		super.setBaseDao(userInfoDao);
	}
	/**
	  * 
	  *********************************************************
	  * @Title: loginUser
	  * @Description: 用户登陆
	  * @date 2016-1-13
	  ********************************************************
	 */
	@Transactional
	public String loginUser(Map<String, String> map,HttpServletRequest request) throws Exception {
		//获取session验证码
//		String sesssionCode=(String) request.getSession().getAttribute("randomCode");
//		String code=map.get("code");
//		//判断验证码是否相等
//		if(null!=code && null!=sesssionCode && !code.equalsIgnoreCase(sesssionCode)){
//			return "codeError";
//		}
//		//清空验证码
//		request.getSession().getAttribute("");
	    //调用登陆方法
		//System.out.println("user_code----------------"+map.get("user_code"));
		String regex = "^[1][3,4,5,7,8][0-9]{9}$";
		if(!map.get("user_code").matches(regex)){
			return "mobile_err";
		}
		map.put("user_pass", Encryption.MD5(map.get("user_pass")));
		UserInfo user=userInfoDao.getOne("loginUser",map);
        
		if(null!=user&& !"".equals(user)){
			//判断用户是否禁用
			if(null!=user.getStatus() && user.getStatus()==1){
			String client_no=user.getCompany_no();
			Clients clients=clientsDao.getOne(client_no);
			ClientsArgs clientsArgs=clientsArgsDao.getOne(client_no);
			System.out.println("clientsArgs-----------------------"+clientsArgs);
			request.getSession().setAttribute("clients", clients);
			request.getSession().setAttribute("clientsArgs", clientsArgs);
			 //当前ip
			 user.setLast_login_ip(Utils.getIp(request));
			 user.setLogin_num(user.getLogin_num()+1);
			 request.getSession().setAttribute("user", user);
			 Map<String,Object> updateData=new HashMap<String, Object>();
			 updateData.put("user_code", user.getUser_code());
			 updateData.put("last_login_ip", Utils.getIp(request));
			 updateData.put("last_login_date",DateUtil.getDayDateStr("yyyy-MM-dd HH:mm:ss"));
			 //修改登陆的信息
			 userInfoDao.update("updateInfo", updateData);
			 
			if(map.get("code")==null){
				//获取加密Key
				String key=CommonUtil.createRandomString(32);
				//删除缓存中的加密Key
				memCache.delete("encryKey_"+user.getUser_code());
				//把新的加密key放进缓存
				memCache.add("encryKey_"+user.getUser_code(), key);
			}
			//获取该用户的菜单
			Map<String,Object> userMap=new HashMap<String, Object>();
			userMap.put("user_code", user.getUser_code());
			userMap.put("system_tag", user.getSystem_tag());
			List<Map<String, Object>> userCarteList=null;
			if (user.getRole_no()==0) {//管理员
				userCarteList=carteDao.getList("getAllCarteByTag", user.getSystem_tag());
			}else{
				userCarteList=carteDao.getList("getCartebyUserCode", userMap);
			}
			
			//把该用户的菜单放进缓存中
			memCache.delete("userCarte"+user.getUser_code());
			memCache.delete("userBtn"+user.getUser_code());
			memCache.add("userCarte"+user.getUser_code(), userCarteList);
			 //用户登录成功
		     return "sucess";
			}else{
			 //用户已经禁用
		     return "stop";
			}
		}else{
			//没有查到该用户
			return "error";
		}
	}
	/**
	 * ********************************************************
	 * @Title: saveUserinfo
	 * @Description: 添加
	 * @return String
	 * @date 2016-01-12 下午 04:34:32 
	 ********************************************************
	 */
	public boolean saveUserinfo(String loginUser_code,UserInfo  userInfo) throws Exception{
		userInfo.setUser_pass(Encryption.MD5(userInfo.getUser_pass()));//密码加密
		userInfo.setSystem_tag(0);					//所属平台
		userInfo.setAdd_date(DateUtil.getDateFormate(new Date(), "yyyy-MM-dd HH:mm:ss"));			//添加日期
		userInfo.setAdd_user(loginUser_code);		//添加人
		userInfo.setStatus(1);						//启用状态
		if(null==userInfo.getQq()){
			userInfo.setQq("");						//QQ
		}
		if(null==userInfo.getEmail()){
			userInfo.setEmail("");					//Email
		}
		if(null==userInfo.getCookie()){
			userInfo.setCookie("");					//Cookie
		}
		if(null==userInfo.getLogin_num()){
			userInfo.setLogin_num(0);				//登录次数
		}
		if(null==userInfo.getLast_login_ip()){
			userInfo.setLast_login_ip("");			//登录ip
		}
		if(null==userInfo.getLast_login_date()){
			userInfo.setLast_login_date(DateUtil.getDateFormate(new Date(), "yyyy-MM-dd HH:mm:ss"));//最后登录时间
		}
		int result=userInfoDao.insert(userInfo);
		if(result>0){
			//判断  是否是业务员  添加开放业务员
			if(userInfo.getRole_no()==2){
////				OutsideUserInfo outuser=new OutsideUserInfo();
//				outuser.setAdd_date(userInfo.getAdd_date());
//				outuser.setAdd_user(userInfo.getAdd_user());
//				outuser.setLogin_num(userInfo.getLogin_num());
//				outuser.setLast_login_date(userInfo.getLast_login_date());
//				outuser.setLast_login_ip(userInfo.getLast_login_ip());
//				outuser.setLink_phone(userInfo.getLink_phone());
//				outuser.setUser_code(userInfo.getUser_code());
//				outuser.setUser_pass(userInfo.getUser_pass());
//				outuser.setReal_name(userInfo.getReal_name());
//				outuser.setRole_no(2);//业务员
//				outuser.setIs_admin(0);//0不是管理员
//				outuser.setStatus(1);//启用
//				outuser.setSystem_tag(userInfo.getSystem_tag());
//		        ResourceBundle rb=ResourceBundle.getBundle("commondata");
//				outuser.setBelong_no(rb.getString("belong_no"));
//				outuser.setSales_no(Integer.valueOf(rb.getString("sales_no")));
				int res=1;
//					outsideUserInfoDao.insert("insertbyrole",outuser);
				if (res==1) {
					return true;
				}else{
					userInfoDao.delete("deleteUser",userInfo.getUser_code());
					return false;
				}
			}
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ********************************************************
	 * @Title: deleteUser_info
	 * @Description: 删除
	 * @return Integer
	 * @date 2016-01-12 下午 04:34:32 
	 ********************************************************
	 */
	public Integer deleteUser_info(String loginUser_code,String user_code) throws Exception{
		if(loginUser_code.equals(user_code)){
			return 0;
		}
		int res=delete("deleteUser",user_code);
		return res;
	}
	/**
	 *********************************************************  
	 * @Title: updateUserinfo
	 * @Description: 更新用户 
	 * @return String
	 * @date 2016-1-14
	 ********************************************************
	 */
	public boolean updateUserinfo(UserInfo userInfo) throws Exception {
		UserInfo user=this.getOne(userInfo.getUser_code());
		user.setReal_name(userInfo.getReal_name());		//真实姓名
		user.setQq(userInfo.getQq());					//QQ
		user.setEmail(userInfo.getEmail());				//邮箱
		user.setLink_phone(userInfo.getLink_phone());	//电话
		user.setCompany_no(userInfo.getCompany_no());	//公司编号
		if(null==user.getLast_login_ip()){
			user.setLast_login_ip("");	//最后登录ip
		}
		if(null==user.getCookie()){
			user.setCookie("");			//cookie
		}
		int result=userInfoDao.update(user);
		if(result>0){
//			OutsideUserInfo outuser=outsideUserInfoDao.getOne("getOne",user.getUser_code());
//			if(null!=outuser){
//				outuser.setReal_name(user.getReal_name());
//				outuser.setLink_phone(user.getLink_phone());
//				int res=outsideUserInfoDao.update("updatebyrole", outuser);
//				if(res==1){
//					return true;
//				}else{
//					return false;
//				}
//			}
			return true;
		}else{
			return false;
		}
	}
	/**
	  *********************************************************  
	  * @Title: updateStatus
	  * @Description: 修改状态 0禁用  1启用  
	  * @return Map
	  * @date 2016-1-14
	  ********************************************************
	  */
	public boolean updateStatus(String loginUser_code, String user_code) throws Exception {
		UserInfo user=getOne("selectcode", user_code);
		if(user.getUser_code().equals(loginUser_code)){
			return false;
		}
		if(user.getStatus()==2){
			user.setStatus(1);//启用
		}else{
			user.setStatus(2);//注销
		}
		int res=this.update("updateStatus", user);
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	  *********************************************************  
	  * @Title: updatepass
	  * @Description: 重置密码
	  * @return Map
	  * @date 2016-1-26
	  ********************************************************
	  */
	public int updatepass(String user_code,String pwd) throws Exception {
		int result=0;
		Map<String,String> userMap=new HashMap<String, String>();
		userMap.put("user_code", user_code);
		userMap.put("user_pass", Encryption.MD5(pwd));
		result=userInfoDao.update("updatepass", userMap);
		return result;
	}
	
	
	
	
}

