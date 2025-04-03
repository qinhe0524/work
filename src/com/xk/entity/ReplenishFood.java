
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: ReplenishFood
* @Description: 补餐记录表
* @author 自动生成
* @date 2020-04-08 下午 04:55:44 
*******************************************************
*/
@SuppressWarnings("all")
public class ReplenishFood {

	private String thermotank_door_id;		//柜门id
	private String food_id;		//餐品id
	private String add_time;		//添加时间
	private String worker_id;		//工作人员id

	public String getThermotank_door_id() {
		return this.thermotank_door_id;
	}

	public void setThermotank_door_id(String thermotank_door_id) {
		this.thermotank_door_id = thermotank_door_id;
	}

	public String getFood_id() {
		return this.food_id;
	}

	public void setFood_id(String food_id) {
		this.food_id = food_id;
	}

	public String getAdd_time() {
		return this.add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public String getWorker_id() {
		return this.worker_id;
	}

	public void setWorker_id(String worker_id) {
		this.worker_id = worker_id;
	}

}

