package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.MemberReviewService;
import com.cafe24.dk4750.miniMarket.vo.MemberReview;

@RestController
public class ReviewCheck {
	
	@Autowired MemberReviewService memberReviewService;
	
	//리뷰 체크하는 레스트 컨트롤러
	@GetMapping("/reviewCheck")
	public int reviewCheck(MemberReview memberReview) {
		System.out.println(memberReview + " <== Review check / memberReview 디버깅");
		System.out.println(memberReview.getMemberItemNo() + " <== review check / memberItemNo");
		
		// 세션에서 받아야 할 리뷰자의 id를 임의로 설정해주기
		String memberId = "test2";
		memberReview.setMemberId(memberId);
		memberReview.setMemberUniqueNo(memberReview.getMemberUniqueNoSale());
		System.out.println(memberReview + " <== Review check / memberReview 디버깅. memberId 넣은값");
		
		// 리뷰체크 결과물 리턴... 평가한적이 있다면 1.. 없다면 0
		return memberReviewService.reviewCheck(memberReview);
	}
}
