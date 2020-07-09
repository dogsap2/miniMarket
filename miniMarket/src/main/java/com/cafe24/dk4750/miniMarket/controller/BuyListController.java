package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.MemberItemService;
import com.cafe24.dk4750.miniMarket.vo.ItemSoldout;

@RestController
public class BuyListController {
	@Autowired private MemberItemService memberItemService;
	
	// 내가 구매한 아이템 리스트
	@GetMapping("/getBuyListByMember2")
	public List<ItemSoldout> getBuyListByMember(HttpSession session) {
		
		// 내 구매리스트 출력해주기.
		List<ItemSoldout> list = memberItemService.getBuyListByMember(session);
		
		return list;
	}
}
