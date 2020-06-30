package com.cafe24.dk4750.miniMarket.vo;

public class ItemSoldoutAndMemberItemAndMemberItemPic {
	// soldout 속성
	private int soldoutNo;
	private int memberItemNo;
	private String memberUniqueNo;
	private String soldoutDate;
	// memberItem 속성
	private String memberItemTitle;
	private String categoryName;
	private String memberItemPrice;
	private String memberItemContent;
	private String memberItemDate;
	private String memberItemState;
	// memberItemPic 속성
	private int picNo;
	private String memberItemPic;
	private String memberId;
	private String picDate;
	
	// 겟터 셋터
	public int getSoldoutNo() {
		return soldoutNo;
	}
	public void setSoldoutNo(int soldoutNo) {
		this.soldoutNo = soldoutNo;
	}
	public int getMemberItemNo() {
		return memberItemNo;
	}
	public void setMemberItemNo(int memberItemNo) {
		this.memberItemNo = memberItemNo;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getSoldoutDate() {
		return soldoutDate;
	}
	public void setSoldoutDate(String soldoutDate) {
		this.soldoutDate = soldoutDate;
	}
	public String getMemberItemTitle() {
		return memberItemTitle;
	}
	public void setMemberItemTitle(String memberItemTitle) {
		this.memberItemTitle = memberItemTitle;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getMemberItemPrice() {
		return memberItemPrice;
	}
	public void setMemberItemPrice(String memberItemPrice) {
		this.memberItemPrice = memberItemPrice;
	}
	public String getMemberItemContent() {
		return memberItemContent;
	}
	public void setMemberItemContent(String memberItemContent) {
		this.memberItemContent = memberItemContent;
	}
	public String getMemberItemDate() {
		return memberItemDate;
	}
	public void setMemberItemDate(String memberItemDate) {
		this.memberItemDate = memberItemDate;
	}
	public String getMemberItemState() {
		return memberItemState;
	}
	public void setMemberItemState(String memberItemState) {
		this.memberItemState = memberItemState;
	}
	public int getPicNo() {
		return picNo;
	}
	public void setPicNo(int picNo) {
		this.picNo = picNo;
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
		return "ItemSoldoutAndMemberItemAndMemberItemPic [soldoutNo=" + soldoutNo + ", memberItemNo=" + memberItemNo
				+ ", memberUniqueNo=" + memberUniqueNo + ", soldoutDate=" + soldoutDate + ", memberItemTitle="
				+ memberItemTitle + ", categoryName=" + categoryName + ", memberItemPrice=" + memberItemPrice
				+ ", memberItemContent=" + memberItemContent + ", memberItemDate=" + memberItemDate
				+ ", memberItemState=" + memberItemState + ", picNo=" + picNo + ", memberItemPic=" + memberItemPic
				+ ", memberId=" + memberId + ", picDate=" + picDate + "]";
	}
}
