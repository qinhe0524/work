package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: Agent
* @Description: 代理表
* @author 自动生成
* @date 2020-10-08 下午 11:49:02 
*******************************************************
*/
@SuppressWarnings("all")
public class Agent {

	private String pagent_no;		//父级代理编号（一级0）
	private Integer agent_level;		//层级
	private Integer status;		//状态（-1停用、0意向、1正式）
	private String adduser;		//添加人
	private String short_name;		//简称
	private String trade_type;		//资源行业（可逗号隔开）
	private String city;		//城市
	private Integer client_num;		//签约客户数
	private String addtime;		//添加时间
	private String area;		//地区
	private String clerk;		//所属业务员用户名
	private String province;		//省份
	private Integer iscompany;		//代理性质（0个人，1公司）
	private String agent_no;		//代理编号(A0001)
	private String agent_name;		//代理名称
	private Integer total_money;		//总交易
	private String agent_label;     //代理标签
	private Integer cps_type;     //提成类型
	private String cps_num;     //提成数
	private String worker_no;
	public String getWorker_no() {
		return worker_no;
	}

	public void setWorker_no(String worker_no) {
		this.worker_no = worker_no;
	}

	public Integer getCps_type() {
		return cps_type;
	}

	public void setCps_type(Integer cps_type) {
		this.cps_type = cps_type;
	}

	public String getCps_num() {
		return cps_num;
	}

	public void setCps_num(String cps_num) {
		this.cps_num = cps_num;
	}


	
	public String getAgent_label() {
		return this.agent_label;
	}

	public void setAgent_label(String agent_label) {
		this.agent_label = agent_label;
	}

	public String getPagent_no() {
		return this.pagent_no;
	}

	public void setPagent_no(String pagent_no) {
		this.pagent_no = pagent_no;
	}

	public Integer getAgent_level() {
		return this.agent_level;
	}

	public void setAgent_level(Integer agent_level) {
		this.agent_level = agent_level;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAdduser() {
		return this.adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}

	public String getShort_name() {
		return this.short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
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

	public Integer getClient_num() {
		return this.client_num;
	}

	public void setClient_num(Integer client_num) {
		this.client_num = client_num;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
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

	public Integer getIscompany() {
		return this.iscompany;
	}

	public void setIscompany(Integer iscompany) {
		this.iscompany = iscompany;
	}

	public String getAgent_no() {
		return this.agent_no;
	}

	public void setAgent_no(String agent_no) {
		this.agent_no = agent_no;
	}

	public String getAgent_name() {
		return this.agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}


	public Integer getTotal_money() {
		return this.total_money;
	}

	public void setTotal_money(Integer total_money) {
		this.total_money = total_money;
	}

}

