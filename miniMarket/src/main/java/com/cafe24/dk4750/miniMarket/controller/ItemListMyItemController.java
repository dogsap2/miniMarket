package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.MemberItemService;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPic;

@RestController
public class ItemListMyItemController {
	@Autowired private MemberItemService memberItemService;
	
	// 판매자가 판매완료한 아이템 리스트
	@GetMapping("/getItemListMyItem2")
	public List<MemberItemAndMemberAndMemberItemPic> getItemListMyItem(Model model) {
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemService.getItemListMyItem();
		return list;
	}
}
