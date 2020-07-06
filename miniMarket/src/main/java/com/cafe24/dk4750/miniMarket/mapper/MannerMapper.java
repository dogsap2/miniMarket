package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Manner;

@Mapper
public interface MannerMapper {
	
	// good 매너 평가하기
	public int insertGoodManner(Manner manner);
	
	// bad 매너 평가하기
	public int insertBadManner(Manner manner);
}
