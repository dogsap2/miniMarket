package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.QnaCommentCompanyService;
import com.cafe24.dk4750.miniMarket.vo.QnaCommentCompany;

@Controller
public class QnaCommentCompanyController {
	@Autowired
	private QnaCommentCompanyService qnaCommentCompanyService;
	
	// 댓글 삭제
	@GetMapping("removeQnaCommentCompany")
	public String removeCommentCompany(@RequestParam(value="qnaCommentCompanyNo") int qnaCommentCompanyNo, @RequestParam(value="qnaBoardCompanyNo") int qnaBoardCompanyNo) {
		// 관리자 권한
		System.out.println(qnaCommentCompanyNo + "<------removeCommentCompany: qnaCommentCompanyNo");
		System.out.println(qnaBoardCompanyNo + "<------removeCommentCompany: qnaBoardCompanyNo");
		qnaCommentCompanyService.removeCommentCompany(qnaCommentCompanyNo);
		
		return "redirect:getQnaBoardCompanyOne?qnaBoardCompanyNo="+qnaBoardCompanyNo;
	}
	// 댓글 입력
	@PostMapping("addQnaCommentCompany")
	public String addQnaCommentCompany(QnaCommentCompany qnaCommentCompany, @RequestParam(value="qnaBoardCompanyNo") int qnaBoardCompanyNo) {
		// 관리자 권한
		
		// 관리자 id를 세션으로 받아오지만 지금은 테스트용
		System.out.println(qnaBoardCompanyNo + "<------ 댓글 입력");
		String adminId = "admin";
		qnaCommentCompany.setAdminId(adminId);
		qnaCommentCompany.setQnaBoardCompanyNo(qnaBoardCompanyNo);
		
		qnaCommentCompanyService.addQnaCommentCompany(qnaCommentCompany);
		
		return "redirect:getQnaBoardCompanyOne?qnaBoardCompanyNo="+qnaBoardCompanyNo;
	}
}
