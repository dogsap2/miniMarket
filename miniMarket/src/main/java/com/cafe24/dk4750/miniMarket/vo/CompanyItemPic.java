package com.cafe24.dk4750.miniMarket.vo;

public class CompanyItemPic {
	private int picNo;
	private int companyItemNo;
	private String companyItemPic;
	private String companyId;
	private String picDate;
	
	// 겟터 셋터
	public int getPicNo() {
		return picNo;
	}
	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}
	public int getCompanyItemNo() {
		return companyItemNo;
	}
	public void setCompanyItemNo(int companyItemNo) {
		this.companyItemNo = companyItemNo;
	}
	public String getCompanyItemPic() {
		return companyItemPic;
	}
	public void setCompanyItemPic(String companyItemPic) {
		this.companyItemPic = companyItemPic;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
		return "CompanyItemPic [picNo=" + picNo + ", companyItemNo=" + companyItemNo + ", companyItemPic="
				+ companyItemPic + ", companyId=" + companyId + ", picDate=" + picDate + "]";
	}
}
