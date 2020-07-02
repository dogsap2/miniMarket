package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ReportMemberByCompanyItemMapper;
import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMember;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyItem;

@Service
@Transactional
public class ReportMemberByCompanyItemService {
	@Autowired
	private ReportMemberByCompanyItemMapper reportMemberByCompanyItemMapper;
	
	// 상태별 신고리스트(패이징)
	public Map<String, Object> getReportMemberByCompanyItemStateList(int currentPage, String reportState) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("reportState", reportState);
		// lastPage
		int totalRow = reportMemberByCompanyItemMapper.getStateTotalRow(reportState);
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMemberByCompanyItem> reportMemberByCompanyItemStateList = reportMemberByCompanyItemMapper.selectReportMemberByCompanyItemStateList(map, reportState);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMemberByCompanyItemStateList", reportMemberByCompanyItemStateList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고 total 리스트 (페이징)
	public Map<String, Object> getReportMemberByCompanyItemList(int currentPage) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		// lastPage
		int totalRow = reportMemberByCompanyItemMapper.getTotalRow();
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMemberByCompanyItem> reportMemberByCompanyItemList = reportMemberByCompanyItemMapper.selectReportMemberByCompanyItemAll(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMemberByCompanyItemList", reportMemberByCompanyItemList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고내용 상세보기
	public ReportMemberByCompanyItem getReportMemberByCompanyItemOne(int reportNo) {
		return reportMemberByCompanyItemMapper.selectReportMemberByCompanyItemOne(reportNo);
	}
	// 신고 접수
	public int addReportMemberByCompanyItem(ReportMemberByCompanyItem reportMemberByCompanyItem) {
		return reportMemberByCompanyItemMapper.insertReportMemberByCompanyItem(reportMemberByCompanyItem);
	}
	//상태 수정
	public int modifyMemberByCompanyItemState(ReportMemberByCompanyItem reportMemberByCompanyItem) {
		return reportMemberByCompanyItemMapper.updateReportMemberByCompanyState(reportMemberByCompanyItem);
	}
}
