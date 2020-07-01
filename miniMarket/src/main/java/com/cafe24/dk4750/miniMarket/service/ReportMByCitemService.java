package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ReportMByCitemMapper;
import com.cafe24.dk4750.miniMarket.vo.ReportMByCitem;

@Service
@Transactional
public class ReportMByCitemService {
	@Autowired
	private ReportMByCitemMapper reportMByCitemMapper;
	
	// 상태별 신고리스트(패이징)
	public Map<String, Object> getReportMByCitemStateList(int currentPage, String reportState) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("reportState", reportState);
		// lastPage
		int totalRow = reportMByCitemMapper.getStateTotalRow(reportState);
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMByCitem> reportMByMitemIngList = reportMByCitemMapper.selectReportMByCitemStateList(map, reportState);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMByMitemIngList", reportMByMitemIngList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고 total 리스트 (페이징)
	public Map<String, Object> getReportMByCitemList(int currentPage) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		// lastPage
		int totalRow = reportMByCitemMapper.getTotalRow();
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMByCitem> reportMByCitemList = reportMByCitemMapper.selectReportMByCitemAll(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMByCitemList", reportMByCitemList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고내용 상세보기
	public ReportMByCitem getReportMByCitemOne(int reportNo) {
		return reportMByCitemMapper.selectReportByCitemOne(reportNo);
	}
	// 신고 접수
	public int addReportMByCitem(ReportMByCitem reportMByCitem) {
		return reportMByCitemMapper.insertReportMByCitem(reportMByCitem);
	}
}
