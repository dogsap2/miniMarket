package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.dk4750.miniMarket.mapper.MemberItemMapper;
import com.cafe24.dk4750.miniMarket.vo.MemberItem;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMember;

@Service
public class MemberItemService {
	@Autowired private MemberItemMapper memberItemMapper;
	//	@Autowired private MemberItemPicMapper memberItemPicMapper;
	//	@Autowired private CategoryMapper categoryMapper;
	//	@Autowired private MemberMapper memberMapper;
	
	// 멤버 아이템 추가
	public int addMemberItem(MemberItem memberItem) {
		System.out.println(memberItem + " <== 멤버 아이템 서비스/멤버 아이템 추가/멤버 아이템 디버깅");
		
		// 리턴
		return memberItemMapper.insertMemberItem(memberItem);
	}
	
	// 한개의 멤버 아이템 정보 가져오기
	public MemberItem getMemberItemOne(int memberItemNo) {
		System.out.println(memberItemNo + " <== 멤버 아이템 서비스/한개의 멤버 아이템 정보 가져오기/멤버 아이템 넘버 디버깅");
		
		// 리턴
		return memberItemMapper.selectMemberItemOne(memberItemNo);
	}
	
	// 멤버 아이템 수정
	public int modifyMemberItem(MemberItem memberItem) {
		System.out.println(memberItem + " <== 멤버 아이템 서비스/멤버 아이템 수정/멤버 아이템 디버깅");
		
		// 리턴
		return memberItemMapper.updateMemberItem(memberItem);
	}
	
	// 판매중인 동네 아이템 리스트 출력
	public List<MemberItemAndMember> getMemberItemList() {
		// beginRow, rowPerPage, bname, sigungu 등 입력할 데이터 담아서 보내주기.
		int beginRow = 0;
		int rowPerPage = 10;
		String memberBname = "test1";
		String memberSigungu = "test1";
		String searchWord = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("memberBname", memberBname);
		map.put("memberSigungu", memberSigungu);
		map.put("searchWord", searchWord);
		
		// 리스트 받아오기
		List<MemberItemAndMember> list = memberItemMapper.selectItemList(map);
		
		// 리스트 리턴
		return list;
	}
	
	// 아이템 삭제(비활성화)
	public int disabledMemberItem(MemberItem memberItem) {
		System.out.println(memberItem + " <== 멤버 아이템 서비스/멤버 아이템 삭제/멤버 아이템 디버깅");
		
		return memberItemMapper.disabledMemberItem(memberItem);
	}
}
