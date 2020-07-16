package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.ReportMemberByCompanyService;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompany;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyAndCompany;


@Controller
public class ReportMemeberByCompanyController {
	@Autowired
	private ReportMemberByCompanyService reportMemberByCompanyService;
	// 관리자 세션
	
	
	// 신고 상태 수정
	@PostMapping("modifyReportStateMemberByCompany")
	public String modifyReportStateMemberByCompany(ReportMemberByCompany reportMemberByCompany, @RequestParam(value="reportNo") int reportNo) {
		reportMemberByCompanyService.modifyMemberByCompanyState(reportMemberByCompany);
		System.out.println(reportMemberByCompany);
		
		return "redirect:/getReportMemberByCompanyListOne?reportNo="+reportNo;
	}
	// 신고내용 상세보기
	@GetMapping("getReportMemberByCompanyListOne")
	public String getReportMemberByCompanyListOne(Model model, @RequestParam(value="reportNo") int reportNo) {
		ReportMemberByCompanyAndCompany reportMemberByCompanyAndCompany = reportMemberByCompanyService.getReportMemberByCompanyOne(reportNo);
		model.addAttribute("reportOne", reportMemberByCompanyAndCompany);
		
		return "getReportMemberByCompanyListOne";
	}
	// 신고 리스트(페이징, 상태별)
	@GetMapping("getReportMemberByCompanyList")
	public String getReportMemberByCompanyList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="reportState", defaultValue="") String reportState) {
		System.out.println(currentPage + "<--getReportMemberByCompanyList currentPage");
		System.out.println(reportState + "<--getReportMemberByCompanyList reportState");
		Map<String, Object> map = reportMemberByCompanyService.getReportMemberByCompanyList(currentPage, reportState);
		System.out.println(map.get("reportMemberByCompanyList") + "<--getReportMemberByCompanyList reportMemberByCompanyList");
		System.out.println(map.get("lastPage") + "<-- lastPage");
		model.addAttribute("list", map.get("reportMemberByCompanyList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("reportState", reportState);
		
		return "getReportMemberByCompanyList";
	}
	@GetMapping("/memberByCompanyReport")
	public String addReport(@RequestParam("companyUniqueNo") String companyUniqueNo, Model model) {
		System.out.println(companyUniqueNo+"<---신고당한 업체 고유 번호");
		String companyName = reportMemberByCompanyService.getCompanyName(companyUniqueNo);
		System.out.println(companyName);
		
		model.addAttribute("companyUniqueNo", companyUniqueNo);
		model.addAttribute("companyName", companyName);
		return "memberByCompanyReport";
	}
	@PostMapping("/memberByCompanyReport")
	public String addReport(HttpSession session , ReportMemberByCompany reportMemberByCompany) {
		System.out.println(reportMemberByCompany);
		String memberId = ((LoginMember)session.getAttribute("loginMember")).getMemberId();
		reportMemberByCompany.setMemberId(memberId);
		reportMemberByCompanyService.addReportMemberByCompany(reportMemberByCompany);
		return "redirect:/getCompanyItemList";
	}
}
