package com.cafe24.dk4750.miniMarket.vo;

public class CompanyItemLike {
	private int likeNo;
	private String likeActive;
	private String memberUniqueNo;
	private int companyItemNo;
	
	// 겟터 셋터
	public int getLikeNo() {
		return likeNo;
	}
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
	public int getCompanyItemNo() {
		return companyItemNo;
	}
	public void setCompanyItemNo(int companyItemNo) {
		this.companyItemNo = companyItemNo;
	}
	
	// toString
	@Override
	public String toString() {
		return "CompanyItemLike [likeNo=" + likeNo + ", likeActive=" + likeActive + ", memberUniqueNo=" + memberUniqueNo
				+ ", companyItemNo=" + companyItemNo + "]";
	}
}
