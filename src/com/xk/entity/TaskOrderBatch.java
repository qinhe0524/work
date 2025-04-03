
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: TaskOrderBatch
* @Description: 任务单批次
* @author 自动生成
* @date 2020-10-26 下午 10:44:14 
*******************************************************
*/
@SuppressWarnings("all")
public class TaskOrderBatch {

	private Integer order_batch_status;		//批次状态0待送审，1待审核，2待结算，3结算中，4已结算，-1已关闭
	private Integer pay_err_num;		//支付失败笔数
	private String pay_suc_amt;		//成功金额
	private Date add_date;		//添加日期
	private String client_no;		//客户编号
	private String service_amt;		//实际服务费
	private String task_no;		//任务单号
	private Integer id;		//
	private Integer order_num;		//订单数
	private String pay_suc_num;		//支付成功笔数
	private String sizeup_service_amt;		//预计服务费
	private String order_batch_no;		//任务单批次
	private Date add_time;		//添加时间
	private String batch_amt;		//批次总金额
	private String pay_err_amt;		//支付失败金额
	public Integer getOrder_batch_status() {
		return order_batch_status;
	}
	public void setOrder_batch_status(Integer order_batch_status) {
		this.order_batch_status = order_batch_status;
	}
	public Integer getPay_err_num() {
		return pay_err_num;
	}
	public void setPay_err_num(Integer pay_err_num) {
		this.pay_err_num = pay_err_num;
	}
	public String getPay_suc_amt() {
		return pay_suc_amt;
	}
	public void setPay_suc_amt(String pay_suc_amt) {
		this.pay_suc_amt = pay_suc_amt;
	}
	public Date getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}
	public String getClient_no() {
		return client_no;
	}
	public void setClient_no(String client_no) {
		this.client_no = client_no;
	}
	public String getService_amt() {
		return service_amt;
	}
	public void setService_amt(String service_amt) {
		this.service_amt = service_amt;
	}
	public String getTask_no() {
		return task_no;
	}
	public void setTask_no(String task_no) {
		this.task_no = task_no;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrder_num() {
		return order_num;
	}
	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}
	public String getPay_suc_num() {
		return pay_suc_num;
	}
	public void setPay_suc_num(String pay_suc_num) {
		this.pay_suc_num = pay_suc_num;
	}
	public String getSizeup_service_amt() {
		return sizeup_service_amt;
	}
	public void setSizeup_service_amt(String sizeup_service_amt) {
		this.sizeup_service_amt = sizeup_service_amt;
	}
	public String getOrder_batch_no() {
		return order_batch_no;
	}
	public void setOrder_batch_no(String order_batch_no) {
		this.order_batch_no = order_batch_no;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public String getBatch_amt() {
		return batch_amt;
	}
	public void setBatch_amt(String batch_amt) {
		this.batch_amt = batch_amt;
	}
	public String getPay_err_amt() {
		return pay_err_amt;
	}
	public void setPay_err_amt(String pay_err_amt) {
		this.pay_err_amt = pay_err_amt;
	}

}

