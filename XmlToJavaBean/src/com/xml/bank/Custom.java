package com.xml.bank;

public class Custom {
	private String verifyJoinFlag;//检验联名标志
    private String JoinFlag;//客户联名标志
    private String UserNum;//联名会员号
	public String getVerifyJoinFlag() {
		return verifyJoinFlag;
	}
	public void setVerifyJoinFlag(String verifyJoinFlag) {
		this.verifyJoinFlag = verifyJoinFlag;
	}
	public String getJoinFlag() {
		return JoinFlag;
	}
	public void setJoinFlag(String joinFlag) {
		JoinFlag = joinFlag;
	}
	public String getUserNum() {
		return UserNum;
	}
	public void setUserNum(String userNum) {
		UserNum = userNum;
	}
    
}
