package com.cafe24.dk4750.miniMarket.vo;

public class MemberTempTotal {
	private int tempTotalNo;
	private String memberId;
	private double memberTempTotal;
	private String memberTempDate;
	
	// 겟터 셋터
	public int getTempTotalNo() {
		return tempTotalNo;
	}
	public void setTempTotalNo(int tempTotalNo) {
		this.tempTotalNo = tempTotalNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public double getMemberTempTotal() {
		return memberTempTotal;
	}
	public void setMemberTempTotal(double memberTempTotal) {
		this.memberTempTotal = memberTempTotal;
	}
	public String getMemberTempDate() {
		return memberTempDate;
	}
	public void setMemberTempDate(String memberTempDate) {
		this.memberTempDate = memberTempDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberTempTotal [tempTotalNo=" + tempTotalNo + ", memberId=" + memberId + ", memberTempTotal="
				+ memberTempTotal + ", memberTempDate=" + memberTempDate + "]";
	}
}
