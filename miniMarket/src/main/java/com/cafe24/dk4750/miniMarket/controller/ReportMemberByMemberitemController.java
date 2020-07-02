package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.ReportMemberByMemberItemService;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberItem;



@Controller
public class ReportMemberByMemberitemController {
   @Autowired 
   private ReportMemberByMemberItemService reportMByMitemService;
	
	
   @GetMapping("/memberByMemberItemReport")
   public String addReport() {
      return "memberByMemberReport";
   }
   @PostMapping("/memberByMemberItemReport")
   public String addReport(ReportMemberByMemberItem reportMemberByMemberItem) {
      System.out.println(reportMemberByMemberItem);
      return "redirect:/memberByMemberReport";
   }
   
}