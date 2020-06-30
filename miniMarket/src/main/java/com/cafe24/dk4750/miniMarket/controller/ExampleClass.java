package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.vo.ReportMByMitem;

@Controller
public class ExampleClass {
		@GetMapping("/report")
		public String report() {
			
			return "report";
		}
		@PostMapping("/report")
		public String report(ReportMByMitem reportMByItem) {
			System.out.println(reportMByItem);
			return "redirect:/report";
		}
}