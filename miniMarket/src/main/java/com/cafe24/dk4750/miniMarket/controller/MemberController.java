package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.MemberService;
import com.cafe24.dk4750.miniMarket.vo.Member;

@Controller
public class MemberController {
	@Autowired 
	private MemberService memberService; 
	
	//이메일 중복 확인  
	@PostMapping("/checkMemberEmail")
	public String checkMemberEmail(Model model, @RequestParam("checkMemberEmail")String checkMemberEmail ) {
		System.out.println(checkMemberEmail+ "<---checkMemberEmail잘 받아왔는지 확인");
		//서비스 호출 
		String memberEmail = memberService.selectMemberEmail(checkMemberEmail);
		
		//멤버 아이디가 빈값이면 사용 가능함 
		if(memberEmail == null) {
			System.out.println("메일을 사용할 수 있습니다");
			model.addAttribute("memberEmail",memberEmail); 
		}else {
			System.out.println("메일을 사용할 수 없습니다");
			model.addAttribute("msg3","사용중인 메일입니다"); 
		}	
		return "addMember"; //addMember.html페이지 보여줌  		
	}
	
	
	//전화번호 중복확인  
	@PostMapping("/checkMemberPhone")
	public String checkMemberPhone(Model model, @RequestParam("checkMemberPhone")String checkMemberPhone ) {
		System.out.println(checkMemberPhone+ "<---checkMemberPhone잘 받아왔는지 확인");
		//서비스 호출 
		String memberPhone = memberService.selectMemberPhone(checkMemberPhone);
		
		//멤버 아이디가 빈값이면 사용 가능함 
		if(memberPhone == null) {
			System.out.println("번호를 사용할 수 있습니다");
			model.addAttribute("checkMemberPhone",checkMemberPhone); 
		}else {
			System.out.println("전화번호를 사용할 수 없습니다");
			model.addAttribute("msg2","사용중인 전화번호입니다"); 
		}	
		return "addMember"; //addMember.html페이지 보여줌  		
	}
	
	//회원가입-아이디 중복체크 
	@PostMapping("/checkMemberId")
	public String checkMemberId(Model model, @RequestParam("checkMemberId")String checkMemberId ) {
		System.out.println(checkMemberId+ "<---checkMemberId잘 받아왔는지 확인");
		//서비스 호출 
		String memberId = memberService.selectMemberId(checkMemberId);
		
		//멤버 아이디가 빈값이면 사용 가능함 
		if(memberId == null) {
			System.out.println("아이디를 사용할 수 있습니다");
			model.addAttribute("checkMemberId",checkMemberId); 
		}else {
			System.out.println("아이디를 사용할 수 없습니다");
			model.addAttribute("msg1","사용중인 아이디입니다"); 
		}	
		return "addMember"; //addMember.html페이지 보여줌  		
	}
	
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
