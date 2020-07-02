package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ReportMemberByCompanyMapper;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompany;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyItem;

@Service
@Transactional
public class ReportMemberByCompanyService {
	@Autowired
	private ReportMemberByCompanyMapper reportMemberByCompanyMapper;
	
	// 상태별 신고리스트(패이징)
		public Map<String, Object> getReportMemberByCompanyStateList(int currentPage, String reportState) {
			int rowPerPage = 10;
			int beginRow = (currentPage-1)*rowPerPage;
			Map<String, Object> map = new HashMap<>();
			map.put("beginRow", beginRow);
			map.put("rowPerPage", rowPerPage);
			map.put("reportState", reportState);
			// lastPage
			int totalRow = reportMemberByCompanyMapper.getStateTotalRow(reportState);
			int lastPage = totalRow/rowPerPage;
			if(totalRow%rowPerPage != 0) {
				lastPage += 1;
			}
			// list와 lastPage Map에 담는다
			List<ReportMemberByCompany> reportMemberByCompanyStateList = reportMemberByCompanyMapper.selectReportMemberByCompanyStateList(map, reportState);
			Map<String, Object> map2 = new HashMap<>();
			map2.put("reportMemberByCompanyStateList", reportMemberByCompanyStateList);
			map2.put("lastPage", lastPage);
			
			return map2;
		}
		// 신고 total 리스트 (페이징)
		public Map<String, Object> getReportMemberByCompanyList(int currentPage) {
			int rowPerPage = 10;
			int beginRow = (currentPage-1)*rowPerPage;
			Map<String, Object> map = new HashMap<>();
			map.put("beginRow", beginRow);
			map.put("rowPerPage", rowPerPage);
			// lastPage
			int totalRow = reportMemberByCompanyMapper.getTotalRow();
			int lastPage = totalRow/rowPerPage;
			if(totalRow%rowPerPage != 0) {
				lastPage += 1;
			}
			// list와 lastPage Map에 담는다
			List<ReportMemberByCompany> reportMemberByCompanyList = reportMemberByCompanyMapper.selectReportMemberByCompanyAll(map);
			Map<String, Object> map2 = new HashMap<>();
			map2.put("reportMemberByCompanyList", reportMemberByCompanyList);
			map2.put("lastPage", lastPage);
			
			return map2;
		}
		// 신고내용 상세보기
		public ReportMemberByCompany getReportMemberByCompanyOne(int reportNo) {
			return reportMemberByCompanyMapper.selectReportMemberByCompanyOne(reportNo);
		}
		// 신고 접수
		public int addReportMemberByCompany(ReportMemberByCompany reportMemberByCompany) {
			return reportMemberByCompanyMapper.insertReportMemberByCompany(reportMemberByCompany);
		}
		//상태 수정
		public int modifyMemberByCompanyState(ReportMemberByCompany reportMemberByCompany) {
			return reportMemberByCompanyMapper.updateReportMemberByCompanyState(reportMemberByCompany);
		}
}
