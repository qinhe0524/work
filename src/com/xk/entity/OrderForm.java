
package com.xk.entity;

import java.util.Date;

/**
* ********************************************************
* @ClassName: OrderForm
* @Description: 支付订单表
* @author 自动生成
* @date 2020-04-08 下午 04:56:34 
*******************************************************
*/
@SuppressWarnings("all")
public class OrderForm {

	private String buyer_id;		//买家账号
	private String trade_no;		//交易上游流水号
	private String begin_time;		//生成订单时间
	private String open_id;		//买家id
	private Integer status;		//状态(0待付款 1已付款 2已撤单 3申请撤单 4部分退款 5已退款 6交易关闭 7系统保留:查询时使用,同时查询退款和撤单记录 8退款中:平台未返回退款结果 9退款失败 10待退款  11 取消支付  12 支付时效过期)
	private String refund_time;		//退款时间
	private String pay_subject;		//订单主题
	private String qr_code;		//付款链接(上游返回的支付链接)
	private String channel_trade_no;		//渠道订单号(展示在用户端,可能退款要用)
	private String phone_code;		//商户订单号(展示在用户端,可能退款要用)
	private Integer deal_type;		//处理类型(0异步 1主动查询)
	private String out_refund_no;		//退款单号
	private String out_trade_no;		//上送订单号(唯一)
	private Integer channel_type;		//交易渠道类型(1支付宝 2微信 3花呗 4云闪付)
	private String end_time;		//支付时间
	private Double total_fee;		//交易总金额
	private Double refund_money;		//退款金额
	private String bank_type;		//银行类型
	private String deal_time;		//处理时间

	public String getBuyer_id() {
		return this.buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getTrade_no() {
		return this.trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getBegin_time() {
		return this.begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getOpen_id() {
		return this.open_id;
	}

	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRefund_time() {
		return this.refund_time;
	}

	public void setRefund_time(String refund_time) {
		this.refund_time = refund_time;
	}

	public String getPay_subject() {
		return this.pay_subject;
	}

	public void setPay_subject(String pay_subject) {
		this.pay_subject = pay_subject;
	}

	public String getQr_code() {
		return this.qr_code;
	}

	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}

	public String getChannel_trade_no() {
		return this.channel_trade_no;
	}

	public void setChannel_trade_no(String channel_trade_no) {
		this.channel_trade_no = channel_trade_no;
	}

	public String getPhone_code() {
		return this.phone_code;
	}

	public void setPhone_code(String phone_code) {
		this.phone_code = phone_code;
	}

	public Integer getDeal_type() {
		return this.deal_type;
	}

	public void setDeal_type(Integer deal_type) {
		this.deal_type = deal_type;
	}

	public String getOut_refund_no() {
		return this.out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public String getOut_trade_no() {
		return this.out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public Integer getChannel_type() {
		return this.channel_type;
	}

	public void setChannel_type(Integer channel_type) {
		this.channel_type = channel_type;
	}

	public String getEnd_time() {
		return this.end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public Double getTotal_fee() {
		return this.total_fee;
	}

	public void setTotal_fee(Double total_fee) {
		this.total_fee = total_fee;
	}

	public Double getRefund_money() {
		return this.refund_money;
	}

	public void setRefund_money(Double refund_money) {
		this.refund_money = refund_money;
	}

	public String getBank_type() {
		return this.bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getDeal_time() {
		return this.deal_time;
	}

	public void setDeal_time(String deal_time) {
		this.deal_time = deal_time;
	}

}

