package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompany;



public class ReportMemeberByCompanyController {

	@GetMapping("/memberByCompanyReport")
	   public String addReport() {
	      return "memberByCompanyReport";
	   }
	   @PostMapping("/memberByCompanyReport")
	   public String addReport(ReportMemberByCompany reportMemberByCompany) {
	      System.out.println(reportMemberByCompany);
	      return "redirect:/memberByCompanyReport";
	   }
}
