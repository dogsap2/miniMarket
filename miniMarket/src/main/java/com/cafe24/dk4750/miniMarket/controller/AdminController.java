package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.AdminService;
import com.cafe24.dk4750.miniMarket.vo.Admin;
import com.cafe24.dk4750.miniMarket.vo.LoginAdmin;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;

@Controller
public class AdminController {
	@Autowired private AdminService adminService;
	
	// 로그인 폼 겟맵핑
	@GetMapping("loginAdmin")
	public String loginAdmin(HttpSession session) {
		//로그인 중일때 
		if(session.getAttribute("loginAdmin")!= null){
			return "redirect:/";
		}				
		return "loginAdmin";
	}
	
	// 로그인 액션 포스트맵핑
	@PostMapping("loginAdmin")
	public String loginAdmin(Model model, Admin admin, HttpSession session) {
		//로그인 중일때 
		if(session.getAttribute("loginAdmin")!= null){
			return "redirect:/index";
		}
		LoginAdmin returnLoginAdmin = adminService.getLoginAdmin(admin);
		System.out.println(returnLoginAdmin+"<====관리자 로그인 포스트 맵핑 로그인 확인");
		// 일치하지 않으면 로그인 실패
		if(returnLoginAdmin == null) {
			model.addAttribute("msg","아이디와 비밀번호를 확인하세요");
			return "loginAdmin"; 
		} else { // 로그인 성공
			session.setAttribute("loginAdmin", returnLoginAdmin);
			return "redirect:/index"; 
		}
	}
	// 로그아웃하기
	@GetMapping("/logoutAdmin")
	public String logout(HttpSession session) {
		// 로그인 실패시 로그인 폼으로
		if (session.getAttribute("loginAdmin") == null) {
			return "redirect:/index"; // index로 넘겨줌
		}
		session.invalidate(); // 로그아웃
		return "redirect:/index"; // 로그아웃 후 index 넘겨줌
	}
	
}
