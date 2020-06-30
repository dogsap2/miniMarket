package com.cafe24.dk4750.miniMarket.vo;

public class MemberItemLike {
	private int likeNo;
	private String likeActive;
	private String memberUniqueNo;
	private int memberItemNo;
	public int getLikeNo() {
		return likeNo;
	}
	
	// 겟터 셋터
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public String getLikeActive() {
		return likeActive;
	}
	public void setLikeActive(String likeActive) {
		this.likeActive = likeActive;
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
		return "MemberItemLike [likeNo=" + likeNo + ", likeActive=" + likeActive + ", memberUniqueNo=" + memberUniqueNo
				+ ", memberItemNo=" + memberItemNo + "]";
	}
	
}
