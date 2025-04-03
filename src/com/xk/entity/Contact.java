
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: Contact
* @Description: 联系人
* @author 自动生成
* @date 2020-10-18 下午 09:43:39 
*******************************************************
*/
@SuppressWarnings("all")
public class Contact {

	private Integer contact_object_type;		//类型 0客户、1代理商
	private String con_sex;		//性别
	private Integer con_order_num;		//主次排序
	private String con_card_no;		//身份证号
	private String contact_no;		//联系人编号C000001
	private Integer con_status;		//状态（-1删除，0禁用，1启用）
	private String con_mobile;		//手机号
	private String con_phone;		//座机
	private String con_work_address;		//通讯地址
	private String con_wechat;		//微信号
	private String con_provice;		//省份
	private Integer id;		//
	private String con_object_no;		//关联对象编号
	private String contact_rim;		//备注
	private String contact_name;		//联系人名称
	private String con_birthday;		//出生日期
	private Integer contact_type;		//联系人类型 0客户，1代理，2渠道
	private String con_email;		//邮箱

	public Integer getContact_object_type() {
		return this.contact_object_type;
	}

	public void setContact_object_type(Integer contact_object_type) {
		this.contact_object_type = contact_object_type;
	}

	public String getCon_sex() {
		return this.con_sex;
	}

	public void setCon_sex(String con_sex) {
		this.con_sex = con_sex;
	}

	public Integer getCon_order_num() {
		return this.con_order_num;
	}

	public void setCon_order_num(Integer con_order_num) {
		this.con_order_num = con_order_num;
	}

	public String getCon_card_no() {
		return this.con_card_no;
	}

	public void setCon_card_no(String con_card_no) {
		this.con_card_no = con_card_no;
	}

	public String getContact_no() {
		return this.contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public Integer getCon_status() {
		return this.con_status;
	}

	public void setCon_status(Integer con_status) {
		this.con_status = con_status;
	}

	public String getCon_mobile() {
		return this.con_mobile;
	}

	public void setCon_mobile(String con_mobile) {
		this.con_mobile = con_mobile;
	}

	public String getCon_phone() {
		return this.con_phone;
	}

	public void setCon_phone(String con_phone) {
		this.con_phone = con_phone;
	}

	public String getCon_work_address() {
		return this.con_work_address;
	}

	public void setCon_work_address(String con_work_address) {
		this.con_work_address = con_work_address;
	}

	public String getCon_wechat() {
		return this.con_wechat;
	}

	public void setCon_wechat(String con_wechat) {
		this.con_wechat = con_wechat;
	}

	public String getCon_provice() {
		return this.con_provice;
	}

	public void setCon_provice(String con_provice) {
		this.con_provice = con_provice;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCon_object_no() {
		return this.con_object_no;
	}

	public void setCon_object_no(String con_object_no) {
		this.con_object_no = con_object_no;
	}

	public String getContact_rim() {
		return this.contact_rim;
	}

	public void setContact_rim(String contact_rim) {
		this.contact_rim = contact_rim;
	}

	public String getContact_name() {
		return this.contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getCon_birthday() {
		return this.con_birthday;
	}

	public void setCon_birthday(String con_birthday) {
		this.con_birthday = con_birthday;
	}

	public Integer getContact_type() {
		return this.contact_type;
	}

	public void setContact_type(Integer contact_type) {
		this.contact_type = contact_type;
	}

	public String getCon_email() {
		return this.con_email;
	}

	public void setCon_email(String con_email) {
		this.con_email = con_email;
	}

}

