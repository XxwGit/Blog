package com.xml.bank;

public class OrderInfo {
	 private String orderDate;
	 private String curType;
	 private String merID;
	 private SubOrderInfo[] subOrderInfoList; //List<SubOrderInfo> subOrderInfoList; �˴�Ҳ��������д
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getCurType() {
		return curType;
	}
	public void setCurType(String curType) {
		this.curType = curType;
	}
	public String getMerID() {
		return merID;
	}
	public void setMerID(String merID) {
		this.merID = merID;
	}
	public SubOrderInfo[] getSubOrderInfoList() {
		return subOrderInfoList;
	}
	public void setSubOrderInfoList(SubOrderInfo[] subOrderInfoList) {
		this.subOrderInfoList = subOrderInfoList;
	}
	 
}
