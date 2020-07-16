package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.ReportMemberByMemberService;
import com.cafe24.dk4750.miniMarket.vo.*;
@Controller
public class ReportMemberByMemberController {
	@Autowired
	private ReportMemberByMemberService reportMemberByMemberService;
	// 전부다 관리자 상태로 가능
	// 신고 상태 수정
	@PostMapping("modifyReportStateMemberByMember")
	public String modifyReportMemberByMemberReportState(ReportMemberByMember reportMemberByMember, @RequestParam(value="reportNo") int reportNo) {
		reportMemberByMemberService.modifyMemberByMemberState(reportMemberByMember);
		System.out.println(reportMemberByMember);
		
		return "redirect:/getReportMemberByMemberListOne?reportNo="+reportNo;
	}
	// 신고내용 상세보기
	@GetMapping("getReportMemberByMemberListOne")
	public String getReportMemberByMemberListOne(Model model, @RequestParam(value="reportNo") int reportNo) {
		ReportMemberByMemberAndMember reportMemberByMemberAndMember = reportMemberByMemberService.getReportMemberByMemberOne(reportNo);
		model.addAttribute("reportOne", reportMemberByMemberAndMember);
		
		return "getReportMemberByMemberListOne";
	}
	// MemberByMember 신고 리스트 (페이징, 상태별)
	@GetMapping("getReportMemberByMemberList")
	public String getReportMemberByMemberList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="reportState", defaultValue="") String reportState) {
		// 관리자만 접근 가능
		
		System.out.println(currentPage + "<--getReportMemberByMemberList currentPage");
		System.out.println(reportState + "<--getReportMemberByMemberList reportState");
		Map<String, Object> map = reportMemberByMemberService.getReportMemberByMemberList(currentPage, reportState);
		System.out.println(map.get("reportMemberByMemberList") + "<--getReportMemberByMemberList reportMemberByMemberList");
		System.out.println(map.get("lastPage") + "<-- lastPage");
		model.addAttribute("list", map.get("reportMemberByMemberList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("reportState", reportState);
		
		return "getReportMemberByMemberList";
	}
	@GetMapping("/memberByMemberReport")
	public String addReport(HttpSession session ,@RequestParam("memberUniqueNo") String memberUniqueNo, Model model) {
		if(session.getAttribute("loginMember") == null) {
	         return "redirect:login";
	      }
		System.out.println(memberUniqueNo +"<--신고하려는 상대 고유 번호");
		String memberNickname = reportMemberByMemberService.getMemberName(memberUniqueNo);
		System.out.println(memberNickname+"<---memberNickname");
		
		model.addAttribute("memberNickname", memberNickname);
		model.addAttribute("memberUniqueNo", memberUniqueNo);
		return "memberByMemberReport";
	}
	@PostMapping("/memberByMemberReport")
	public String addReport(HttpSession session , ReportMemberByMember reportMemberByMember) {
		System.out.println(reportMemberByMember);
		String memberId = ((LoginMember)session.getAttribute("loginMember")).getMemberId();
		reportMemberByMember.setMemberId(memberId);
		reportMemberByMemberService.addReportMemberByMember(reportMemberByMember);
		
		return "redirect:/getMemberItemList";
	}
}
