package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyItem;


@Controller
public class ReportMemberByCompanyitemController {
	@GetMapping("/memberByCompanyItemReport")
	public String addReport() {
		return "memberByCompanyItemReport";
	}
	@PostMapping("/memberByCompanyItemReport")
	public String addReport(ReportMemberByCompanyItem reportMemberByCompanyItem) {
		System.out.println(reportMemberByCompanyItem);
		return "redirect:/memberByCompanyItemReport";
	}
}
