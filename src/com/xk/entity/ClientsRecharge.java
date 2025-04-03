
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: ClientsRecharge
* @Description: 客户充值记录
* @author 自动生成
* @date 2020-10-23 上午 01:00:52 
*******************************************************
*/
@SuppressWarnings("all")
public class ClientsRecharge {

	private String passtime;		//审核时间
	private String recharge_no;		//充值流水号
	private String adduser;		//添加人
	private String remit_name;		//来款方名
	private String passuser;		//审核人
	private String client_no;		//客户编号
	private String recharge_status;		//状态0待送审，1送审，2生效，-1作废
	private Integer id;		//
	private Double amount;		//金额
	private String add_time;		//添加时间
	private String add_date;
	private String pay_channel;		//充值通道
	private String remit_account;		//来款账号
	private String channel_recharge_no;		//通道流水号
	public String getRecharge_rim() {
		return recharge_rim;
	}

	public void setRecharge_rim(String recharge_rim) {
		this.recharge_rim = recharge_rim;
	}

	private String recharge_rim;

	
	public String getAdd_time() {
		return add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public String getAdd_date() {
		return add_date;
	}

	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}

	public String getRecharge_no() {
		return this.recharge_no;
	}

	public void setRecharge_no(String recharge_no) {
		this.recharge_no = recharge_no;
	}

	public String getAdduser() {
		return this.adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}

	public String getRemit_name() {
		return this.remit_name;
	}

	public void setRemit_name(String remit_name) {
		this.remit_name = remit_name;
	}

	public String getPassuser() {
		return this.passuser;
	}

	public void setPassuser(String passuser) {
		this.passuser = passuser;
	}

	public String getClient_no() {
		return this.client_no;
	}

	public void setClient_no(String client_no) {
		this.client_no = client_no;
	}

	public String getRecharge_status() {
		return this.recharge_status;
	}

	public void setRecharge_status(String recharge_status) {
		this.recharge_status = recharge_status;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getPasstime() {
		return passtime;
	}

	public void setPasstime(String passtime) {
		this.passtime = passtime;
	}


	public String getPay_channel() {
		return this.pay_channel;
	}

	public void setPay_channel(String pay_channel) {
		this.pay_channel = pay_channel;
	}

	public String getRemit_account() {
		return this.remit_account;
	}

	public void setRemit_account(String remit_account) {
		this.remit_account = remit_account;
	}

	public String getChannel_recharge_no() {
		return this.channel_recharge_no;
	}

	public void setChannel_recharge_no(String channel_recharge_no) {
		this.channel_recharge_no = channel_recharge_no;
	}

}

