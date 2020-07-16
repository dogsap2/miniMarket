package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.ReportMemberByCompanyItemService;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyItem;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyItemAndCompanyItem;


@Controller
public class ReportMemberByCompanyitemController {
	@Autowired
	private ReportMemberByCompanyItemService reportMemberByCompanyItemService;
	// 관리자 세션 전부 다
	// 신고 상태 수정
	@PostMapping("modifyReportStateMemberByCompanyItem")
	public String modifyReportStateMemberByCompanyItem(ReportMemberByCompanyItem reportMemberByCompanyItem, @RequestParam(value="reportNo") int reportNo) {
		reportMemberByCompanyItemService.modifyMemberByCompanyItemState(reportMemberByCompanyItem);
		
		return "redirect:/getReportMemberByCompanyItemListOne?reportNo="+reportNo;
	}
	// 신고내용 상세보기
	@GetMapping("getReportMemberByCompanyItemListOne")
	public String getReportMemberByCompanyItemListOne(Model model, @RequestParam(value="reportNo") int reportNo) {
		ReportMemberByCompanyItemAndCompanyItem reportMemberByCompanyItemAndCompanyItem = reportMemberByCompanyItemService.getReportMemberByCompanyItemOne(reportNo);
		model.addAttribute("reportOne", reportMemberByCompanyItemAndCompanyItem);
		
		return "getReportMemberByCompanyItemListOne";
	}
	// 신고내역 리스트 (페이징)
	@GetMapping("getReportMemberByCompanyItemList")
	public String getReportMemberByCompanyItemList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="reportState", defaultValue="") String reportState) {
		System.out.println(currentPage + "<--getReportMemberByCompanyItemList currentPage");
		System.out.println(reportState + "<--getReportMemberByCompanyItemList reportState");
		Map<String, Object> map = reportMemberByCompanyItemService.getReportMemberByCompanyItemList(currentPage, reportState);
		System.out.println(map.get("reportMemberByCompanyItemList") + "<--getReportMemberByCompanyItemList reportMemberByCompanyItemList");
		System.out.println(map.get("lastPage") + "<-- lastPage");
		model.addAttribute("list", map.get("reportMemberByCompanyItemList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("reportState", reportState);
		
		return "getReportMemberByCompanyItemList";
	}
	@GetMapping("/memberByCompanyItemReport")
	public String addReport() {
		return "memberByCompanyReport";
	}
	@PostMapping("/memberByCompanyItemReport")
	public String addReport(ReportMemberByCompanyItem reportMemberByCompanyItem) {
		System.out.println(reportMemberByCompanyItem);
		return "redirect:/memberByCompanyReport";
	}
}
