package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.MemberItemPic;


@Mapper
public interface MemberItemPicMapper {
	public void insertMemberItemPic(MemberItemPic memberItemPic);
}
