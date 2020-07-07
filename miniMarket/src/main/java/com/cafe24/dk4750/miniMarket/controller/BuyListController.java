package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.MemberItemService;
import com.cafe24.dk4750.miniMarket.vo.ItemSoldout;

@RestController
public class BuyListController {
	@Autowired private MemberItemService memberItemService;
	
	// 내가 구매한 아이템 리스트
	@GetMapping("/getBuyListByMember2")
	public List<ItemSoldout> getBuyListByMember(Model model) {
		
		List<ItemSoldout> list = memberItemService.getBuyListByMember();
		
		return list;
	}
}
