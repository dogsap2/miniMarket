package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.vo.*;
@Controller
public class ReportMByMController {

	 @GetMapping("/mByMReport")
	   public String addReport() {
	      return "mByMReport";
	   }
	   @PostMapping("/mByMReport")
	   public String addReport(ReportMemberByMember reportMByM) {
	      System.out.println(reportMByM);
	      return "redirect:/mByMReport";
	   }
}
