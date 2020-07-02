package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMember;



@Controller
public class ReportCompanyByMemberController {
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
