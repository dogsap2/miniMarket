package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.ReportMemberByMemberItemService;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberItem;

@Controller
public class ReportMByMitemController {
   @Autowired 
   private ReportMemberByMemberItemService reportMByMitemService;
	
	
   @GetMapping("/mByMItemReport")
   public String addReport() {
      return "mByMReport";
   }
   @PostMapping("/mByMItemReport")
   public String addReport(ReportMemberByMemberItem reportMemberByMemberItem) {
      System.out.println(reportMemberByMemberItem);
      reportMByMitemService.addReportMemberByMemberItem(reportMemberByMemberItem);
      return "redirect:/mByMReport";
   }
   
}