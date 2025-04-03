
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: TakeOutFood
* @Description: 取餐记录表
* @author 自动生成
* @date 2020-04-08 下午 04:55:29 
*******************************************************
*/
@SuppressWarnings("all")
public class TakeOutFood {

	private String thermotank_door_id;		//柜门id
	private String food_id;		//餐品id
	private String add_time;		//取餐时间
	private String order_id;		//订单编号
	private String worker_id;		//取餐人openid
	private Integer type;		//(0正常出餐 1损耗(补餐员取出) )

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

	public String getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getWorker_id() {
		return this.worker_id;
	}

	public void setWorker_id(String worker_id) {
		this.worker_id = worker_id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}

