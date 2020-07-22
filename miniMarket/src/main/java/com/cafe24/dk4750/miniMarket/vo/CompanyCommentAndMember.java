package com.cafe24.dk4750.miniMarket.vo;

public class CompanyCommentAndMember {
	private int companyCommentNo;
	private String companyCommentContent;
	private String memberUniqueNo;
	private String memberNickname;
	private String companyCommentDate;
	private int companyItemNo;
	private String companyUniqueNo;
	public int getCompanyCommentNo() {
		return companyCommentNo;
	}
	public void setCompanyCommentNo(int companyCommentNo) {
		this.companyCommentNo = companyCommentNo;
	}
	public String getCompanyCommentContent() {
		return companyCommentContent;
	}
	public void setCompanyCommentContent(String companyCommentContent) {
		this.companyCommentContent = companyCommentContent;
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
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getCompanyCommentDate() {
		return companyCommentDate;
	}
	public void setCompanyCommentDate(String companyCommentDate) {
		this.companyCommentDate = companyCommentDate;
	}
	public int getCompanyItemNo() {
		return companyItemNo;
	}
	public void setCompanyItemNo(int companyItemNo) {
		this.companyItemNo = companyItemNo;
	}
	public String getCompanyUniqueNo() {
		return companyUniqueNo;
	}
	public void setCompanyUniqueNo(String companyUniqueNo) {
		this.companyUniqueNo = companyUniqueNo;
	}
	@Override
	public String toString() {
		return "CompanyCommentAndMember [companyCommentNo=" + companyCommentNo + ", companyCommentContent="
				+ companyCommentContent + ", memberUniqueNo=" + memberUniqueNo + ", memberNickname=" + memberNickname
				+ ", companyCommentDate=" + companyCommentDate + ", companyItemNo=" + companyItemNo
				+ ", companyUniqueNo=" + companyUniqueNo + "]";
	}
	
}
