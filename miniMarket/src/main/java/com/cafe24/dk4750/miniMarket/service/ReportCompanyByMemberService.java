package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.MemberTempMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberTempTotalMapper;
import com.cafe24.dk4750.miniMarket.mapper.ReportCompanyByMemberMapper;
import com.cafe24.dk4750.miniMarket.vo.MemberTemp;
import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMember;
import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMemberAndMember;

@Service
@Transactional
public class ReportCompanyByMemberService {
	@Autowired
	private ReportCompanyByMemberMapper reportCompanyByMemberMapper;
	@Autowired private MemberTempMapper memberTempMapper;
	@Autowired private MemberTempTotalMapper memberTempTotalMapper;
	
	// 신고 total 리스트(페이징)
	public Map<String, Object> getReportCompanyByMemberList(int currentPage, String reportState) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("reportState", reportState);
		// lastPage
		int totalRow = reportCompanyByMemberMapper.getTotalRow(reportState);
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportCompanyByMember> reportCompanyByMemberList = reportCompanyByMemberMapper.selectReportCompanyByMemberAll(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportCompanyByMemberList", reportCompanyByMemberList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고내용 상세보기
	public ReportCompanyByMemberAndMember getReportCompanyByMemberOne(int reportNo) {
		return reportCompanyByMemberMapper.selectReportCompanyByMemberOne(reportNo);
	}
	// 신고 접수
	public int addReportCompanyByMember(ReportCompanyByMember reportCompanyByMember) {
		return reportCompanyByMemberMapper.insertReportCompanyByMember(reportCompanyByMember);
	}
	//상태 수정
	public int modifyCompanyByMemberState(ReportCompanyByMember reportCompanyByMember) {
		String reportState ="신고완료";
		MemberTemp memberTemp = new MemberTemp();
		Map<String, Object> map = new HashMap<>();
		
		reportCompanyByMemberMapper.updateReportCompanyByMemberState(reportCompanyByMember);
		return 0;
	}
}
