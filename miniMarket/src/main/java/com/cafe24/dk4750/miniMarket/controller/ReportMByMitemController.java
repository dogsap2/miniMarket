package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.ReportMByMitemService;
import com.cafe24.dk4750.miniMarket.vo.ReportMByMitem;

@Controller
public class ReportMByMitemController {
   @Autowired 
   private ReportMByMitemService reportMByMitemService;
	
	
   @GetMapping("/mByMItemReport")
   public String addReport() {
      return "mByMReport";
   }
   @PostMapping("/mByMItemReport")
   public String addReport(ReportMByMitem reportMByMitem) {
      System.out.println(reportMByMitem);
      reportMByMitemService.addReportMByMitem(reportMByMitem);
      return "redirect:/mByMReport";
   }
   
}