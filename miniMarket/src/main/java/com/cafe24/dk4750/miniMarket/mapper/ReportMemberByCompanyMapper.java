package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompany;

@Mapper
public interface ReportMemberByCompanyMapper {
	// 멤버가 업체 신고시
	public int insertReportMemberByCompany(ReportMemberByCompany reportMemberByCompany);
	// 신고 total리스트 출력
	public List<ReportMemberByCompany> selectReportMemberByCompanyAll(Map<String, Object> map);
	// 신고 total리스트 페이징
	public int getTotalRow();
	// 신고 내용 상세보기
	public ReportMemberByCompany selectReportMemberByCompanyOne(int reportNo);
	// 신고 상태별 리스트
	public List<ReportMemberByCompany> selectReportMemberByCompanyStateList(Map<String, Object> map, String reportState);
	// 신고 상태별 페이징
	public int getStateTotalRow(String reportState);
	// 신고 상태 수정
	public int updateReportMemberByCompanyState(ReportMemberByCompany reportMemberByCompany);
}
