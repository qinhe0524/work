
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: CheckPerson
* @Description: 身份验证记录
* @author 自动生成
* @date 2020-11-01 下午 06:18:18 
*******************************************************
*/
@SuppressWarnings("all")
public class CheckPerson {

	private Integer id;		//
	private Integer ck_channel;		//渠道编号
	private String ck_cardno;		//身份证号
	private String ck_mobile;		//手机号
	private String ck_name;		//姓名
	private String ck_rtcode;		//通道返回的状态
	private Date add_date;		//日期
	private String ck_bankcard;		//银行卡号
	private Integer ck_result;		//是否成功
	private Date add_time;		//时间
	private String ck_ip;		//上送的IP
	private String ck_msg;		//信息

	public String getCk_msg() {
		return ck_msg;
	}

	public void setCk_msg(String ck_msg) {
		this.ck_msg = ck_msg;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCk_channel() {
		return this.ck_channel;
	}

	public void setCk_channel(Integer ck_channel) {
		this.ck_channel = ck_channel;
	}

	public String getCk_cardno() {
		return this.ck_cardno;
	}

	public void setCk_cardno(String ck_cardno) {
		this.ck_cardno = ck_cardno;
	}

	public String getCk_mobile() {
		return this.ck_mobile;
	}

	public void setCk_mobile(String ck_mobile) {
		this.ck_mobile = ck_mobile;
	}

	public String getCk_name() {
		return this.ck_name;
	}

	public void setCk_name(String ck_name) {
		this.ck_name = ck_name;
	}

	public String getCk_rtcode() {
		return this.ck_rtcode;
	}

	public void setCk_rtcode(String ck_rtcode) {
		this.ck_rtcode = ck_rtcode;
	}

	public Date getAdd_date() {
		return this.add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	public String getCk_bankcard() {
		return this.ck_bankcard;
	}

	public void setCk_bankcard(String ck_bankcard) {
		this.ck_bankcard = ck_bankcard;
	}

	public Integer getCk_result() {
		return this.ck_result;
	}

	public void setCk_result(Integer ck_result) {
		this.ck_result = ck_result;
	}

	public Date getAdd_time() {
		return this.add_time;
	}

	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}

	public String getCk_ip() {
		return this.ck_ip;
	}

	public void setCk_ip(String ck_ip) {
		this.ck_ip = ck_ip;
	}

	@Override
	public String toString() {
		return "CheckPerson{" +
				"id=" + id +
				", ck_channel=" + ck_channel +
				", ck_cardno='" + ck_cardno + '\'' +
				", ck_mobile='" + ck_mobile + '\'' +
				", ck_name='" + ck_name + '\'' +
				", ck_rtcode='" + ck_rtcode + '\'' +
				", add_date=" + add_date +
				", ck_bankcard='" + ck_bankcard + '\'' +
				", ck_result=" + ck_result +
				", add_time=" + add_time +
				", ck_ip='" + ck_ip + '\'' +
				'}';
	}
}

