package com.cafe24.dk4750.miniMarket.vo;

public class LoginMember {
	private String memberId;
	private String memberPw; 
	private String memberUniqueNo;
	private String memberNickname;
	
	
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
	
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNicname) {
		this.memberNickname = memberNicname;
	}
	@Override
	public String toString() {
		return "LoginMember [memberId=" + memberId + ", memberPw=" + memberPw + ", memberUniqueNo=" + memberUniqueNo
				+ ", memberNickname=" + memberNickname + "]";
	}
	
	
}
