package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.MannerService;
import com.cafe24.dk4750.miniMarket.vo.ItemSoldoutAndMemberItemAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.Manner;

@Controller
public class MannerController {
	@Autowired private MannerService mannerService;
	
	//매너 평가 하기 겟맵핑 (폼)
	@GetMapping("/addManner")
	public String addManner(Model model, ItemSoldoutAndMemberItemAndMemberItemPic itemSoldoutAndMemberItemAndMemberItemPic) {
		System.out.println("addManner Controller start..");
		
		int memberItemNo = itemSoldoutAndMemberItemAndMemberItemPic.getMemberItemNo();
		String memberUniqueNo = itemSoldoutAndMemberItemAndMemberItemPic.getMemberUniqueNo();
		String memberUniqueNoSale = itemSoldoutAndMemberItemAndMemberItemPic.getMemberUniqueNoSale();
		System.out.println(memberUniqueNo + " <== subUnique 디버깅");
		System.out.println(memberUniqueNoSale + " <== subUniqueSale 디버깅");
		System.out.println(memberItemNo + " <== memberItemNo 디버깅");
		model.addAttribute("memberItemNo", memberItemNo);
		model.addAttribute("memberUniqueNo", memberUniqueNo);
		model.addAttribute("memberUniqueNoSale", memberUniqueNoSale);
		
		return "addManner";
	}
	
	//매너 평가하기  goodAddManner 포스트 맵핑 (액션)
	@PostMapping("/goodAddManner")
	public String goodAddManner(Manner manner) {
		System.out.println(manner + " <== good manner");
		String memberId = "test2";
		manner.setMemberId(memberId);
		
		mannerService.addGoodManner(manner);
		
		return "addMember";
	}
	
	//매너 평가하기  badAddManner 포스트 맵핑 (액션)
	@PostMapping("/badAddManner")
	public String badAddManner(Manner manner) {
		System.out.println(manner + " <== bad manner");
		String memberId = "test2";
		manner.setMemberId(memberId);
		
		mannerService.addBadManner(manner);
		
		return "addMember";
	}
}
