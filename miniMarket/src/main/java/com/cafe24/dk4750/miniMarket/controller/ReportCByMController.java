package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMember;

@Controller
public class ReportCByMController {
	@GetMapping("/cByMReport")
	public String addReport() {
		return "cByMReport";
	}
	@PostMapping("/cByMReport")
	public String addReport(ReportCompanyByMember reportCByM) {
		System.out.println(reportCByM);
		return "redirect:/cByMReport";
	}
}
