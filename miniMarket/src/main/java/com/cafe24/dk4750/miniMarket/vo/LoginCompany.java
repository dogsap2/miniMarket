package com.cafe24.dk4750.miniMarket.vo;

public class LoginCompany {
	private String companyId;
	private String companyPw;
	private String companyName;	 
	private String companyUniqueNo; 
	private String memberSido;
	private String memberSigungu;
	private String memberBname;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyPw() {
		return companyPw;
	}
	public void setCompanyPw(String companyPw) {
		this.companyPw = companyPw;
	}
	public String getCompanyUniqueNo() {
		return companyUniqueNo;
	}
	public void setCompanyUniqueNo(String companyUniqueNo) {
		this.companyUniqueNo = companyUniqueNo;
	}
	public String getMemberSido() {
		return memberSido;
	}
	public void setMemberSido(String memberSido) {
		this.memberSido = memberSido;
	}
	public String getMemberSigungu() {
		return memberSigungu;
	}
	public void setMemberSigungu(String memberSigungu) {
		this.memberSigungu = memberSigungu;
	}
	public String getMemberBname() {
		return memberBname;
	}
	public void setMemberBname(String memberBname) {
		this.memberBname = memberBname;
	}
	
	@Override
	public String toString() {
		return "LoginCompany [companyId=" + companyId + ", companyName=" + companyName + ", companyPw=" + companyPw
				+ ", companyUniqueNo=" + companyUniqueNo + ", memberSido=" + memberSido + ", memberSigungu="
				+ memberSigungu + ", memberBname=" + memberBname + "]";
	}
	

}
