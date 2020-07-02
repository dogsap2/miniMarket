package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ReportMemberByMemberMapper;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMember;

@Service
@Transactional
public class ReportMemberByMemberService {
	@Autowired
	private ReportMemberByMemberMapper reportMemberByMemberMapper;
	// 상태별 신고리스트(패이징)
	public Map<String, Object> getReportMemberByMemberStateList(int currentPage, String reportState) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("reportState", reportState);
		// lastPage
		int totalRow = reportMemberByMemberMapper.getStateTotalRow(reportState);
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMemberByMember> reportMemberByMemberStateList = reportMemberByMemberMapper.selectReportMemberByMemberStateList(map, reportState);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMemberByMemberStateList", reportMemberByMemberStateList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고 total 리스트 (페이징)
	public Map<String, Object> getReportMemberByMemberList(int currentPage) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		// lastPage
		int totalRow = reportMemberByMemberMapper.getTotalRow();
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMemberByMember> reportMemberByMemberList = reportMemberByMemberMapper.selectReportMemberByMemberAll(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMemberByMemberList", reportMemberByMemberList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고내용 상세보기
	public ReportMemberByMember getReportMemberByMemberOne(int reportNo) {
		return reportMemberByMemberMapper.selectReportMemberByMemberOne(reportNo);
	}
	// 신고 접수
	public int addReportMemberByMember(ReportMemberByMember reportMemberByMember) {
		return reportMemberByMemberMapper.insertReportMemberByMember(reportMemberByMember);
	}
}
