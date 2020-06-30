package com.cafe24.dk4750.miniMarket.vo;

public class LoginMember {
	private String memberId;
	private String memberPw; 
	private String memberUniqueNo;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	
	@Override
	public String toString() {
		return "LoginMember [memberId=" + memberId + ", memberPw=" + memberPw + ", memberUniqueNo=" + memberUniqueNo
				+ "]";
	} 
	
	
}
