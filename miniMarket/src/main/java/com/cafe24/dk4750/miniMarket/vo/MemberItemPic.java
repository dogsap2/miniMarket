package com.cafe24.dk4750.miniMarket.vo;

public class MemberItemPic {
	private int picNo;
	private int memberItemNo;
	private String memberItemPic;
	private String memberId;
	private String picDate;
	
	// 겟터 셋터
	public int getPicNo() {
		return picNo;
	}
	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}
	public int getMemberItemNo() {
		return memberItemNo;
	}
	public void setMemberItemNo(int memberItemNo) {
		this.memberItemNo = memberItemNo;
	}
	public String getMemberItemPic() {
		return memberItemPic;
	}
	public void setMemberItemPic(String memberItemPic) {
		this.memberItemPic = memberItemPic;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPicDate() {
		return picDate;
	}
	public void setPicDate(String picDate) {
		this.picDate = picDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberItemPic [picNo=" + picNo + ", memberItemNo=" + memberItemNo + ", memberItemPic=" + memberItemPic
				+ ", memberId=" + memberId + ", picDate=" + picDate + "]";
	}
}
