package com.cafe24.dk4750.miniMarket.vo;

public class QnaBoardCompany {
	private int qnaBoardCompanyNo;
	private String companyUniqueNo;
	private String qnaBoardCompanyTitle;
	private String qnaBoardCompanyContent;
	private String qnaBoardCompanyDate;
	
	// 겟터 셋터
	public int getQnaBoardCompanyNo() {
		return qnaBoardCompanyNo;
	}
	public void setQnaBoardCompanyNo(int qnaBoardCompanyNo) {
		this.qnaBoardCompanyNo = qnaBoardCompanyNo;
	}
	public String getCompanyUniqueNo() {
		return companyUniqueNo;
	}
	public void setCompanyUniqueNo(String companyUniqueNo) {
		this.companyUniqueNo = companyUniqueNo;
	}
	public String getQnaBoardCompanyTitle() {
		return qnaBoardCompanyTitle;
	}
	public void setQnaBoardCompanyTitle(String qnaBoardCompanyTitle) {
		this.qnaBoardCompanyTitle = qnaBoardCompanyTitle;
	}
	public String getQnaBoardCompanyContent() {
		return qnaBoardCompanyContent;
	}
	public void setQnaBoardCompanyContent(String qnaBoardCompanyContent) {
		this.qnaBoardCompanyContent = qnaBoardCompanyContent;
	}
	public String getQnaBoardCompanyDate() {
		return qnaBoardCompanyDate;
	}
	public void setQnaBoardCompanyDate(String qnaBoardCompanyDate) {
		this.qnaBoardCompanyDate = qnaBoardCompanyDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "QnaBoardCompany [qnaBoardCompanyNo=" + qnaBoardCompanyNo + ", companyUniqueNo=" + companyUniqueNo
				+ ", qnaBoardCompanyTitle=" + qnaBoardCompanyTitle + ", qnaBoardCompanyContent="
				+ qnaBoardCompanyContent + ", qnaBoardCompanyDate=" + qnaBoardCompanyDate + "]";
	}
}
