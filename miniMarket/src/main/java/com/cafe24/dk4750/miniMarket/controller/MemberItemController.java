package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.CheckLikeService;
import com.cafe24.dk4750.miniMarket.service.MemberItemService;
import com.cafe24.dk4750.miniMarket.vo.ItemSoldout;
import com.cafe24.dk4750.miniMarket.vo.MemberItem;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.MemberItemForm;
import com.cafe24.dk4750.miniMarket.vo.MemberItemLike;
import com.cafe24.dk4750.miniMarket.vo.MemberItemPic;

@Controller
public class MemberItemController {
	@Autowired MemberItemService memberItemService;
	@Autowired CheckLikeService checkLikeService;
	
	// 구매자의 구매완료 아이템 리스트
	@GetMapping("/getBuyListByMember")
	public String getBuyListByMember(Model model) {
		
		//구매자의 구매완료 아이템 리스트 
		List<ItemSoldout> list = memberItemService.getBuyListByMember();
		model.addAttribute("list", list);
		
		return "getBuyListByMember";
	}
	
	// 나의 판매완료 아이템 리스트
	@GetMapping("/getItemListBySaleMyItem")
	public String getItemListBySaleMyItem(Model model) {
		
		// 나의 판매완료 아이템 리스트
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemService.getItemListBySaleMyItem();
		
		// 나의 판매완료 아이템 리스트 모델로 값 넘기기
		model.addAttribute("list", list);
		
		return "getItemListBySaleMyItem";
	}
	
	// 나의 판매중인 아이템 리스트
	@GetMapping("/getItemListMyItem")
	public String getItemListMyItem(Model model) {
		
		// 나의 판매중인 아이템 리스트
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemService.getItemListMyItem();
		
		// 나의 판매중인 아이템 리스트 모델로 값 넘기기
		model.addAttribute("list", list);
		
		return "getItemListMyItem";
	}
	
	// 멤버 추가하기 겟매핑. 페이지요청. 폼
	@GetMapping("/addMemberItem")
	public String addMemberItem() {
		System.out.println("addMemberItem 겟매핑 시작");
		
		// 페이지요청
		return "addMemberItem";
	}
	
	// 멤버 추가하기 포스트매핑. 액션
	@PostMapping("/addMemberItem")
	public String addMemberItem(MemberItemForm memberItemForm) {
		System.out.println("addMemberItem 포스트매핑 시작");
		System.out.println(memberItemForm + " <== 멤어 아이템 추가 memberItemForm");
		System.out.println(memberItemForm.getMemberItemPic1().getOriginalFilename() + " <== pic1");
		System.out.println(memberItemForm.getMemberItemPic2().getOriginalFilename() + " <== pic2");
		System.out.println(memberItemForm.getMemberItemPic3().getOriginalFilename() + " <== pic3");
		System.out.println(memberItemForm.getMemberItemPic4().getOriginalFilename() + " <== pic4");
		System.out.println(memberItemForm.getMemberItemPic5().getOriginalFilename() + " <== pic5");
		
		memberItemService.addMemberItem(memberItemForm);
		
		// 리턴
		return "index";
	}
	
	// 멤버 아이템 수정하기 겟매핑. 페이지요청. 폼
	@GetMapping("/modifyMemberItem")
	public String modifyMemberItem(Model model) {
		System.out.println("modifyMemberItem 겟매핑 시작");
		
		// 임시 넘버
		int memberItemNo = 1;
		String memberUniqueNo = "test1";
		
		MemberItemLike memberItemLike = new MemberItemLike();
		memberItemLike.setMemberItemNo(memberItemNo);
		memberItemLike.setMemberUniqueNo(memberUniqueNo);
		
		Integer check = checkLikeService.defaultLike(memberItemLike);
		System.out.println(check + " <== check");
		
		// 기존 정보 불러오기
		Map<String, Object> map = memberItemService.getMemberItemOne(memberItemNo);
		MemberItemPic memberItemPic = (MemberItemPic)map.get("memberItemPic");
		MemberItem memberItem = (MemberItem)map.get("memberItem");
		System.out.println(memberItemPic + " <== Controller memberItemPic");
		System.out.println(memberItem + " <== Controller memberItem");
		System.out.println(memberItemPic.getMemberItemPic1() + " <== Controller memberItemPic1");
		
		// 모델에 값 담아서 페이지에 보내주기
		model.addAttribute("memberItem", memberItem);
		model.addAttribute("memberItemPic", memberItemPic);
		model.addAttribute("check", check);
		// 페이지요청
		return "modifyMemberItem";
	}
	
	// 멤버 아이템 수정하기 포스트맵핑. 액션
	@PostMapping("/modifyMemberItem")
	public String modifyMemberItem(MemberItemForm memberItemForm) {
		System.out.println("modifyMemberItem 포스트매핑 시작");
		System.out.println(memberItemForm + " <== 멤버 아이템 수정하기 / memberItemForm 디버깅");
		
		
	    // 임의로 아이템 넘버 정해주기 
	    int memberItemNo = 1;
	    memberItemForm.setMemberItemNo(memberItemNo);
	  
	    // 업데이트 실행 
	    memberItemService.modifyMemberItem(memberItemForm);
		 
		// 페이지 요청
		return "index";
	}
	
	// 판매중인 동네 아이템 리스트 출력하기
	@GetMapping("/getMemberItemList")
	public String getMemberItemList(Model model) {
		System.out.println("getMemberItemList 겟매핑 시작");
		
		// 리스트 받아오기
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemService.getMemberItemList();
		
		// list 모델에 담아서 페이지로 보내주기
		model.addAttribute("list", list);
		
		// 페이지 요청
		return "getMemberItemList";
	}
	
	// 아이템 삭제(비활성화)
	@GetMapping("/disabledMemberItem")
	public String disabledMemberItem(MemberItem memberItem) {
		System.out.println("disabledMemberItem 겟매핑 시작");
		System.out.println(memberItem + " <== 아이템 삭제 / 멤버 아이템 넘버 디버깅");
		
		String memberItemState = "상품삭제";
		memberItem.setMemberItemState(memberItemState);
		
		memberItemService.disabledMemberItem(memberItem);
		
		return "redirect:/getMemberItemList";
	}
}
