package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportMByMitem;

@Mapper
public interface ReportMByMitemMapper {
	// 멤버가 멤버아이템 신고시
	public int insertReportMByMitem(ReportMByMitem reportMByMitem);
	// 신고 total리스트 출력
	public List<ReportMByMitem> selectReportMByMitemAll(Map<String, Object> map);
	// 신고 total리스트 페이징
	public int getTotalRow();
	// 신고 내용 상세보기
	public ReportMByMitem selectReportMByMitemOne(int reportNo);
	// 신고 상태별 리스트(신고중)
	public List<ReportMByMitem> selectReportMByMitemStateIng(Map<String, Object> map);
	// (신고중) 페이징
	public int getStateIng();
	// 신고 상태별 리스트(신고확인)
	public List<ReportMByMitem> selectReportMByMitemStateConfirm(Map<String, Object> map);
	// (신고확인) 페이징
	public int getStateConfirm();
	// 신고 상태별 리스트(신고취소)
	public List<ReportMByMitem> selectReportMByMitemStateCancel(Map<String, Object> map);
	// (신고취소) 페이징
	public int getStateCancel();
}
