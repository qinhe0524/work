
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: ClientsArgs
* @Description: 客户参数
* @author 自动生成
* @date 2020-10-22 下午 04:53:27 
*******************************************************
*/
@SuppressWarnings("all")
public class ClientsArgs {

	private String passwords;		//登录密码
	private String login_mobile;		//登录手机号
	private String client_no;		//客户编号
	private Integer id;		//
	private Integer pay_model;		//交易模式  0网页模式，1接口模式，2都支持
	private String max_money;		//最大限额
	private String cps_num;		//结算点
	private Double min_money;		//最小限额
	private String work_email;		//业务邮箱
	private String pay_channel;		//交易渠道
	private Double pay_charge;		//代付单笔手续费
	private String white_ips;		//ip白名单
	private String rsa_key;		//秘钥

	public String getPasswords() {
		return this.passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getLogin_mobile() {
		return this.login_mobile;
	}

	public void setLogin_mobile(String login_mobile) {
		this.login_mobile = login_mobile;
	}

	public String getClient_no() {
		return this.client_no;
	}

	public void setClient_no(String client_no) {
		this.client_no = client_no;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPay_model() {
		return this.pay_model;
	}

	public void setPay_model(Integer pay_model) {
		this.pay_model = pay_model;
	}

	public String getMax_money() {
		return this.max_money;
	}

	public void setMax_money(String max_money) {
		this.max_money = max_money;
	}

	public String getCps_num() {
		return this.cps_num;
	}

	public void setCps_num(String cps_num) {
		this.cps_num = cps_num;
	}

	public Double getMin_money() {
		return this.min_money;
	}

	public void setMin_money(Double min_money) {
		this.min_money = min_money;
	}

	public String getWork_email() {
		return this.work_email;
	}

	public void setWork_email(String work_email) {
		this.work_email = work_email;
	}

	public String getPay_channel() {
		return this.pay_channel;
	}

	public void setPay_channel(String pay_channel) {
		this.pay_channel = pay_channel;
	}

	public Double getPay_charge() {
		return this.pay_charge;
	}

	public void setPay_charge(Double pay_charge) {
		this.pay_charge = pay_charge;
	}

	public String getWhite_ips() {
		return this.white_ips;
	}

	public void setWhite_ips(String white_ips) {
		this.white_ips = white_ips;
	}

	public String getRsa_key() {
		return this.rsa_key;
	}

	public void setRsa_key(String rsa_key) {
		this.rsa_key = rsa_key;
	}

}

