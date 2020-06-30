package com.cafe24.dk4750.miniMarket.vo;

public class ReportMByMitem {
	private int reportNo;
	private String reportTitle;
	private String reportContent;
	private String reportMemo;
	private String memberId;
	private int memberItemNo;
	private String reportState;
	private String reportDate;
	
	// 겟터 셋터
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public String getReportMemo() {
		return reportMemo;
	}
	public void setReportMemo(String reportMemo) {
		this.reportMemo = reportMemo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMemberItemNo() {
		return memberItemNo;
	}
	public void setMemberItemNo(int memberItemNo) {
		this.memberItemNo = memberItemNo;
	}
	public String getReportState() {
		return reportState;
	}
	public void setReportState(String reportState) {
		this.reportState = reportState;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "ReportMByMitem [reportNo=" + reportNo + ", reportTitle=" + reportTitle + ", reportContent="
				+ reportContent + ", reportMemo=" + reportMemo + ", memberId=" + memberId + ", memberItemNo="
				+ memberItemNo + ", reportState=" + reportState + ", reportDate=" + reportDate + "]";
	}
}
