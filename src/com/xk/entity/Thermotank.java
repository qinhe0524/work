
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: Thermotank
* @Description: 餐品柜表
* @author 自动生成
* @date 2020-04-08 下午 04:54:14 
*******************************************************
*/
@SuppressWarnings("all")
public class Thermotank {

	private String thermotank_coordinate;		//取餐柜坐标
	private String thermotank_location;		//取餐柜地址
	private Integer status;		//状态(0禁用 1启用)
	private String add_time;		//添加时间
	private String thermotank_name;		//取餐柜名称
	private String thermotank_id;		//取餐柜编号 
	private String id;		//取餐柜编号 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThermotank_coordinate() {
		return this.thermotank_coordinate;
	}

	public void setThermotank_coordinate(String thermotank_coordinate) {
		this.thermotank_coordinate = thermotank_coordinate;
	}

	public String getThermotank_location() {
		return this.thermotank_location;
	}

	public void setThermotank_location(String thermotank_location) {
		this.thermotank_location = thermotank_location;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAdd_time() {
		return this.add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public String getThermotank_name() {
		return this.thermotank_name;
	}

	public void setThermotank_name(String thermotank_name) {
		this.thermotank_name = thermotank_name;
	}

	public String getThermotank_id() {
		return this.thermotank_id;
	}

	public void setThermotank_id(String thermotank_id) {
		this.thermotank_id = thermotank_id;
	}

}

