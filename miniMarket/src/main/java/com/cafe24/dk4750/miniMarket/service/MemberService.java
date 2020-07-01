package com.cafe24.dk4750.miniMarket.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.MemberMapper;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.Member;
import com.cafe24.dk4750.miniMarket.vo.MemberPic;


@Service
@Transactional
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	
	
	//멤버사진과 닉네임 수정 
	public int updateMemberPic(MemberPic memberPic) {		
		// 닉네임만 수정하는 메퍼
		// 사진수정 매퍼  
		return 0;
	}	
	
	//로그인하기 아이디 비번 일치하는지 확인 
	public LoginMember selectLoginMember(LoginMember loginMember) {
		return loginMember;		
	}
	
	//나의 정보보기 
	public Member selectMemberOne(LoginMember loginMember) {
		return null;		
	}
	
	//나의 정보 수정 
	public Member modifyMemberOne(Member member) {		
		// 나의 정보수정 메퍼 
		return member;		
	}
	
	//회원 탈퇴 
	public int deleteMember(Member member) {
		return 0;		
	}
		//아이디 이메일 백업하기 고유번호 
		
	//아이디 찾기  
	public String selectFindMemberId(Member member) {
		return null;		
	}
	
	//비번찾기
	public String selectFindMemberPw(Member member) {
		return null;		
	}
	
	//멤머 정보 입력, 회원가입  
	public int insertMember(Member member) {
		return 0;		
	}
	
	//멤버 아이디 중복확인
	public String selectMemberId(String checkMemberId) {
		return memberMapper.selectMemberId(checkMemberId);		
	}
			
	//핸드폰 중복확인 
	public String selectMemberPhone(String checkMemberPhone){
		return memberMapper.selectMemberPhone(checkMemberPhone);		
	}
		
	//이메일 중복확인 
	public String selectMemberEmail(String checkMemberEmail) {
		return memberMapper.selectMemberEmail(checkMemberEmail);
			
	}
	
	//멤머 정보 입력, 회원가입  
	public int addMember(Member member) {
		//사진추가 매퍼 
		// 유니크 넘버 만들어 줘야됨 	
		memberMapper.insertMemberPic(member);		
		int row = memberMapper.insertMember(member);
		return row;		
	}
}
