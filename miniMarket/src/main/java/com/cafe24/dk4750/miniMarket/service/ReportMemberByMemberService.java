package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ReportMemberByMemberMapper;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMember;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberAndMember;

@Service
@Transactional
public class ReportMemberByMemberService {
	@Autowired
	private ReportMemberByMemberMapper reportMemberByMemberMapper;
	
	//멤버 이름 불러오기
	public String getMemberName(String memberUniqueNo) {
		String memberNickname = reportMemberByMemberMapper.selectMemberName(memberUniqueNo);
		System.out.println(memberNickname);
		return memberNickname;
	}
	// 신고 total 리스트 (페이징)
	public Map<String, Object> getReportMemberByMemberList(int currentPage, String reportState) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("reportState", reportState);
		// lastPage
		int totalRow = reportMemberByMemberMapper.getTotalRow(reportState);
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
	public ReportMemberByMemberAndMember getReportMemberByMemberOne(int reportNo) {
		return reportMemberByMemberMapper.selectReportMemberByMemberOne(reportNo);
	}
	// 신고 접수
	public int addReportMemberByMember(ReportMemberByMember reportMemberByMember) {
		return reportMemberByMemberMapper.insertReportMemberByMember(reportMemberByMember);
	}
	//상태 수정
	public int modifyMemberByMemberState(ReportMemberByMember reportMemberByMember) {
		return reportMemberByMemberMapper.updateReportMemberByMemberState(reportMemberByMember);
	}
}
