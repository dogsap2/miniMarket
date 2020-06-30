package com.cafe24.dk4750.miniMarket.vo;

public class Chat {
	private int chatNo;
	private String memberUniqueNo;
	private String memberId;
	private String chatMessage;
	private String chatDate;
	private int chatroomNo;
	private int memberItemNo;
	
	// 겟터 셋터
	public int getChatNo() {
		return chatNo;
	}
	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
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
	public String getChatMessage() {
		return chatMessage;
	}
	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}
	public String getChatDate() {
		return chatDate;
	}
	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}
	public int getChatroomNo() {
		return chatroomNo;
	}
	public void setChatroomNo(int chatroomNo) {
		this.chatroomNo = chatroomNo;
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
		return "Chat [chatNo=" + chatNo + ", memberUniqueNo=" + memberUniqueNo + ", memberId=" + memberId
				+ ", chatMessage=" + chatMessage + ", chatDate=" + chatDate + ", chatroomNo=" + chatroomNo
				+ ", memberItemNo=" + memberItemNo + "]";
	}
}
