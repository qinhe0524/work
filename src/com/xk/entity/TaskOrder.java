
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: TaskOrder
* @Description: 任务接单
* @author 自动生成
* @date 2020-10-26 下午 10:44:39 
*******************************************************
*/
@SuppressWarnings("all")
public class TaskOrder {

	private String task_order_no;		//任务接单号
	private String worker_bank_person;		//开户名
	private Date add_date;		//添加日期
	private String worker_bank_name;		//开户行
	private String worker_bank_num;		//银行卡号
	private String order_amt;		//订单金额
	private String service_amt;		//服务费
	private String task_no;		//任务号
	private Integer id;		//
	private String worker_no;		//自由职业编号
	private String worker_cardno;		//身份证号
	private Integer task_order_status;		//接单状态0待送审，1待审核，2待结算，3结算中，4已结算，-1已关闭
	private String pay_channel;		//支付渠道
	private String order_batch_no;		//批次号
	private Date add_time;		//时间
	private String pay_order_no;		//支付单号
	private String client_no;
	private String client_order_no;
	private String  task_order_rim;
	public String getTask_order_rim() {
		return task_order_rim;
	}

	public void setTask_order_rim(String task_order_rim) {
		this.task_order_rim = task_order_rim;
	}

	public String getClient_order_no() {
		return client_order_no;
	}

	public void setClient_order_no(String client_order_no) {
		this.client_order_no = client_order_no;
	}

	public String getClient_no() {
		return client_no;
	}

	public void setClient_no(String client_no) {
		this.client_no = client_no;
	}

	public String getTask_order_no() {
		return this.task_order_no;
	}

	public void setTask_order_no(String task_order_no) {
		this.task_order_no = task_order_no;
	}

	public String getWorker_bank_person() {
		return this.worker_bank_person;
	}

	public void setWorker_bank_person(String worker_bank_person) {
		this.worker_bank_person = worker_bank_person;
	}

	public Date getAdd_date() {
		return this.add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
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



	public String getOrder_amt() {
		return order_amt;
	}

	public void setOrder_amt(String order_amt) {
		this.order_amt = order_amt;
	}

	public String getService_amt() {
		return service_amt;
	}

	public void setService_amt(String service_amt) {
		this.service_amt = service_amt;
	}

	public void setWorker_bank_num(String worker_bank_num) {
		this.worker_bank_num = worker_bank_num;
	}

	public String getTask_no() {
		return this.task_no;
	}

	public void setTask_no(String task_no) {
		this.task_no = task_no;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getTask_order_status() {
		return this.task_order_status;
	}

	public void setTask_order_status(Integer task_order_status) {
		this.task_order_status = task_order_status;
	}

	public String getPay_channel() {
		return this.pay_channel;
	}

	public void setPay_channel(String pay_channel) {
		this.pay_channel = pay_channel;
	}

	public String getOrder_batch_no() {
		return this.order_batch_no;
	}

	public void setOrder_batch_no(String order_batch_no) {
		this.order_batch_no = order_batch_no;
	}

	public Date getAdd_time() {
		return this.add_time;
	}

	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}

	public String getPay_order_no() {
		return this.pay_order_no;
	}

	public void setPay_order_no(String pay_order_no) {
		this.pay_order_no = pay_order_no;
	}

}

