package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.ReportCompanyByMemberService;
import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMember;
import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMemberAndMember;



@Controller
public class ReportCompanyByMemberController {
	@Autowired
	private ReportCompanyByMemberService reportCompanyByMemberService;
	// 관리자만 접근가능
	// 신고 상태 수정
	@PostMapping("modifyReportStateCompanyByMember")
	public String modifyReportStateCompanyByMember(ReportCompanyByMember reportCompanyByMember, @RequestParam(value="reportNo") int reportNo) {
		reportCompanyByMemberService.modifyCompanyByMemberState(reportCompanyByMember);
		
		return "redirect:/getReportCompanyByMemberListOne?reportNo="+reportNo;
	}
	// 신고내용 상세보기
	@GetMapping("getReportCompanyByMemberListOne")
	public String getReportCompanyByMemberListOne(Model model, @RequestParam(value="reportNo") int reportNo) {
		ReportCompanyByMemberAndMember reportCompanyByMemberAndMember = reportCompanyByMemberService.getReportCompanyByMemberOne(reportNo);
		model.addAttribute("reportOne", reportCompanyByMemberAndMember);
		
		return "getReportCompanyByMemberListOne";
	}
	// CompanyByMember 신고리스트
	@GetMapping("getReportCompanyByMemberList")
	public String getReportCompanyByMemberList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="reportState", defaultValue="") String reportState) {
		System.out.println(currentPage + "<--getReportCompanyByMemberList currentPage");
		System.out.println(reportState + "<--getReportCompanyByMemberList reportState");
		Map<String, Object> map = reportCompanyByMemberService.getReportCompanyByMemberList(currentPage, reportState);
		System.out.println(map.get("reportCompanyByMemberList") + "<--getReportCompanyByMemberList reportCompanyByMemberList");
		System.out.println(map.get("lastPage") + "<-- lastPage");
		model.addAttribute("list", map.get("reportCompanyByMemberList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("reportState", reportState);
		
		return "getReportCompanyByMeberList";
	}
	@GetMapping("/companyByMemberReport")
	public String addReport() {
		return "companyByMemberReport";
	}
	@PostMapping("/companyByMemberReport")
	public String addReport(ReportCompanyByMember reportCompanyByMember) {
		System.out.println(reportCompanyByMember);
		return "redirect:/companyByMemberReport";
	}
	
}
