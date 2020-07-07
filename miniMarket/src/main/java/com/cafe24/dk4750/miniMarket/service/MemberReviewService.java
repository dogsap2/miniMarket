package com.cafe24.dk4750.miniMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.MemberReviewMapper;
import com.cafe24.dk4750.miniMarket.vo.MemberReview;

@Service
@Transactional
public class MemberReviewService {
	@Autowired private MemberReviewMapper memberReviewMapper;
	
	//리뷰가 있는지 없는 지 체크 서비스
	public int reviewCheck(MemberReview memberReview) {
		return memberReviewMapper.reviewCheck(memberReview);
	}
	
	// 리뷰 작성하기 서비스 
	public int addReview(MemberReview memberReview) {
		
		// 임시 구매자 아이디.. 추후에 세션에서 받아오는걸로
		String memberId = "test2";
		memberReview.setMemberId(memberId);
		
		// 판매자
		memberReview.setMemberUniqueNo(memberReview.getMemberUniqueNoSale());
		
		return memberReviewMapper.insertReview(memberReview);
	}
}
