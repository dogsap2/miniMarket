package com.cafe24.dk4750.miniMarket.service;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	@Autowired private JavaMailSender javaMailSender;//@Conponent
	
	
	//멤버사진과 닉네임 수정 
	public int updateMemberPic(MemberPic memberPic) {		
		// 닉네임만 수정하는 메퍼
		// 사진수정 매퍼  
		return 0;
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
	
	//회원 정보 입력, 회원가입  
	public int insertMember(Member member) {
		return 0;		
	}
	
	//회원 비밀번호 수정 
	public int updateMemberPw(LoginMember loginMember) {
		int row = memberMapper.updateMemberPw(loginMember);
		return row;
	}
	
	//로그인하기 아이디 비번 일치하는지 확인 
	public LoginMember selectLoginMember(LoginMember loginMember) {
		return memberMapper.selectLoginMember(loginMember);		
	}
	
	//나의 정보보기 
	public Member selectMemberOne(LoginMember memberId) {
		return memberMapper.selectMemberOne(memberId);		
	}
	
	//나의 정보 수정(이름,전화번호,주소(동네))
	public int modifyMemberOne(Member member) {		
		return memberMapper.updateMemberOne(member);		
	}
	
	//멤머 정보 입력, 회원가입  
	public int addMember(Member member) {
		//랜덤 비번 만들기 
		UUID uuid = UUID.randomUUID();
		String memberPw= uuid.toString().substring(0,4);//0번째부터 4번쨰까지 
		member.setMemberPw(memberPw);
		System.out.println(memberPw +"<--랜덤memberPw  확인");
		System.out.println(member.getMemberPw()+"<-랜덤 비번getMemberPw 잘 들어갔나 확인");
		// 유니크 넘버 만들어 줘야됨 	
		String memberUniqueNo = memberMapper.selectMemberUniqueNo();
		System.out.println(memberUniqueNo+"<--유니크넘버임");
		member.setMemberUniqueNo(memberUniqueNo);
		
		int row = memberMapper.insertMember(member);
	
		if(row==1) {
			//회원가입 완료되면 사진 넣기 
			memberMapper.insertMemberPic(member.getMemberId());				
			System.out.println(memberPw+"<--임시 비밀번호 들어갔는지 확인 memberPw");
			
			//회원가입 완료되면 생성된 임시 비번 메일로 보내주기 
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(member.getMemberEmail()); // 누구에게 보내는지 
			simpleMailMessage.setFrom("hya7835@gmail.com"); // 누가 보내는지
			simpleMailMessage.setSubject("Minimarket 임시 비밀번호 메일");//내용
			simpleMailMessage.setText("지정된 임시 비밀번호:"+ memberPw+"입니다" +"로그인 후 비밀번호를 변경해주세요");
			javaMailSender.send(simpleMailMessage);
		}
		return row;		
	}
}
