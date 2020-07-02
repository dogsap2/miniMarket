package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.Member;
import com.cafe24.dk4750.miniMarket.vo.MemberPic;


@Mapper
public interface MemberMapper {	
		
	
	//고유번호 가져오기(카운트후  m+1)
	public String selectMemberUniqueNo();
	
	//멤버사진 수정
	public int updateMemberPic(MemberPic memberPic);
			
	//나의 정보보기 
	public Member selectMemberOne(LoginMember memberId); 
	
	//나의 정보수정
	public Member updateMemberOne(Member member);
	
	//회원 탈퇴 
	public int deleteMember(Member member);
		//아이디 이메일 백업하기 고유번호 
		
	//아이디 찾기  
	public String selectFindMemberId(Member member); 
	
	//비번찾기
	public String selectFindMemberPw(Member member); 
	
	//로그인하기 아이디 비번 일치하는지 확인 
	public LoginMember selectLoginMember(LoginMember loginMember);   
	
	//핸드폰 중복확인 
	public String selectMemberPhone(String checkMemberPhone); 
	
	//이메일 중복확인 
	public String selectMemberEmail(String checkMemberEmail); 
	
	//멤버 아이디 중복확인
	public String selectMemberId(String checkMemberId); 
		
	//회원가입시 멤버 사진 디폴트값 추가 
	public int insertMemberPic(String memberId);	
	
	//멤머 정보 입력, 회원가입  
	public int insertMember(Member member);
}
