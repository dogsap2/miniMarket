package com.cafe24.dk4750.miniMarket.vo;

public class MemberInterestPlace {
	private int interestPlaceNo;
	private String memberUniqueNo;
	private String sido;
	private String sigungu;
	private String bname;
	private String interestPlaceDate;
	
	// 겟터 셋터
	public int getInterestPlaceNo() {
		return interestPlaceNo;
	}
	public void setInterestPlaceNo(int interestPlaceNo) {
		this.interestPlaceNo = interestPlaceNo;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getInterestPlaceDate() {
		return interestPlaceDate;
	}
	public void setInterestPlaceDate(String interestPlaceDate) {
		this.interestPlaceDate = interestPlaceDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberInterestPlace [interestPlaceNo=" + interestPlaceNo + ", memberUniqueNo=" + memberUniqueNo
				+ ", sido=" + sido + ", sigungu=" + sigungu + ", bname=" + bname + ", interestPlaceDate="
				+ interestPlaceDate + "]";
	}
}
