
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: ThermotankDoor
* @Description: 餐品柜门表
* @author 自动生成
* @date 2020-04-08 下午 04:53:38 
*******************************************************
*/
@SuppressWarnings("all")
public class ThermotankDoor {

	private String store_food_id;		//存放餐品编号
	private Integer status;		//状态(0禁用 1启用)
	private String belong_thermotank_id;		//所属餐柜id
	private String thermotank_door_id;		//取餐柜柜门id(主键)
	private String thermotank_door_no;		//取餐柜柜门编号
	private String add_time;		//添加时间
	private String action_time;		//变动时间

	public String getStore_food_id() {
		return this.store_food_id;
	}

	public void setStore_food_id(String store_food_id) {
		this.store_food_id = store_food_id;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBelong_thermotank_id() {
		return this.belong_thermotank_id;
	}

	public void setBelong_thermotank_id(String belong_thermotank_id) {
		this.belong_thermotank_id = belong_thermotank_id;
	}

	public String getThermotank_door_id() {
		return this.thermotank_door_id;
	}

	public void setThermotank_door_id(String thermotank_door_id) {
		this.thermotank_door_id = thermotank_door_id;
	}

	public String getThermotank_door_no() {
		return this.thermotank_door_no;
	}

	public void setThermotank_door_no(String thermotank_door_no) {
		this.thermotank_door_no = thermotank_door_no;
	}

	public String getAdd_time() {
		return this.add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public String getAction_time() {
		return this.action_time;
	}

	public void setAction_time(String action_time) {
		this.action_time = action_time;
	}

}

