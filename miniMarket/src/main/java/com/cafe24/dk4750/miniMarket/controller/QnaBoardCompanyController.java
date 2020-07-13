package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.QnaBoardCompanyService;
import com.cafe24.dk4750.miniMarket.service.QnaCommentCompanyService;
import com.cafe24.dk4750.miniMarket.vo.QnaBoardCompany;
import com.cafe24.dk4750.miniMarket.vo.QnaBoardCompanyAndCompany;

@Controller
public class QnaBoardCompanyController {
	@Autowired
	private QnaBoardCompanyService qnaBoardCompanyService;
	@Autowired
	private QnaCommentCompanyService qnaCommentCompanyService;
	
	// QnA 수정 액셩
	@PostMapping("modifyQnaBoardCompany")
	public String modifyQnaBoardCompany(QnaBoardCompany qnaBoardCompany) {
		// 내가 쓴글만 접근 가능 하게 세션 companyUniqueNo 와 글의 companyUniqueNo의 값을 비교
		qnaBoardCompanyService.modifyQnaBoardCompany(qnaBoardCompany);
		
		return "redirect:/getQnaBoardCompany";
	}
	// QnA 수정 페이지 요청
	@GetMapping("modifyQnaBoardCompany")
	public String modifyQnaBoardCompany(Model model, @RequestParam(value="qnaBoardCompanyNo") int qnaBoardCompanyNo) {
		QnaBoardCompanyAndCompany qnaBoardCompanyAndCompany = qnaBoardCompanyService.getQnaBoardCompanyOne(qnaBoardCompanyNo);
		model.addAttribute("qnaOne", qnaBoardCompanyAndCompany);
		
		return "modifyQnaBoardCompany";
	}
	// QnA 입력 페이지 액션
	@PostMapping("addQnaBoardCompany")
	public String addQnaBoardCompany(QnaBoardCompany qnaBoardCompany) {
		// companyUniqueNo는 세션값으로 받는데 일단은 임의로 준다
		String companyUniqueNo = "c000002";
		qnaBoardCompany.setCompanyUniqueNo(companyUniqueNo);
		System.out.println(qnaBoardCompany + "<--addQnaBoardCompany: qnaBoardCompany");
		qnaBoardCompanyService.addQnaBoardCompany(qnaBoardCompany);
		
		return "redirect:/getQnaBoardCompany";
	}
	// QnA 입력 페이지 요청
	@GetMapping("addQnaBoardCompany")
	public String addQnaBoardCompany() {
		return "addQnaBoardCompany";
	}
	// QnA상세보기 페이지 요청, 댓글(페이징) 입력
	@GetMapping("getQnaBoardCompanyOne")
	public String qnaBoardCompanyOne(Model model, @RequestParam(value="qnaBoardCompanyNo") int qnaBoardCompanyNo) {
		System.out.println(qnaBoardCompanyNo + "<--getQnaBoardCompanyOne: qnaBoardCompanyNo");
		QnaBoardCompanyAndCompany qnaBoardCompanyAndCompany = qnaBoardCompanyService.getQnaBoardCompanyOne(qnaBoardCompanyNo);
		model.addAttribute("qnaOne", qnaBoardCompanyAndCompany);
		
		return "getQnaBoardCompanyOne";
	}
	// 업체 자주묻는 질문 및 QnA
	@GetMapping("getQnaBoardCompany")
	public String qnaBoardCompanyList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		// Qna 리스트 출력 및 페이징
		System.out.println(currentPage + "<--qnaBoardCompanyList currentPage");
		Map<String, Object> map = qnaBoardCompanyService.getQnaBoardCompanyList(currentPage);
		System.out.println(map.get("qnaBoardCompanyBoardList") + "qnaBoardCompanyList List");
		System.out.println(map.get("lastPage") + "qnaBoardCompanyList: lastPage");
		model.addAttribute("list", map.get("qnaBoardCompanyBoardList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		return "getQnaBoardCompany";
	}
}
