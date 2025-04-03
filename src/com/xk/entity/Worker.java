
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: Worker
* @Description: 补餐员工表
* @author 自动生成
* @date 2020-04-08 下午 04:52:02 
*******************************************************
*/
@SuppressWarnings("all")
public class Worker {

	private String worker_name;		//员工姓名
	private String worker_login_id;		//员工登录账号
	private Integer status;		//(0禁用 1启用)
	private Integer worker_id;		//员工id
	private String worker_login_password;		//员工登录密码

	public String getWorker_name() {
		return this.worker_name;
	}

	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}

	public String getWorker_login_id() {
		return this.worker_login_id;
	}

	public void setWorker_login_id(String worker_login_id) {
		this.worker_login_id = worker_login_id;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getWorker_id() {
		return this.worker_id;
	}

	public void setWorker_id(Integer worker_id) {
		this.worker_id = worker_id;
	}

	public String getWorker_login_password() {
		return this.worker_login_password;
	}

	public void setWorker_login_password(String worker_login_password) {
		this.worker_login_password = worker_login_password;
	}

}

