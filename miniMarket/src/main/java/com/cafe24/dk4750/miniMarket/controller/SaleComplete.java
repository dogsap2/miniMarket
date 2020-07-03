package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.MemberItemService;
import com.cafe24.dk4750.miniMarket.vo.MemberItem;

@RestController
public class SaleComplete {
	@Autowired private MemberItemService memberItemService;
	
	@GetMapping("/SaleComplete")
	public int SalesComplete(MemberItem memberItem) {
		
		return memberItemService.itemSalesComplete(memberItem);
	}
}
