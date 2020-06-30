package com.cafe24.dk4750.miniMarket.vo;

public class Manner {
	private int mannerNo;
	private int goodManner;
	private int badManner;
	private String mannerDate;
	private String mannerContent;
	private String memberId;
	private String memberUniqueNo;
	private int memberItemNo;
	
	// 겟터 셋터
	public int getMannerNo() {
		return mannerNo;
	}
	public void setMannerNo(int mannerNo) {
		this.mannerNo = mannerNo;
	}
	public int getGoodManner() {
		return goodManner;
	}
	public void setGoodManner(int goodManner) {
		this.goodManner = goodManner;
	}
	public int getBadManner() {
		return badManner;
	}
	public void setBadManner(int badManner) {
		this.badManner = badManner;
	}
	public String getMannerDate() {
		return mannerDate;
	}
	public void setMannerDate(String mannerDate) {
		this.mannerDate = mannerDate;
	}
	public String getMannerContent() {
		return mannerContent;
	}
	public void setMannerContent(String mannerContent) {
		this.mannerContent = mannerContent;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public int getMemberItemNo() {
		return memberItemNo;
	}
	public void setMemberItemNo(int memberItemNo) {
		this.memberItemNo = memberItemNo;
	}
	
	// toString
	@Override
	public String toString() {
		return "Manner [mannerNo=" + mannerNo + ", goodManner=" + goodManner + ", badManner=" + badManner
				+ ", mannerDate=" + mannerDate + ", mannerContent=" + mannerContent + ", memberId=" + memberId
				+ ", memberUniqueNo=" + memberUniqueNo + ", memberItemNo=" + memberItemNo + "]";
	}
}
