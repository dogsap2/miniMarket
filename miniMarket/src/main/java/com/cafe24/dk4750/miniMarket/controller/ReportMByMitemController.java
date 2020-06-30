package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.vo.ReportMByMitem;

@Controller
public class ReportMByMitemController {
   
   @GetMapping("/addReport")
   public String addReport() {
      return "addReport";
   }
   @PostMapping("/addReport")
   public String addReport(ReportMByMitem reportMByMitem) {
      System.out.println(reportMByMitem);
      return "redirect:/addReport";
   }
}