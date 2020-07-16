package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.ReportMemberByMemberItemService;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberItem;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberItemAndMemberItem;



@Controller
public class ReportMemberByMemberitemController {
	// 관리자만 접근 가능
	@Autowired 
	private ReportMemberByMemberItemService reportMemberByMemberItemService;
	
	
	// 신고 상태 수정
	@PostMapping("modifyReportStateMemberByMemberItem")
	public String modifyReportMemberByMemberItemState(ReportMemberByMemberItem reportMemberByMemberItem, @RequestParam(value="reportNo") int reportNo) {
		reportMemberByMemberItemService.modifyMemberByMemberItemState(reportMemberByMemberItem);
		
		return "redirect:/getReportMemberByMemberItemListOne?reportNo="+reportNo;
	}
	// 신고내용 상세보기
	@GetMapping("getReportMemberByMemberItemListOne")
	public String getReportMemberByMemberItemListOne(Model model, @RequestParam(value="reportNo") int reportNo) {
		ReportMemberByMemberItemAndMemberItem reportMemberByMemberItemAndMemberItem = reportMemberByMemberItemService.getReportMemberByMemberItemOne(reportNo);
		model.addAttribute("reportOne", reportMemberByMemberItemAndMemberItem);
		
		return "getReportMemberByMemberItemListOne";
	}
	// MemberByMemberItem 신고리스트
	@GetMapping("getReportMemberByMemberItemList")
	public String getReportMemberByMemberItemList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="reportState", defaultValue="") String reportState) {
		System.out.println(currentPage + "<--getReportMemberByMemberItemList currentPage");
		System.out.println(reportState + "<--getReportMemberByMemberItemList reportState");
		Map<String, Object> map = reportMemberByMemberItemService.getReportMemberByMemberItemList(currentPage, reportState);
		System.out.println(map.get("reportMemberByMemberItemList") + "<--getReportMemberByMemberList reportMemberByMemberList");
		System.out.println(map.get("lastPage") + "<-- lastPage");
		model.addAttribute("list", map.get("reportMemberByMemberItemList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("reportState", reportState);
		
		return "getReportMemberByMemberItemList";
	}
	
	@GetMapping("/memberByMemberItemReport")
	public String addReport(HttpSession session ,@RequestParam("memberItemNo") String memberItemNo, Model model) {
		 if(session.getAttribute("loginMember") == null) {
	         return "redirect:login";
	      }
		System.out.println(memberItemNo+"<---memberItemNo 신고하려는 게시물 번호");
		model.addAttribute("memberItemNo", memberItemNo);
		return "memberByMemberReport";
	}
	@PostMapping("/memberByMemberItemReport")
	public String addReport(HttpSession session , ReportMemberByMemberItem reportMemberByMemberItem) {
		System.out.println(reportMemberByMemberItem);
		String memberId = ((LoginMember)session.getAttribute("loginMember")).getMemberId();
		reportMemberByMemberItem.setMemberId(memberId);
		reportMemberByMemberItemService.addReportMemberByMemberItem(reportMemberByMemberItem);
		return "redirect:/getMemberItemList";
	}
}