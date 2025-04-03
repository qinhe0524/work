
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: ClientsAccount
* @Description: 客户账户
* @author 自动生成
* @date 2020-10-22 下午 11:28:07 
*******************************************************
*/
@SuppressWarnings("all")
public class ClientsAccount {

	private Double usable_money;		//可用余额
	private Double all_money;		//历史总金额
	private Double freeze_money;		//冻结金额
	private String add_date;		//开户时间
	private String client_no;		//客户编号
	private Integer acc_status;		//账户状态 0停用，1冻结，2正常
	private String last_action_date;		//最后变动日期
	private String check_var;		//校验值
	private Double total_money;		//总金额
	public String getAdd_date() {
		return add_date;
	}

	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}

	public String getLast_action_date() {
		return last_action_date;
	}

	public void setLast_action_date(String last_action_date) {
		this.last_action_date = last_action_date;
	}

	public Double getUsable_money() {
		return this.usable_money;
	}

	public void setUsable_money(Double usable_money) {
		this.usable_money = usable_money;
	}

	public Double getAll_money() {
		return this.all_money;
	}

	public void setAll_money(Double all_money) {
		this.all_money = all_money;
	}

	public Double getFreeze_money() {
		return this.freeze_money;
	}

	public void setFreeze_money(Double freeze_money) {
		this.freeze_money = freeze_money;
	}


	public String getClient_no() {
		return this.client_no;
	}

	public void setClient_no(String client_no) {
		this.client_no = client_no;
	}

	public Integer getAcc_status() {
		return this.acc_status;
	}

	public void setAcc_status(Integer acc_status) {
		this.acc_status = acc_status;
	}



	public String getCheck_var() {
		return this.check_var;
	}

	public void setCheck_var(String check_var) {
		this.check_var = check_var;
	}

	public Double getTotal_money() {
		return this.total_money;
	}

	public void setTotal_money(Double total_money) {
		this.total_money = total_money;
	}

}

