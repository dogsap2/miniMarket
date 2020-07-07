package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Manner;

@Mapper
public interface MannerMapper {
	
	// good 매너 평가하기
	public int insertGoodManner(Manner manner);
	
	// bad 매너 평가하기
	public int insertBadManner(Manner manner);
	
	// 해당 아이템에 매너평가를 한 적이 있는지 체크 
	public int mannerCheck(Manner manner);
}
