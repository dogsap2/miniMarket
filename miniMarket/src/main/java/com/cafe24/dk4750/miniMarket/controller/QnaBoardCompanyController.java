package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.QnaBoardCompanyService;

@Controller
public class QnaBoardCompanyController {
	@Autowired
	private QnaBoardCompanyService qnaBoardCompanyService;
	@GetMapping("qnaBoardCompany")
	// 업체 자주묻는 질문 및 QnA
	public String qnaBoardCompanyList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		// Qna 리스트 출력 및 페이징
		System.out.println(currentPage + "<--qnaBoardCompanyList currentPage");
		Map<String, Object> map = qnaBoardCompanyService.getQnaBoardCompanyList(currentPage);
		System.out.println(map.get("qnaBoardCompanyBoardList") + "qnaBoardCompanyList List");
		System.out.println(map.get("lastPage") + "qnaBoardCompanyList: lastPage");
		model.addAttribute("list", map.get("qnaBoardCompanyBoardList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		return "qnaBoardCompany";
	}
}
