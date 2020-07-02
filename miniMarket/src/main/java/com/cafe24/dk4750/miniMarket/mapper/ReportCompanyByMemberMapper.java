package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMember;


@Mapper
public interface ReportCompanyByMemberMapper {
	// 업체가 멤버 댓글 신고시
	public int insertReportCompanyByMember(ReportCompanyByMember reportCompanyByMember);
	// 신고 total리스트 출력
	public List<ReportCompanyByMember> selectReportCompanyByMemberAll(Map<String, Object> map);
	// 신고 total리스트 페이징
	public int getTotalRow();
	// 신고 내용 상세보기
	public ReportCompanyByMember selectReportCompanyByMemberOne(int reportNo);
	// 신고 상태별 리스트
	public List<ReportCompanyByMember> selectReportCompanyByMemberStateList(Map<String, Object> map, String reportState);
	// 신고 상태별 페이징
	public int getStateTotalRow(String reportState);
}