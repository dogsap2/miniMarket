package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.MemberService;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.Member;


@Controller
public class MemberController {
	@Autowired 
	private MemberService memberService; 

	// 로그아웃하기
	@GetMapping("/logoutMember")
	public String logout(HttpSession session) {
		// 로그인 실패시 로그인 폼으로
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/index"; // index로 넘겨줌
		}
		session.invalidate(); // 로그아웃
		return "redirect:/index"; // 로그아웃 후 index 넘겨줌
	}
	
	//로그인 폼 
	@GetMapping("/loginMember")
	public String loginMember(HttpSession session) {
		//로그인 중일때 
		if(session.getAttribute("loginMember")!= null){
			return "redirect:/";
		}				
		return "loginMember";
		
	}
	
	//로그인 액션 
	@PostMapping("/loginMember")
	public String loginMember(Model model ,LoginMember loginMember, HttpSession session) {
		//로그인 중일때 
		if(session.getAttribute("loginMember")!= null){
			return "redirect:/index";
		}
		System.out.println("loginMember 로그인 확인" +loginMember); 
		LoginMember returnLoginMember= memberService.selectLoginMember(loginMember);
		System.out.println("리턴 로그인 returnLoginMember:"+returnLoginMember); //리턴 로그인 returnLoginMember:LoginMember [memberId=user1, memberPw=1234]
		if(returnLoginMember ==null) { //빈값이면 로그인 못함(로그인 실패시)
			model.addAttribute("msg","아이디와 비밀번호를 확인하세요");
			return "loginMember"; 
		}else{//로그인 성공시 (디비에 결과값 있으면 회원임)
			session.setAttribute("loginMember", returnLoginMember);
			return "redirect:/index"; // 홈으로감  
		}	
	}

	
	//회원가입  폼
	@GetMapping("/addMember")
	public String addMember(HttpSession session) {
		if(session.getAttribute("loginMember")!= null){
			return "redirect:/index";
		}		
		return "addMember";
		
	}
	
	//회원가입(이메일 인증 서비스도 포함)
	@PostMapping("/addMember")
	public String addMember(Member member,Model model, HttpSession session){
		//로그인 중이면 다시 리다이렉트 
		if(session.getAttribute("loginMember")!= null){
			return "redirect:/index";
		}		
		System.out.println(member +"<---addMember member");
		
		//이메일 임시 번호 전송 메세지 
	
		int row= memberService.addMember(member);
		
		String msg = "ㄴㅇㄹㄴㅀㄴ";
		if(row == 1) {
			msg="인증된 메일로 임시 비밀번호를 전송했습니다  확인 후 로그인 해주세요 "; 			
		}
		model.addAttribute("msg",msg);
		
		
		return "redirect:/index";				
	}
	
	
	@GetMapping("/index")
	public String index() {
		return "index";		
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
