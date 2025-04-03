
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: FoodOrderFormDetail
* @Description: 餐品订单详情表
* @author 自动生成
* @date 2020-04-08 下午 04:58:32 
*******************************************************
*/
@SuppressWarnings("all")
public class FoodOrderFormDetail {

	private Integer food_num;		//餐品数量
	private String food_trade_no;		//订单编号
	private String food_id;		//餐品编号
	private Integer store_food_num;		//已备餐数量

	public Integer getFood_num() {
		return this.food_num;
	}

	public void setFood_num(Integer food_num) {
		this.food_num = food_num;
	}

	public String getFood_trade_no() {
		return this.food_trade_no;
	}

	public void setFood_trade_no(String food_trade_no) {
		this.food_trade_no = food_trade_no;
	}

	public String getFood_id() {
		return this.food_id;
	}

	public void setFood_id(String food_id) {
		this.food_id = food_id;
	}

	public Integer getStore_food_num() {
		return this.store_food_num;
	}

	public void setStore_food_num(Integer store_food_num) {
		this.store_food_num = store_food_num;
	}

}

