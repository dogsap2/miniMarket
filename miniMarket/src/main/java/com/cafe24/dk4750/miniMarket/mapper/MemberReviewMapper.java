package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.MemberReview;

@Mapper
public interface MemberReviewMapper {
	
	// 인설트 리뷰
	public int insertReview(MemberReview memberReview);
	
	// 리뷰 체크
	public int reviewCheck(MemberReview memberReview);
}
