
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: FreeWorker
* @Description: 自由职业者
* @author 自动生成
* @date 2020-10-15 下午 02:51:38 
*******************************************************
*/
@SuppressWarnings("all")
public class FreeWorker {
    private String id;


	private String worker_city; 
	private String worker_no;		//编号
	private String worker_cardno;		//身份证号
	private String worker_bank_person;		//开户名
	private Integer worker_status;		//状态
	private String worker_name;		//姓名
	private String worker_bank_name;		//开户行
	private String worker_bank_num;		//银行卡号
	private String worker_regedit_time;		//添加时间
	private String worker_regedit_date;		//添加时间
	private String worker_mobile;		//手机号
	private String worker_province;		//省份
	private String wechat_nickname;
	private String wechat_open_id;
	private String wechat_head_img;
	private String worker_carddate;
	
	public String getWorker_carddate() {
		return worker_carddate;
	}

	public void setWorker_carddate(String worker_carddate) {
		this.worker_carddate = worker_carddate;
	}

	public String getWechat_nickname() {
		return wechat_nickname;
	}

	public void setWechat_nickname(String wechat_nickname) {
		this.wechat_nickname = wechat_nickname;
	}

	public String getWechat_open_id() {
		return wechat_open_id;
	}

	public void setWechat_open_id(String wechat_open_id) {
		this.wechat_open_id = wechat_open_id;
	}
	public String getWechat_head_img() {
		return wechat_head_img;
	}

	public void setWechat_head_img(String wechat_head_img) {
		this.wechat_head_img = wechat_head_img;
	}

	public String getWorker_city() {
		return worker_city;
	}

	public void setWorker_city(String worker_city) {
		this.worker_city = worker_city;
	}
	public String getWorker_no() {
		return this.worker_no;
	}

	public void setWorker_no(String worker_no) {
		this.worker_no = worker_no;
	}

	public String getWorker_cardno() {
		return this.worker_cardno;
	}

	public void setWorker_cardno(String worker_cardno) {
		this.worker_cardno = worker_cardno;
	}

	public String getWorker_bank_person() {
		return this.worker_bank_person;
	}

	public void setWorker_bank_person(String worker_bank_person) {
		this.worker_bank_person = worker_bank_person;
	}

	public Integer getWorker_status() {
		return this.worker_status;
	}

	public void setWorker_status(Integer worker_status) {
		this.worker_status = worker_status;
	}

	public String getWorker_name() {
		return this.worker_name;
	}

	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}

	public String getWorker_bank_name() {
		return this.worker_bank_name;
	}

	public void setWorker_bank_name(String worker_bank_name) {
		this.worker_bank_name = worker_bank_name;
	}

	public String getWorker_bank_num() {
		return this.worker_bank_num;
	}

	public void setWorker_bank_num(String worker_bank_num) {
		this.worker_bank_num = worker_bank_num;
	}

	public String getWorker_regedit_time() {
		return this.worker_regedit_time;
	}

	public void setWorker_regedit_time(String worker_regedit_time) {
		this.worker_regedit_time = worker_regedit_time;
	}
	
	public String getWorker_regedit_date() {
		return this.worker_regedit_date;
	}

	public void setWorker_regedit_date(String worker_regedit_date) {
		this.worker_regedit_date = worker_regedit_date;
	}

	public String getWorker_mobile() {
		return this.worker_mobile;
	}

	public void setWorker_mobile(String worker_mobile) {
		this.worker_mobile = worker_mobile;
	}

	public String getWorker_province() {
		return this.worker_province;
	}

	public void setWorker_province(String worker_province) {
		this.worker_province = worker_province;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "FreeWorker{" +
				"id='" + id + '\'' +
				", worker_city='" + worker_city + '\'' +
				", worker_no='" + worker_no + '\'' +
				", worker_cardno='" + worker_cardno + '\'' +
				", worker_bank_person='" + worker_bank_person + '\'' +
				", worker_status=" + worker_status +
				", worker_name='" + worker_name + '\'' +
				", worker_bank_name='" + worker_bank_name + '\'' +
				", worker_bank_num='" + worker_bank_num + '\'' +
				", worker_regedit_time='" + worker_regedit_time + '\'' +
				", worker_regedit_date='" + worker_regedit_date + '\'' +
				", worker_mobile='" + worker_mobile + '\'' +
				", worker_province='" + worker_province + '\'' +
				", wechat_nickname='" + wechat_nickname + '\'' +
				", wechat_open_id='" + wechat_open_id + '\'' +
				", wechat_head_img='" + wechat_head_img + '\'' +
				", worker_carddate='" + worker_carddate + '\'' +
				'}';
	}
}

