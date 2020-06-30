package com.cafe24.dk4750.miniMarket.vo;

public class MemberReview {
	private int memberReviewNo;
	private String memberReviewContent;
	private String memberId;
	private String memberUniqueNo;
	private String memberReviewDate;
	
	// 겟터 셋터
	public int getMemberReviewNo() {
		return memberReviewNo;
	}
	public void setMemberReviewNo(int memberReviewNo) {
		this.memberReviewNo = memberReviewNo;
	}
	public String getMemberReviewContent() {
		return memberReviewContent;
	}
	public void setMemberReviewContent(String memberReviewContent) {
		this.memberReviewContent = memberReviewContent;
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
	public String getMemberReviewDate() {
		return memberReviewDate;
	}
	public void setMemberReviewDate(String memberReviewDate) {
		this.memberReviewDate = memberReviewDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberReview [memberReviewNo=" + memberReviewNo + ", memberReviewContent=" + memberReviewContent
				+ ", memberId=" + memberId + ", memberUniqueNo=" + memberUniqueNo + ", memberReviewDate="
				+ memberReviewDate + "]";
	}
}
