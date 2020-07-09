package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.MannerService;
import com.cafe24.dk4750.miniMarket.vo.ItemSoldoutAndMemberItemAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.Manner;

@Controller
public class MannerController {
	@Autowired private MannerService mannerService;
	
	//매너 평가 하기 겟맵핑 (폼)
	@GetMapping("/addManner")
	public String addManner(HttpSession session, Model model, ItemSoldoutAndMemberItemAndMemberItemPic itemSoldoutAndMemberItemAndMemberItemPic) {
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
		
		return "addManner"; // 리뷰 작성한다고 했을 때
	}
	
	//매너 평가하기  goodAddManner 포스트 맵핑 (액션)
	@PostMapping("/goodAddManner")
	public void goodAddManner(HttpSession session ,Manner manner) {
		System.out.println();
		System.out.println(manner + " <== good manner");
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		manner.setMemberId(memberId);
		mannerService.addGoodManner(manner);
	}
	
	//매너 평가하기  badAddManner 포스트 맵핑 (액션)
	@PostMapping("/badAddManner")
	public void badAddManner(HttpSession session, Manner manner) {
		System.out.println(manner + " <== bad manner");
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		manner.setMemberId(memberId);
		
		mannerService.addBadManner(manner);
	}
}
