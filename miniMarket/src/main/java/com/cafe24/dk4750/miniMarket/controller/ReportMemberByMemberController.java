package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.vo.*;
@Controller
public class ReportMemberByMemberController {

	 @GetMapping("/memberByMemberReport")
	   public String addReport() {
	      return "memberByMemberReport";
	   }
	   @PostMapping("/memberByMemberReport")
	   public String addReport(ReportMemberByMember reportMemberByMember) {
	      System.out.println(reportMemberByMember);
	      return "redirect:/memberByMemberReport";
	   }
}
