
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: ThermotankWorker
* @Description: 取餐柜管理员中间表
* @author 自动生成
* @date 2020-04-08 下午 04:52:43 
*******************************************************
*/
@SuppressWarnings("all")
public class ThermotankWorker {

	private Integer worker_type;		//员工类型(0补货员 1管理员)
	private Integer worker_id;		//员工编号
	private String thermotank_id;		//取餐柜id

	public Integer getWorker_type() {
		return this.worker_type;
	}

	public void setWorker_type(Integer worker_type) {
		this.worker_type = worker_type;
	}

	public Integer getWorker_id() {
		return this.worker_id;
	}

	public void setWorker_id(Integer worker_id) {
		this.worker_id = worker_id;
	}

	public String getThermotank_id() {
		return this.thermotank_id;
	}

	public void setThermotank_id(String thermotank_id) {
		this.thermotank_id = thermotank_id;
	}

}

