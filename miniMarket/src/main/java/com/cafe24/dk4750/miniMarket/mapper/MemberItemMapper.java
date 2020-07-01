package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.MemberItem;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMember;

@Mapper
public interface MemberItemMapper {
	// 멤버 아이템 추가
	public int insertMemberItem(MemberItem memberItem);
	
	// 한 멤버 아이템 정보 출력하기
	public MemberItem selectMemberItemOne(int memberItemNo);
	
	// 멤버 아이템 수정 액션
	public int updateMemberItem(MemberItem memberItem);
	
	// 판매중인 동네 아이템 리스트 출력
	public List<MemberItemAndMember> selectItemList(Map<String, Object> map);
	
	// 아이템 삭제(비활성화)
	public int disabledMemberItem(MemberItem memberItem);
	
}
