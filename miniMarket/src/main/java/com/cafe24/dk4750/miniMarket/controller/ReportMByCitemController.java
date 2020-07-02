package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyItem;

@Controller
public class ReportMByCitemController {
	@GetMapping("/mByCReport")
	public String addReport() {
		return "mByCReport";
	}
	@PostMapping("/mByCReport")
	public String addReport(ReportMemberByCompanyItem reportMByCitem) {
		System.out.println(reportMByCitem);
		return "redirect:/mByCReport";
	}
}
