
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: Food
* @Description: 食品表
* @author 自动生成
* @date 2020-04-08 下午 04:58:46 
*******************************************************
*/
@SuppressWarnings("all")
public class Food {

	private String food_name;		//餐品名称
	private String belong_menu_id;		//所属菜单种类id(如饭 饮品) 预留字段
	private String food_describe;		//餐品描述
	private Integer status;		//状态(0正常 1下架)
	private Integer food_time;		//餐品用餐时间段（0早 1中 2晚）
	private Double food_price;		//餐品价格
	private String food_id;		//餐品编号
	private String add_time;		//添加时间
	private Double cost_price;		//成本价

	public Double getCost_price() {
		return cost_price;
	}

	public void setCost_price(Double cost_price) {
		this.cost_price = cost_price;
	}

	public String getFood_name() {
		return this.food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getBelong_menu_id() {
		return this.belong_menu_id;
	}

	public void setBelong_menu_id(String belong_menu_id) {
		this.belong_menu_id = belong_menu_id;
	}

	public String getFood_describe() {
		return this.food_describe;
	}

	public void setFood_describe(String food_describe) {
		this.food_describe = food_describe;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getFood_time() {
		return this.food_time;
	}

	public void setFood_time(Integer food_time) {
		this.food_time = food_time;
	}

	public Double getFood_price() {
		return this.food_price;
	}

	public void setFood_price(Double food_price) {
		this.food_price = food_price;
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

}

