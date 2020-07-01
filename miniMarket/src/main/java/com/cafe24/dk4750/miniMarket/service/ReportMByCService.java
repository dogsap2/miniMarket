package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ReportMByCMapper;
import com.cafe24.dk4750.miniMarket.vo.ReportMByC;

@Service
@Transactional
public class ReportMByCService {
	@Autowired
	private ReportMByCMapper reportMByCMapper;
	
	// 상태별 신고리스트(패이징)
		public Map<String, Object> getReportMByCStateList(int currentPage, String reportState) {
			int rowPerPage = 10;
			int beginRow = (currentPage-1)*rowPerPage;
			Map<String, Object> map = new HashMap<>();
			map.put("beginRow", beginRow);
			map.put("rowPerPage", rowPerPage);
			map.put("reportState", reportState);
			// lastPage
			int totalRow = reportMByCMapper.getStateTotalRow(reportState);
			int lastPage = totalRow/rowPerPage;
			if(totalRow%rowPerPage != 0) {
				lastPage += 1;
			}
			// list와 lastPage Map에 담는다
			List<ReportMByC> reportMByCStateList = reportMByCMapper.selectReportMByCStateList(map, reportState);
			Map<String, Object> map2 = new HashMap<>();
			map2.put("reportMByCStateList", reportMByCStateList);
			map2.put("lastPage", lastPage);
			
			return map2;
		}
		// 신고 total 리스트 (페이징)
		public Map<String, Object> getReportMByCList(int currentPage) {
			int rowPerPage = 10;
			int beginRow = (currentPage-1)*rowPerPage;
			Map<String, Object> map = new HashMap<>();
			map.put("beginRow", beginRow);
			map.put("rowPerPage", rowPerPage);
			// lastPage
			int totalRow = reportMByCMapper.getTotalRow();
			int lastPage = totalRow/rowPerPage;
			if(totalRow%rowPerPage != 0) {
				lastPage += 1;
			}
			// list와 lastPage Map에 담는다
			List<ReportMByC> reportMByCList = reportMByCMapper.selectReportMByCAll(map);
			Map<String, Object> map2 = new HashMap<>();
			map2.put("reportMByCList", reportMByCList);
			map2.put("lastPage", lastPage);
			
			return map2;
		}
		// 신고내용 상세보기
		public ReportMByC getReportMByCOne(int reportNo) {
			return reportMByCMapper.selectReportMByCOne(reportNo);
		}
		// 신고 접수
		public int addReportMByC(ReportMByC reportMByC) {
			return reportMByCMapper.insertReportMByC(reportMByC);
		}
}
