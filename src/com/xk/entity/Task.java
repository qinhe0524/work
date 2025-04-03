
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: Task
* @Description: 任务
* @author 自动生成
* @date 2020-10-25 上午 12:00:35 
*******************************************************
*/
@SuppressWarnings("all")
public class Task {
	private String task_rim;		//任务描述
	private String task_province;		//省份
	private String task_name;		//任务名称
	private String task_city;		//任务城市
	private Integer task_status;		//任务状态
	private Integer task_type;		//任务类型
	private String client_no;		//客户编号
	private String task_no;		//任务编号
	private Integer budget_amt;		//预算金额
	private String end_date;		//结束日期
	private String task_condition;		//任务条件
	private String add_time;		//建立日期
	private String start_date;		//开始日期
	private String settlement_method;		//结算方式
	private Integer is_show;		//是否前端显示

	public String getSettlement_method() {
		return settlement_method;
	}

	public void setSettlement_method(String settlement_method) {
		this.settlement_method = settlement_method;
	}

	public String getTask_rim() {
		return this.task_rim;
	}

	public Integer getIs_show() {
		return is_show;
	}

	public void setIs_show(Integer is_show) {
		this.is_show = is_show;
	}

	public void setTask_rim(String task_rim) {
		this.task_rim = task_rim;
	}

	public String getTask_province() {
		return this.task_province;
	}

	public void setTask_province(String task_province) {
		this.task_province = task_province;
	}

	public String getTask_name() {
		return this.task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_city() {
		return this.task_city;
	}

	public void setTask_city(String task_city) {
		this.task_city = task_city;
	}

	public Integer getTask_status() {
		return this.task_status;
	}

	public void setTask_status(Integer task_status) {
		this.task_status = task_status;
	}

	public Integer getTask_type() {
		return this.task_type;
	}

	public void setTask_type(Integer task_type) {
		this.task_type = task_type;
	}

	public String getClient_no() {
		return this.client_no;
	}

	public void setClient_no(String client_no) {
		this.client_no = client_no;
	}

	public String getTask_no() {
		return this.task_no;
	}

	public void setTask_no(String task_no) {
		this.task_no = task_no;
	}

	public Integer getBudget_amt() {
		return this.budget_amt;
	}

	public void setBudget_amt(Integer budget_amt) {
		this.budget_amt = budget_amt;
	}



	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getTask_condition() {
		return this.task_condition;
	}

	public void setTask_condition(String task_condition) {
		this.task_condition = task_condition;
	}


	public String getAdd_time() {
		return add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}



}

