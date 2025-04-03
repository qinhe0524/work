
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: ThermotankAds
* @Description: 设备广告表
* @author 自动生成
* @date 2020-04-08 下午 04:53:58 
*******************************************************
*/
@SuppressWarnings("all")
public class ThermotankAds {

	private Integer ad_id;		//广告编号
	private Integer ad_type;		//(0主页顶部轮播图 1主页底部轮播图)
	private String thermotank_id;		//设备id

	public Integer getAd_id() {
		return this.ad_id;
	}

	public void setAd_id(Integer ad_id) {
		this.ad_id = ad_id;
	}

	public Integer getAd_type() {
		return this.ad_type;
	}

	public void setAd_type(Integer ad_type) {
		this.ad_type = ad_type;
	}

	public String getThermotank_id() {
		return this.thermotank_id;
	}

	public void setThermotank_id(String thermotank_id) {
		this.thermotank_id = thermotank_id;
	}

}

