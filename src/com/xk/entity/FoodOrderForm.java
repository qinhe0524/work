
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: FoodOrderForm
* @Description: 餐品订单表
* @author 自动生成
* @date 2020-04-08 下午 04:57:25 
*******************************************************
*/
@SuppressWarnings("all")
public class FoodOrderForm {

	private Double food_trade_fee;		//订单金额
	private String food_trade_user_name;		//取餐人姓名
	private Date begin_time;		//用餐日期
	private Integer status;		//订单状态(0未处理 1已接单 2配餐中(数目不等,但已经有了) 3已备餐完毕(数目相等)  4已取餐 5失效 6退订)
	private String remark;		//备注
	private String food_trade_code;		//取餐链接(取餐码)
	private String food_trade_no;		//订单编号
	private String openid;		//用户openid
	private String food_trade_user_phone;		//手机号
	private String add_time;		//生成订单时间
	private String out_trade_no;		//上送订单号（支付订单号）
	private String thermotank_id;		//设备编号

	public Double getFood_trade_fee() {
		return this.food_trade_fee;
	}

	public void setFood_trade_fee(Double food_trade_fee) {
		this.food_trade_fee = food_trade_fee;
	}

	public String getFood_trade_user_name() {
		return this.food_trade_user_name;
	}

	public void setFood_trade_user_name(String food_trade_user_name) {
		this.food_trade_user_name = food_trade_user_name;
	}

	public Date getBegin_time() {
		return this.begin_time;
	}

	public void setBegin_time(Date begin_time) {
		this.begin_time = begin_time;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFood_trade_code() {
		return this.food_trade_code;
	}

	public void setFood_trade_code(String food_trade_code) {
		this.food_trade_code = food_trade_code;
	}

	public String getFood_trade_no() {
		return this.food_trade_no;
	}

	public void setFood_trade_no(String food_trade_no) {
		this.food_trade_no = food_trade_no;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getFood_trade_user_phone() {
		return this.food_trade_user_phone;
	}

	public void setFood_trade_user_phone(String food_trade_user_phone) {
		this.food_trade_user_phone = food_trade_user_phone;
	}

	public String getAdd_time() {
		return this.add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public String getOut_trade_no() {
		return this.out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getThermotank_id() {
		return this.thermotank_id;
	}

	public void setThermotank_id(String thermotank_id) {
		this.thermotank_id = thermotank_id;
	}

}

