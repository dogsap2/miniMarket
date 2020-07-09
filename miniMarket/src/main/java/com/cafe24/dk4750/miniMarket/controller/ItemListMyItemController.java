package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.MemberItemService;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPic;

@RestController
public class ItemListMyItemController {
	@Autowired private MemberItemService memberItemService;
	
	// 판매자가 판매중인 아이템 리스트
	@GetMapping("/getItemListMyItem2")
	public List<MemberItemAndMemberAndMemberItemPic> getItemListMyItem(HttpSession session) {
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemService.getItemListMyItem(session);
		System.out.println(list+"<===list getItemListMyItem2 컨트롤러");
		return list;
	}
}
