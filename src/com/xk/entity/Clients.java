
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: Clients
* @Description: 客户主表
* @author 自动生成
* @date 2020-10-20 上午 01:04:05 
*******************************************************
*/
@SuppressWarnings("all")
public class Clients {

	private String last_action;		//最后互动时间
	private String client_short_name;		//简称
	private String status;		//-1删除，0未审核，1待审核，2启用
	private Date last_deal;		//最后交易日期
	private String adduser;		//添加人
	private String client_no;		//客户编号C0001
	private String client_label;		//客户标签
	private String trade_type;		//所属行业
	private String city;		//城市
	private String addtime;		//添加时间
	private String cps_num;		//结算点
	private String area;		//地区
	private String clerk;		//所属业务员
	private String province;		//省份
	private String agent_no;		//代理编号
	private String client_name;		//客户名称
	private Integer total_money;		//总交易额

	public String getLast_action() {
		return this.last_action;
	}

	public void setLast_action(String last_action) {
		this.last_action = last_action;
	}

	public String getClient_short_name() {
		return this.client_short_name;
	}

	public void setClient_short_name(String client_short_name) {
		this.client_short_name = client_short_name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLast_deal() {
		return this.last_deal;
	}

	public void setLast_deal(Date last_deal) {
		this.last_deal = last_deal;
	}

	public String getAdduser() {
		return this.adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}

	public String getClient_no() {
		return this.client_no;
	}

	public void setClient_no(String client_no) {
		this.client_no = client_no;
	}

	public String getClient_label() {
		return this.client_label;
	}

	public void setClient_label(String client_label) {
		this.client_label = client_label;
	}

	public String getTrade_type() {
		return this.trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getCps_num() {
		return this.cps_num;
	}

	public void setCps_num(String cps_num) {
		this.cps_num = cps_num;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getClerk() {
		return this.clerk;
	}

	public void setClerk(String clerk) {
		this.clerk = clerk;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAgent_no() {
		return this.agent_no;
	}

	public void setAgent_no(String agent_no) {
		this.agent_no = agent_no;
	}

	public String getClient_name() {
		return this.client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public Integer getTotal_money() {
		return this.total_money;
	}

	public void setTotal_money(Integer total_money) {
		this.total_money = total_money;
	}

}

