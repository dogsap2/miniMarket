package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.Member;
import com.cafe24.dk4750.miniMarket.vo.MemberPic;


@Mapper
public interface MemberMapper {	
		
	//멤버사진 수정
	public int updateMemberPic(MemberPic memberPic);
			
	//멤버 아이디 중복확인
	public String selectMemberId(String MemberId); 
		
	//핸드폰 중복확인 
	public String selectMemberPhone(String memberPhone); 
	
	//이메일 중복확인 
	public String selectMemberEmail(String memberEmail); 
	
	//로그인하기 아이디 비번 일치하는지 확인 
	public LoginMember selectLoginMember(LoginMember loginMember);   
	
	//나의 정보보기 
	public Member selectMemberOne(LoginMember loginMember); 
	
	//나의 정보수정
	public Member updateMemberOner(Member member);
	
	//회원 탈퇴 
	public int deleteMember(Member member);
		//아이디 이메일 백업하기 고유번호 
		
	//아이디 찾기  
	public String selectFindMemberId(Member member); 
	
	//비번찾기
	public String selectFindMemberPw(Member member); 
	
	//회원가입시 멤버 사진 디폴트값 추가 
	public int insertMemberPic(Member member);
		
	//멤머 정보 입력, 회원가입  
	public int insertMember(Member member);
}
