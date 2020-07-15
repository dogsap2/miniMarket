package com.cafe24.dk4750.miniMarket.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMember;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberAndMember;

@Mapper
public interface ReportMemberByMemberMapper {
	// 멤버가 업체아이템 신고시
	public int insertReportMemberByMember(ReportMemberByMember reportMemberByMember);
	// 신고 total리스트 출력
	public List<ReportMemberByMember> selectReportMemberByMemberAll(Map<String, Object> map);
	// 신고 totalRow
	public int getTotalRow(String reportState);
	// 신고 내용 상세보기
	public ReportMemberByMemberAndMember selectReportMemberByMemberOne(int reportNo);
	// 신고 상태 변경
	public int updateReportMemberByMemberState(ReportMemberByMember reportMemberByMember);
}
