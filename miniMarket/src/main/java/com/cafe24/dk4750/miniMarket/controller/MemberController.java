package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.MemberService;
import com.cafe24.dk4750.miniMarket.vo.Member;

@Controller
public class MemberController {
	@Autowired 
	private MemberService memberService; 

	//회원가입  
	@GetMapping("/addMember")
	public String addMember(HttpSession session) {
		if(session.getAttribute("loginMember")!= null){
			return "redirect:/index";
		}		
		return "addMember";
		
	}
	
	
	@PostMapping("/addMember")
	public String addMember(Member member, HttpSession session){
		//로그인 중이면 다시 리다이렉트 
		if(session.getAttribute("loginMember")!= null){
			return "redirect:/index";
		}		
		System.out.println(member +"<---addMember member");
		
		//회원가입 서비스 호출
		memberService.addMember(member);
		
		return "redirect:/index";				
	}
	
	// 멤버 사진추가 
	
	//멤버 아이디 중복확인 
	
	// 핸드폰 중복확인 
	
	//이메일 중복확인
	
	// 로그인 유효성 검사
	
	//나의 정보보기
	
	// 멤버사진 수정 
	
	// 탈퇴 

	//멤버 백업 
	
	// 아이디 찾기
	
	//비번찾기
	
}
