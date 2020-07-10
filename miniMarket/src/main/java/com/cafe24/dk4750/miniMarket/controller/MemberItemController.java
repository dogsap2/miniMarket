package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.CategoryService;
import com.cafe24.dk4750.miniMarket.service.CheckLikeService;
import com.cafe24.dk4750.miniMarket.service.MemberItemService;
import com.cafe24.dk4750.miniMarket.vo.Category;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.MemberItem;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberPicAndMemberItemPicAndMemberTempTotalAndMemberItemLike;
import com.cafe24.dk4750.miniMarket.vo.MemberItemForm;
import com.cafe24.dk4750.miniMarket.vo.MemberItemLike;
import com.cafe24.dk4750.miniMarket.vo.MemberItemPic;

@Controller
public class MemberItemController {
	@Autowired private MemberItemService memberItemService;
	@Autowired private CheckLikeService checkLikeService;
	@Autowired private CategoryService categoryService;

	// 아이템 상세보기 겟매핑
	@GetMapping("/getItemOne")
	public String getItemOne(HttpSession session ,Model model, @RequestParam(value="memberItemNo") int memberItemNo, @RequestParam(value="pageCheck", defaultValue = "0") int pageCheck) {
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null) {
			return "index";
		}
		
		// 세션에서 내 유니크넘버 받아오기
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		
		// 내가 좋아요 한 적이 있는지 체크
		MemberItemLike memberItemLike = new MemberItemLike();
		memberItemLike.setMemberItemNo(memberItemNo);
		memberItemLike.setMemberUniqueNo(memberUniqueNo);
		
		Integer check = checkLikeService.defaultLike(memberItemLike);
		System.out.println(check + " <== check");
		
		// 아이템 상세보기 불러오기
		MemberItemAndMemberAndMemberPicAndMemberItemPicAndMemberTempTotalAndMemberItemLike getItemOne = memberItemService.getMemberItemOne(memberItemNo);
		
		// 모델에 담아주기
		model.addAttribute("getItemOne", getItemOne);
		model.addAttribute("check", check);
		System.out.println(getItemOne + " <== getItemOne");
		
		// 거래완료, 리스트에서는 수정이 안나오게끔... 이유는 판매하고 정보를 바꿔버릴수도 있기 때문에
		// 나의 판매중인 아이템리스트에만 수정버튼이 나오게끔
		model.addAttribute("pageCheck", pageCheck);
		
		return "getItemOne";
	}
	
	// 판매완료 
    @PostMapping("/soldOutComplete")
    public String soldOutComplete(@RequestParam("memberItemNo") int memberItemNo , @RequestParam("memberUniqueNo") String memberUniqueNo) {
		System.out.println(memberItemNo + "<--soldOutComplete itemNo");
		System.out.println(memberUniqueNo + "<--soldOutComplete memberUniqueNo");
		memberItemService.itemSalesComplete(memberItemNo, memberUniqueNo);
		  
		return "redirect:/index";
    }
	
	// 구매자의 구매완료 아이템 리스트
	@GetMapping("/getBuyListByMember") public String getBuyListByMember(HttpSession session) {
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null) {
			return "index";
		}
		
		return "getBuyListByMember"; 
	}
	 
	
	// 나의 판매완료 아이템 리스트
	@GetMapping("/getItemListBySaleMyItem")
	public String getItemListBySaleMyItem(HttpSession session, Model model) {
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null) {
			return "index";
		}
		
		// 내 판매완료 아이템 리스트 받아오기
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemService.getItemListBySaleMyItem(session);
		
		// 모델에 담아서 보내주기
		model.addAttribute("list", list);
		
		return "getItemListBySaleMyItem";
	}
	
	// 나의 판매중인 아이템 리스트
	@GetMapping("/getItemListMyItem")
	public String getItemListMyItem(HttpSession session, Model model) {
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null) {
			return "index";
		}
		
		return "getItemListMyItem";
	}
	
	// 멤버 추가하기 겟매핑. 페이지요청. 폼
	@GetMapping("/addMemberItem")
	public String addMemberItem(HttpSession session, Model model) {
		System.out.println("addMemberItem 겟매핑 시작");
		
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null) {
			return "index";
		}
		
		// 카테고리 목록 모델에담아서 포워딩 시켜주기
		List<Category> list = categoryService.getMemberCategory();
		System.out.println(list + " <== 중고물품등록 카테고리 이름");
		model.addAttribute("list", list);
		
		// 페이지요청
		return "addMemberItem";
	}
	
	// 멤버 추가하기 포스트매핑. 액션
	@PostMapping("/addMemberItem")
	public String addMemberItem(HttpSession session, MemberItemForm memberItemForm) {
		System.out.println("addMemberItem 포스트매핑 시작");

		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null) {
			return "index";
		}
		
		// 세션에서 유니크넘버 받기
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		System.out.println(memberUniqueNo + " <== memberUniqueNo");
		// form에 세션값 uniqueNo 넣어주기
		memberItemForm.setMemberUniqueNo(memberUniqueNo);
		
		System.out.println(memberItemForm + " <== 멤어 아이템 추가 memberItemForm");
		System.out.println(memberItemForm.getMemberItemPic1().getOriginalFilename() + " <== pic1");
		System.out.println(memberItemForm.getMemberItemPic2().getOriginalFilename() + " <== pic2");
		System.out.println(memberItemForm.getMemberItemPic3().getOriginalFilename() + " <== pic3");
		System.out.println(memberItemForm.getMemberItemPic4().getOriginalFilename() + " <== pic4");
		System.out.println(memberItemForm.getMemberItemPic5().getOriginalFilename() + " <== pic5");
		
		
		// 아이템 등록 실행
		memberItemService.addMemberItem(memberItemForm);
		
		// 리턴.. 나중에 수정
		return "index";
	}
	
	// 멤버 아이템 수정하기 겟매핑. 페이지요청. 폼
	@GetMapping("/modifyMemberItem")
	public String modifyMemberItem(HttpSession session ,Model model, @RequestParam(value="memberItemNo") int memberItemNo) {
		System.out.println("modifyMemberItem 겟매핑 시작");
		System.out.println(memberItemNo);
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null) {
			return "index";
		}
		
		// 기존 정보 불러오기
		Map<String, Object> map = memberItemService.getMemberItemOneForUpdate(memberItemNo);
		MemberItemPic memberItemPic = (MemberItemPic)map.get("memberItemPic");
		MemberItem memberItem = (MemberItem)map.get("memberItem");
		System.out.println(memberItemPic + " <== Controller memberItemPic");
		System.out.println(memberItem + " <== Controller memberItem");
		System.out.println(memberItemPic.getMemberItemPic1() + " <== Controller memberItemPic1");
		
		// 모델에 값 담아서 페이지에 보내주기
		model.addAttribute("memberItem", memberItem);
		model.addAttribute("memberItemPic", memberItemPic);
		
		// 페이지요청
		return "modifyMemberItem";
	}
	
	// 멤버 아이템 수정하기 포스트맵핑. 액션
	@PostMapping("/modifyMemberItem")
	public String modifyMemberItem(MemberItemForm memberItemForm) {
		System.out.println("modifyMemberItem 포스트매핑 시작");
		System.out.println(memberItemForm + " <== 멤버 아이템 수정하기 / memberItemForm 디버깅");
		
		// 넘어온 값으로 memberItemNo 값 담아주기
		int memberItemNo = memberItemForm.getMemberItemNo();
		
	    memberItemForm.setMemberItemNo(memberItemNo);
	  
	    // 업데이트 실행 
	    memberItemService.modifyMemberItem(memberItemForm);
		 
		// 페이지 요청
		return "index";
	}
	
	// 판매중인 동네 아이템 리스트 출력하기
	@GetMapping("/getMemberItemList")
	public String getMemberItemList(HttpSession session, Model model) {
		System.out.println("getMemberItemList 겟매핑 시작");
		// 세션이 널일시 인덱스로 이동
		if(session.getAttribute("loginMember") == null) {
			return "index";
		}
		
		// 리스트 받아오기
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemService.getMemberItemList(session);
		
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
