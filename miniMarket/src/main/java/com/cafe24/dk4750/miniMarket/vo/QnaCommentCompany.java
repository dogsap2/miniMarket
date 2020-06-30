package com.cafe24.dk4750.miniMarket.vo;

public class QnaCommentCompany {
	private int qnaCommentCompanyNo;
	private int qnaCompanyBoardNo;
	private String qnaCommentCompany;
	private String qnaCommentCompanyDate;
	private String companyUniqueNo;
	
	// 겟터 셋터
	public int getQnaCommentCompanyNo() {
		return qnaCommentCompanyNo;
	}
	public void setQnaCommentCompanyNo(int qnaCommentCompanyNo) {
		this.qnaCommentCompanyNo = qnaCommentCompanyNo;
	}
	public int getQnaCompanyBoardNo() {
		return qnaCompanyBoardNo;
	}
	public void setQnaCompanyBoardNo(int qnaCompanyBoardNo) {
		this.qnaCompanyBoardNo = qnaCompanyBoardNo;
	}
	public String getQnaCommentCompany() {
		return qnaCommentCompany;
	}
	public void setQnaCommentCompany(String qnaCommentCompany) {
		this.qnaCommentCompany = qnaCommentCompany;
	}
	public String getQnaCommentCompanyDate() {
		return qnaCommentCompanyDate;
	}
	public void setQnaCommentCompanyDate(String qnaCommentCompanyDate) {
		this.qnaCommentCompanyDate = qnaCommentCompanyDate;
	}
	public String getCompanyUniqueNo() {
		return companyUniqueNo;
	}
	public void setCompanyUniqueNo(String companyUniqueNo) {
		this.companyUniqueNo = companyUniqueNo;
	}
	
	// toString
	@Override
	public String toString() {
		return "QnaCommentCompany [qnaCommentCompanyNo=" + qnaCommentCompanyNo + ", qnaCompanyBoardNo="
				+ qnaCompanyBoardNo + ", qnaCommentCompany=" + qnaCommentCompany + ", qnaCommentCompanyDate="
				+ qnaCommentCompanyDate + ", companyUniqueNo=" + companyUniqueNo + "]";
	}
}
