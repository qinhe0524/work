
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: AgentAgent
* @Description: 代理关系表
* @author 自动生成
* @date 2020-12-16 下午 01:48:41 
*******************************************************
*/
@SuppressWarnings("all")
public class AgentAgent {

	private Integer id;		//
	private String parent_no;		//所属业务代理
	private Integer is_direct;		//是否直接代理
	private Integer agent_level;		//代理层级
	private String agent_no;		//代理编号

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParent_no() {
		return this.parent_no;
	}

	public void setParent_no(String parent_no) {
		this.parent_no = parent_no;
	}

	public Integer getIs_direct() {
		return this.is_direct;
	}

	public void setIs_direct(Integer is_direct) {
		this.is_direct = is_direct;
	}

	public Integer getAgent_level() {
		return this.agent_level;
	}

	public void setAgent_level(Integer agent_level) {
		this.agent_level = agent_level;
	}

	public String getAgent_no() {
		return this.agent_no;
	}

	public void setAgent_no(String agent_no) {
		this.agent_no = agent_no;
	}

}

