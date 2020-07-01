package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportMByCitem;

@Mapper
public interface ReportMByCitemMapper {
	// 멤버가 업체아이템 신고시
	public int insertReportMByCitem(ReportMByCitem reportMByCitem);
	// 신고 total리스트 출력
	public List<ReportMByCitem> selectReportMByCitemAll(Map<String, Object> map);
	// 신고 total리스트 페이징
	public int getTotalRow();
	// 신고 내용 상세보기
	public ReportMByCitem selectReportByCitemOne(int reportNo);
	// 신고 상태별 리스트
	public List<ReportMByCitem> selectReportMByCitemStateList(Map<String, Object> map, String reportState);
	// 신고 상태별 페이징
	public int getStateTotalRow(String reportState);
}
