package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.MemberItem;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberInterestPlaceAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPicAndMemberItemLike;

@Mapper
public interface MemberItemMapper {
	
	// 판매자의 판매중인 아이템 판매완료로 수정
	public int itemSalesComplete(MemberItem memberItem);
	
	// 멤버 아이템 추가
	public int insertMemberItem(MemberItem memberItem);
	
	// 한 멤버 아이템 정보 출력하기
	public MemberItem selectMemberItemOne(int memberItemNo);
	
	// 멤버 아이템 수정 액션
	public int updateMemberItem(MemberItem memberItem);
	
	// 판매중인 동네 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPic> selectItemList(Map<String, Object> map);
	
	// 카테고리별 판매중인 동네 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPic> selectItemListByCategory(Map<String, Object> map);
	
	// 판매중인 관심동네 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberInterestPlaceAndMemberItemPic> selectItemListByPlace(Map<String, Object> map);
	
	// 판매중인 나의 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPic> selectItemListMyItem(Map<String, Object> map);
	
	// 나의 판매완료 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPic> selectItemListBySaleMyItem(Map<String, Object> map);
	
	// 아이템 삭제(비활성화)
	public int disabledMemberItem(MemberItem memberItem);
	
	// 다음 멤버 아이템의 넘버를 알기위해서 현재 멤버 아이템넘버 max+1 값 구해오기
	public int selectMaxPlusMemberItemNo();
	
	// 내가 좋아요 한 멤버 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPicAndMemberItemLike> selectMyLikeItem(Map<String, Object> map);
}
