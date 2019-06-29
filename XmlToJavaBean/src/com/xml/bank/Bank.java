package com.xml.bank;

public class Bank {
	private String TranBatchNo;//批次号
	private String notifyDate;//返回通知日期时间 YYYYMMDDHHmmss
	private String tranStat;//订单处理状态 1-交易成功，已清算 2-交易失败 3-交易可疑
	private String comment;//备注
	public String getTranBatchNo() {
		return TranBatchNo;
	}
	public void setTranBatchNo(String tranBatchNo) {
		TranBatchNo = tranBatchNo;
	}
	public String getNotifyDate() {
		return notifyDate;
	}
	public void setNotifyDate(String notifyDate) {
		this.notifyDate = notifyDate;
	}
	public String getTranStat() {
		return tranStat;
	}
	public void setTranStat(String tranStat) {
		this.tranStat = tranStat;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
