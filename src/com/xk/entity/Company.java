
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: Company
* @Description: 客户公司信息
* @author 自动生成
* @date 2020-10-18 下午 11:54:13 
*******************************************************
*/
@SuppressWarnings("all")
public class Company {

	private String com_work_address;		//工作地址
	private Integer com_object_type;		//公司类型0代理商1客户
	private String com_true_person_cardno_date;		//真实控制人身份证有效期
	private String com_true_person;		//真实控制人
	private String com_legal_person_cardno;		//法人身份证
	private Integer id;		//
	private String com_legal_person_cardno_date;		//法人身份证有效期
	private String com_scope;		//经营范围
	private String com_remark;		//公司描述
	private String company_name;		//企业全称
	private String com_true_person_cardno;		//真实控制人身份证
	private String com_legal_person;		//法人
	private String com_object_no;		//对象编号
	private String com_blis_no;		//营业执照号

	public String getCom_work_address() {
		return this.com_work_address;
	}

	public void setCom_work_address(String com_work_address) {
		this.com_work_address = com_work_address;
	}

	public Integer getCom_object_type() {
		return this.com_object_type;
	}

	public void setCom_object_type(Integer com_object_type) {
		this.com_object_type = com_object_type;
	}

	public String getCom_true_person_cardno_date() {
		return this.com_true_person_cardno_date;
	}

	public void setCom_true_person_cardno_date(String com_true_person_cardno_date) {
		this.com_true_person_cardno_date = com_true_person_cardno_date;
	}

	public String getCom_true_person() {
		return this.com_true_person;
	}

	public void setCom_true_person(String com_true_person) {
		this.com_true_person = com_true_person;
	}

	public String getCom_legal_person_cardno() {
		return this.com_legal_person_cardno;
	}

	public void setCom_legal_person_cardno(String com_legal_person_cardno) {
		this.com_legal_person_cardno = com_legal_person_cardno;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCom_legal_person_cardno_date() {
		return this.com_legal_person_cardno_date;
	}

	public void setCom_legal_person_cardno_date(String com_legal_person_cardno_date) {
		this.com_legal_person_cardno_date = com_legal_person_cardno_date;
	}

	public String getCom_scope() {
		return this.com_scope;
	}

	public void setCom_scope(String com_scope) {
		this.com_scope = com_scope;
	}

	public String getCom_remark() {
		return this.com_remark;
	}

	public void setCom_remark(String com_remark) {
		this.com_remark = com_remark;
	}

	public String getCompany_name() {
		return this.company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCom_true_person_cardno() {
		return this.com_true_person_cardno;
	}

	public void setCom_true_person_cardno(String com_true_person_cardno) {
		this.com_true_person_cardno = com_true_person_cardno;
	}

	public String getCom_legal_person() {
		return this.com_legal_person;
	}

	public void setCom_legal_person(String com_legal_person) {
		this.com_legal_person = com_legal_person;
	}

	public String getCom_object_no() {
		return this.com_object_no;
	}

	public void setCom_object_no(String com_object_no) {
		this.com_object_no = com_object_no;
	}

	public String getCom_blis_no() {
		return this.com_blis_no;
	}

	public void setCom_blis_no(String com_blis_no) {
		this.com_blis_no = com_blis_no;
	}

}

