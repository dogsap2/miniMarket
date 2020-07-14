package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.QnaBoardService;
import com.cafe24.dk4750.miniMarket.service.QnaCommentService;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.QnaBoardMember;
import com.cafe24.dk4750.miniMarket.vo.QnaCommentMember;

@Controller
public class QnaBoardController {
	@Autowired
	private QnaBoardService qnaBoardService;
	@Autowired QnaCommentService qnaCommentService;
	
	@PostMapping("/addQnaBoardCommentMember")
	public String addQnaCommentMember(HttpSession session ,QnaCommentMember qnaCommentMember) {
		if(session.getAttribute("loginMember") == null) {
	         return "redirect:/index";
	      }
		System.out.println(qnaCommentMember + "<---controller qnaCommentMember");
		qnaCommentService.addQnaCommentMember(qnaCommentMember);
		System.out.println(qnaCommentMember.getQnaBoardMemberNo());
		return "redirect:/qnaBoardMemberOne?qnaBoardMemberNo="+qnaCommentMember.getQnaBoardMemberNo();
	}
	//자주 묻는 질문 리스트 + 페이징 + 검색 예정
	@GetMapping("/qnaBoardMember")
	public String getQnaBoardMemberList(HttpSession session , Model model , @RequestParam(value= "currentPage", defaultValue = "1") int currentPage){
		System.out.println(currentPage + "<---페이지 초기 번호");
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		System.out.println(beginRow+"<---beginRow");
		
		Map<String , Object> map = qnaBoardService.getQnaBoardMemberList(beginRow, rowPerPage);
		
		//페이지 초기 번호
		model.addAttribute("currentPage", currentPage);
		//자주 묻는 질문 리스트 + 페이징
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		return "qnaBoardMember";
	}
	// 상세보기
	@GetMapping("/qnaBoardMemberOne")
	public String getQnaBoardMemberOne(HttpSession session , Model model , @RequestParam(value= "currentPage", defaultValue = "1") int currentPage ,@RequestParam("qnaBoardMemberNo") int qnaBoardMemberNo) {
		if(session.getAttribute("loginMember") == null) {
	         return "redirect:/index";
	      }
		
		System.out.println(qnaBoardMemberNo+"<---qnaBoardMemberNo controller");
		String memberUniqueNo = ((LoginMember)session.getAttribute("loginMember")).getMemberUniqueNo();
		System.out.println(memberUniqueNo+"<--세션 유니크넘버 controller");
		int rowPerPage = 5;
		int beginRow = (currentPage - 1)*rowPerPage;
		System.out.println(beginRow);
		
		Map<String, Object> map = qnaBoardService.getQnaBoardMemberOne(qnaBoardMemberNo, beginRow, rowPerPage);
		model.addAttribute("CommentList", map.get("list"));
		model.addAttribute("qnaBoardMember", map.get("qnaBoardMember"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("memberUniqueNo", memberUniqueNo);
		
		return "qnaBoardMemberOne";
	}
	// 자주 묻는 질문 추가
	@GetMapping("/addQnaBoardMember")
	public String addQnaBoardMember(HttpSession session, Model model) {
		if(session.getAttribute("loginMember") == null) {
	         return "redirect:/index";
	      }
		String memberUniqueNo = ((LoginMember)session.getAttribute("loginMember")).getMemberUniqueNo();
		model.addAttribute("memberUniqueNo", memberUniqueNo);
		return "addQnaBoardMember";
	}
	// 자주 묻는 질문 추가 액션
	@PostMapping("/addQnaBoardMember")
	public String addQnaBoardMember(QnaBoardMember qnaBoardMember) {
		System.out.println(qnaBoardMember);
		qnaBoardService.addQnaBoardMember(qnaBoardMember);
		
		return "redirect:/qnaBoardMember";
	}
}
