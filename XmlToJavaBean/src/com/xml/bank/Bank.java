package com.xml.bank;

public class Bank {
	private String TranBatchNo;//���κ�
	private String notifyDate;//����֪ͨ����ʱ�� YYYYMMDDHHmmss
	private String tranStat;//��������״̬ 1-���׳ɹ��������� 2-����ʧ�� 3-���׿���
	private String comment;//��ע
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
