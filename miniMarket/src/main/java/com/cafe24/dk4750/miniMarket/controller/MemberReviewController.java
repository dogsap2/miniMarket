package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.MemberReviewService;
import com.cafe24.dk4750.miniMarket.vo.MemberReview;

@Controller
public class MemberReviewController {
	@Autowired private MemberReviewService memberReviewService;
	
	//리뷰 인서트  겟 맵핑
	@GetMapping("/addReview")
	public String addReview(MemberReview memberReview, Model model) {
		System.out.println(memberReview +"<== 리뷰 작성 하기 겟맵핑 값확인");
		
		model.addAttribute("memberReview", memberReview);
		
		return "addReview";
	}
	
	//리뷰 인서트 포스트 맵핑
	@PostMapping("/addReview")
	public void addReview(MemberReview memberReview) {
		System.out.println(memberReview+"<== 리뷰 작성 하기 포스트맵핑  값확인");
		memberReviewService.addReview(memberReview);
	}
}
