package com.xml.bank;

public class SubOrderInfo {
	 private String orderid;//֧��������
	 private String amount;//�������
	 private String installmentTimes;//���ڸ�������1��3��6��9��12��18��24��1����ȫ���
	 private String merAcct;//�̻��˺�
	 private String tranSerialNo;//����ָ�����
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
