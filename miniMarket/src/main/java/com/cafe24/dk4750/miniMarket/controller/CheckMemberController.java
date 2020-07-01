package com.cafe24.dk4750.miniMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.mapper.MemberMapper;

@RestController
public class CheckMemberController {
	@Autowired
	private MemberMapper mamberMapper;
	
	//아이디 중복 체크 
	@GetMapping("/checkId")
	public String checkMemberId (@RequestParam(value="checkMemberId") String checkMemberId) {
		System.out.println(checkMemberId+"<-checkMemberId");
		String resultId="사용불가";
		
		if(mamberMapper.selectMemberId(checkMemberId)==null) {
		  resultId="사용가능";	
		}
				
		return resultId;		
	}
	
	//전화번호 중복 체크 
	@GetMapping("/checkPhone")
	public String checkMemberPhone (@RequestParam(value="checkMemberPhone") String checkMemberPhone) {
		System.out.println(checkMemberPhone+"<-checkMemberPhone");
		String resultPhone="사용불가";
		
		if(mamberMapper.selectMemberPhone(checkMemberPhone)==null) {
			resultPhone="사용가능";	
		}				
		return resultPhone;		
	}
	
	//이메일 중복 체크 
	@GetMapping("/checkEmail")
	public String checkMemberEmail (@RequestParam(value="checkMemberEmail") String checkMemberEmail) {
		System.out.println(checkMemberEmail+"<-checkMemberEmail");
		String resultEmail="사용불가";
		
		if(mamberMapper.selectMemberEmail(checkMemberEmail)==null) {
			resultEmail="사용가능";	
		}				
		return resultEmail;		
	}
	
	
}
