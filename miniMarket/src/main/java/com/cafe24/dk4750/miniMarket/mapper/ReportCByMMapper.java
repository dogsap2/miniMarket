package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportCByM;


@Mapper
public interface ReportCByMMapper {
	// 업체가 멤버 댓글 신고시
	public int insertReportCByM(ReportCByM reportCByM);
	// 신고 total리스트 출력
	public List<ReportCByM> selectReportCByMAll(Map<String, Object> map);
	// 신고 total리스트 페이징
	public int getTotalRow();
	// 신고 내용 상세보기
	public ReportCByM selectReportCByMOne(int reportNo);
	// 신고 상태별 리스트
	public List<ReportCByM> selectReportCByMStateList(Map<String, Object> map, String reportState);
	// 신고 상태별 페이징
	public int getStateTotalRow(String reportState);
}
