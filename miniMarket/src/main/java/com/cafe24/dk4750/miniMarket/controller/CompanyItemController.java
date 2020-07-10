package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.CategoryService;
import com.cafe24.dk4750.miniMarket.service.CompanyItemService;
import com.cafe24.dk4750.miniMarket.vo.Category;
import com.cafe24.dk4750.miniMarket.vo.CompanyItem;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemAndCompanyAndCompanyItemPic;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemForm;
import com.cafe24.dk4750.miniMarket.vo.LoginCompany;

@Controller
public class CompanyItemController {
	@Autowired private CompanyItemService companyItemService;
	@Autowired private CategoryService categoryService;
	
	// 홍보중인 업체 아이템 카테고리별 출력하기
	@GetMapping("/getCompanyItemListByCategory")
	public String getCompanyItemListByCategory(HttpSession session, Model model, @RequestParam("categoryName") String categoryName) {
		System.out.println("getCompanyItemListByCategory<==겟메핑 시작");
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginCompany") == null && session.getAttribute("loginMember") == null) {
			return "index";
		}
		
		//카테고리 목록
		List<Category> categoryList = categoryService.getCompanyCategory();
		
		//아이템 리스트
		List<CompanyItemAndCompanyAndCompanyItemPic> list = companyItemService.getCompanyItemListByCategory(session, categoryName);
		System.out.println(categoryName+"<-----카테고리 네임값");
		//모델에 값넘기기
		model.addAttribute("list", list);
		model.addAttribute("categoryList", categoryList);
		System.out.println(list+"<===카테고리별 아이템 리스트 목록 컨트롤러");
		return "getCompanyItemListByCategory";
	}
	
	// 홍보중인 업체 아이템 리스트 출력하기
	@GetMapping("/getCompanyItemList")
	public String getCompanyItemList(HttpSession session, Model model) {
		System.out.println("getCompanyItemList<== 겟메핑 시작");
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginCompany") == null && session.getAttribute("loginMember") == null) {
			return "index";
		}
		
		//카테고리 목록
		List<Category> categoryList = categoryService.getCompanyCategory();
		
		// 리스트 받아오기
		List<CompanyItemAndCompanyAndCompanyItemPic> list = companyItemService.getCompanyItemList(session);
		
		// 리스트 모델에 담아서 페이지로 보내주기
		model.addAttribute("list", list);
		model.addAttribute("categoryList", categoryList);
		System.out.println(list+"<---리스트 정보");
		
		//페이지 요청
		return "getCompanyItemList";
	}
	
	// 업체 추가하기 겟매핑. 페이지요청. 폼
	@GetMapping("/addCompanyItem")
	public String addCompanyItem(HttpSession session, Model model) {
		System.out.println("addCompanyItem 겟매핑 시작");
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginCompany") == null && session.getAttribute("loginMember") == null) {
			return "index";
		}
		// 세션값의 유니크넘버 가져오기
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		String companyUniqueNo = loginCompany.getCompanyUniqueNo();
		
		//모델로 업체의 카테고리 리스트 넘겨주기
		List<Category> list = categoryService.getCompanyCategory();
		model.addAttribute("list", list);
		model.addAttribute("companyUniqueNo", companyUniqueNo);
		// 페이지 요청
		return "addCompanyItem";
	}
	
	// 업체 아이템 추가하기 포스트 매핑. 액션
	@PostMapping("/addCompanyItem")
	public String addCompanyItem(HttpSession session, CompanyItemForm companyItemForm) {
		System.out.println("addCompanyItem <== 포스트매핑 시작");
		System.out.println(companyItemForm +"<--- 업체 아이템 추가 companyItemForm");
		System.out.println(companyItemForm.getCompanyItemPic1().getOriginalFilename() + "<==pic1");
		System.out.println(companyItemForm.getCompanyItemPic1().getOriginalFilename() + "<==pic2");
		System.out.println(companyItemForm.getCompanyItemPic1().getOriginalFilename() + "<==pic3");
		System.out.println(companyItemForm.getCompanyItemPic1().getOriginalFilename() + "<==pic4");
		System.out.println(companyItemForm.getCompanyItemPic1().getOriginalFilename() + "<==pic5");
		// 업체 유니크넘버를 세션값을 받아오기
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		companyItemForm.setCompanyUniqueNo(loginCompany.getCompanyUniqueNo()); 
		System.out.println(companyItemForm.getCompanyUniqueNo()+"<---컴퍼니 아이템 포스트맵핑 컴퍼니 유니크 넘버가 제대로 넘어 오는지 확인");
		companyItemService.addCompanyItem(session, companyItemForm);
		// 리턴
		return "index";
	}
	
	// 업체 아이템 삭제(비활성화)
	@GetMapping("/disabledCompanyItem")
	public String disabledCompanyItem(CompanyItem companyItem) {
		System.out.println("disabledCompanyItem 겟매핑 시작");
		System.out.println(companyItem + "<==업체 아이템 삭제 / 업체 아이템 넘버 디버깅");
		
		String companyItemState = "삭제";
		companyItem.setCompanyItemState(companyItemState);
		
		companyItemService.disabledCompanyItem(companyItem);
		
		return "redirect:/getCompanyItemList";
	}
	
}
