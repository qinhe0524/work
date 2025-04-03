
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: Area
* @Description: 地区信息表
* @author 自动生成
* @date 2016-01-23 上午 11:11:45 
*******************************************************
*/
@SuppressWarnings("all")
public class Area {

	private Integer area_id;		//主键
	private Integer area_code;		//地区编码
	private String area_name;		//地区名称
	private Integer area_status;		//使用状态
	private String parent_id;		//父类编号

	public Integer getArea_id() {
		return this.area_id;
	}

	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}

	public Integer getArea_code() {
		return this.area_code;
	}

	public void setArea_code(Integer area_code) {
		this.area_code = area_code;
	}

	public String getArea_name() {
		return this.area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public Integer getArea_status() {
		return this.area_status;
	}

	public void setArea_status(Integer area_status) {
		this.area_status = area_status;
	}

	public String getParent_id() {
		return this.parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

}

