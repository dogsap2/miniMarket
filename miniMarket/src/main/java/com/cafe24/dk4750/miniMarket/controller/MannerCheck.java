package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.MannerService;
import com.cafe24.dk4750.miniMarket.vo.Manner;

@RestController
public class MannerCheck {
	@Autowired MannerService mannerService;
	
	@GetMapping("/mannerCheck")
	public int mannerCheck(Manner manner) {
		System.out.println(manner + " <== manner 디버깅..");
		System.out.println(manner.getMemberItemNo() + " <==memberItemNo....");
		
		// 세션에서 받아야 할 구매자의 id를 임의로 설정해주기
		String memberId = "test2";
		manner.setMemberId(memberId);
		
		// 매너체크 결과물 리턴... 평가한적이 있다면 1.. 없다면 0
		return mannerService.mannerCheck(manner);
	}
}
