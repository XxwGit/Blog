package com.xml.bank;

public class SubOrderInfo {
	 private String orderid;//支付订单号
	 private String amount;//订单金额
	 private String installmentTimes;//分期付款期数1、3、6、9、12、18、24；1代表全额付款
	 private String merAcct;//商户账号
	 private String tranSerialNo;//银行指令序号
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getInstallmentTimes() {
		return installmentTimes;
	}
	public void setInstallmentTimes(String installmentTimes) {
		this.installmentTimes = installmentTimes;
	}
	public String getMerAcct() {
		return merAcct;
	}
	public void setMerAcct(String merAcct) {
		this.merAcct = merAcct;
	}
	public String getTranSerialNo() {
		return tranSerialNo;
	}
	public void setTranSerialNo(String tranSerialNo) {
		this.tranSerialNo = tranSerialNo;
	}
	 
}
