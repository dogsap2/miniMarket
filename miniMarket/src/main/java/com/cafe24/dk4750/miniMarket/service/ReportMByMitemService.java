package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ReportMByMitemMapper;
import com.cafe24.dk4750.miniMarket.vo.ReportMByMitem;

@Service
@Transactional
public class ReportMByMitemService {
	@Autowired
	private ReportMByMitemMapper reportMByMitemMapper;
	// 상태별 신고리스트(신고취소, 페이징)
	public Map<String, Object> getReportMByMitemCancelList(int currentPage) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		// lastPage
		int totalRow = reportMByMitemMapper.getStateCancel();
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMByMitem> reportMByMitemCancelList = reportMByMitemMapper.selectReportMByMitemStateCancel(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMByMitemCancelList", reportMByMitemCancelList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 상태별 신고리스트(신고확인, 페이징)
	public Map<String, Object> getReportMByMitemConfirmList(int currentPage) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		// lastPage
		int totalRow = reportMByMitemMapper.getStateConfirm();
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMByMitem> reportMByMitemConfirmList = reportMByMitemMapper.selectReportMByMitemStateConfirm(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMByMitemConfirmList", reportMByMitemConfirmList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 상태별 신고리스트(신고중, 페이징)
	public Map<String, Object> getReportMByMitemIngList(int currentPage) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		// lastPage
		int totalRow = reportMByMitemMapper.getStateIng();
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMByMitem> reportMByMitemIngList = reportMByMitemMapper.selectReportMByMitemStateIng(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMByMitemIngList", reportMByMitemIngList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고 total 리스트 (페이징)
	public Map<String, Object> getReportMByMitemList(int currentPage) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		// lastPage
		int totalRow = reportMByMitemMapper.getTotalRow();
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMByMitem> reportMByMitemList = reportMByMitemMapper.selectReportMByMitemAll(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMByMitemList", reportMByMitemList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고내용 상세보기
	public ReportMByMitem getReportMByMitemOne(int reportNo) {
		return reportMByMitemMapper.selectReportMByMitemOne(reportNo);
	}
	// 신고 접수
	public int addReportMByMitem(ReportMByMitem reportMByMitem) {
		return reportMByMitemMapper.insertReportMByMitem(reportMByMitem);
	}
}
