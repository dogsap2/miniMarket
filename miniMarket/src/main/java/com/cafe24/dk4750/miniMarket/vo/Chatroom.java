package com.cafe24.dk4750.miniMarket.vo;

public class Chatroom {
	private int chatroomNo;
	private String memberUniqueNo;
	private String memberId;
	private String chatroomCheck;
	private String chatroomActive;
	
	// 겟터 셋터
	public int getChatroomNo() {
		return chatroomNo;
	}
	public void setChatroomNo(int chatroomNo) {
		this.chatroomNo = chatroomNo;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getChatroomCheck() {
		return chatroomCheck;
	}
	public void setChatroomCheck(String chatroomCheck) {
		this.chatroomCheck = chatroomCheck;
	}
	public String getChatroomActive() {
		return chatroomActive;
	}
	public void setChatroomActive(String chatroomActive) {
		this.chatroomActive = chatroomActive;
	}
	
	// toString
	@Override
	public String toString() {
		return "Chatroom [chatroomNo=" + chatroomNo + ", memberUniqueNo=" + memberUniqueNo + ", memberId=" + memberId
				+ ", chatroomCheck=" + chatroomCheck + ", chatroomActive=" + chatroomActive + "]";
	}
}
