package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportMByC;

@Mapper
public interface ReportMByCMapper {
	// 멤버가 업체 신고시
	public int insertReportMByC(ReportMByC reportMByC);
	// 신고 total리스트 출력
	public List<ReportMByC> selectReportMByCAll(Map<String, Object> map);
	// 신고 total리스트 페이징
	public int getTotalRow();
	// 신고 내용 상세보기
	public ReportMByC selectReportMByCOne(int reportNo);
	// 신고 상태별 리스트
	public List<ReportMByC> selectReportMByCStateList(Map<String, Object> map, String reportState);
	// 신고 상태별 페이징
	public int getStateTotalRow(String reportState);
}
