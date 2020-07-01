package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ReportMByMMapper;
import com.cafe24.dk4750.miniMarket.vo.ReportMByM;

@Service
@Transactional
public class ReportMByMService {
	@Autowired
	private ReportMByMMapper reportMByMMapper;
	// 상태별 신고리스트(패이징)
		public Map<String, Object> getReportMByMStateList(int currentPage, String reportState) {
			int rowPerPage = 10;
			int beginRow = (currentPage-1)*rowPerPage;
			Map<String, Object> map = new HashMap<>();
			map.put("beginRow", beginRow);
			map.put("rowPerPage", rowPerPage);
			map.put("reportState", reportState);
			// lastPage
			int totalRow = reportMByMMapper.getStateTotalRow(reportState);
			int lastPage = totalRow/rowPerPage;
			if(totalRow%rowPerPage != 0) {
				lastPage += 1;
			}
			// list와 lastPage Map에 담는다
			List<ReportMByM> reportMByMList = reportMByMMapper.selectReportMByMStateList(map, reportState);
			Map<String, Object> map2 = new HashMap<>();
			map2.put("reportMByMList", reportMByMList);
			map2.put("lastPage", lastPage);
			
			return map2;
		}
		// 신고 total 리스트 (페이징)
		public Map<String, Object> getReportMByMList(int currentPage) {
			int rowPerPage = 10;
			int beginRow = (currentPage-1)*rowPerPage;
			Map<String, Object> map = new HashMap<>();
			map.put("beginRow", beginRow);
			map.put("rowPerPage", rowPerPage);
			// lastPage
			int totalRow = reportMByMMapper.getTotalRow();
			int lastPage = totalRow/rowPerPage;
			if(totalRow%rowPerPage != 0) {
				lastPage += 1;
			}
			// list와 lastPage Map에 담는다
			List<ReportMByM> reportMByMList = reportMByMMapper.selectReportMByMAll(map);
			Map<String, Object> map2 = new HashMap<>();
			map2.put("reportMByMList", reportMByMList);
			map2.put("lastPage", lastPage);
			
			return map2;
		}
		// 신고내용 상세보기
		public ReportMByM getReportMByMOne(int reportNo) {
			return reportMByMMapper.selectReportByMOne(reportNo);
		}
		// 신고 접수
		public int addReportMByM(ReportMByM reportMByM) {
			return reportMByMMapper.insertReportMByM(reportMByM);
		}
}
