package com.cafe24.dk4750.miniMarket.vo;

public class Chatroom {
	private int chatroomNo;
	private String memberUniqueNo;
	private String memberId;
	private String chatroomActive;
	private int memberItemNo;
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
	public String getChatroomActive() {
		return chatroomActive;
	}
	public void setChatroomActive(String chatroomActive) {
		this.chatroomActive = chatroomActive;
	}
	public int getMemberItemNo() {
		return memberItemNo;
	}
	public void setMemberItemNo(int memberItemNo) {
		this.memberItemNo = memberItemNo;
	}
	@Override
	public String toString() {
		return "Chatroom [chatroomNo=" + chatroomNo + ", memberUniqueNo=" + memberUniqueNo + ", memberId=" + memberId
				+ ", chatroomActive=" + chatroomActive + ", memberItemNo=" + memberItemNo + "]";
	}
	
}
