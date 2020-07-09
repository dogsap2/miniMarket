package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.Member;
import com.cafe24.dk4750.miniMarket.vo.MemberNickAndPic2;

@Mapper
public interface MemberMapper {	
		
	//고유번호 가져오기(카운트후  m+1)
	public String selectMemberUniqueNo();
	
	//멤버닉네임 수정
	public int updateMemberNickname(MemberNickAndPic2 memberNickAndPic2);
	
	//멤버사진 수정
	public int updateMemberPic(MemberNickAndPic2 memberNickAndPic2);
	
	//나의 사진보기
	public String selectMemberPic (LoginMember memberId); 
	
	//나의 닉네임 보기
	public String selectMemberNick (LoginMember memberId);
	
	//나의 정보보기 
	public Member selectMemberOne(LoginMember memberId); 
	
	//나의 정보수정(이름,전화번호,주소(동네))
	public int updateMemberOne(Member member);
	
	//회원 탈퇴(회원탈퇴하면 멤버 정보 업데이트됨)
	public int deleteMember(LoginMember loginMember);
		
	//회원 탈퇴시 비밀번호 확인
	public String selectMemberPw(LoginMember loginMember);
	
	//회원탈퇴시 백업 
	public int insertMemberBackUp(LoginMember loginMember);
	
	//회원탈퇴시 멤버 프로필 사진 삭제 
	public int deleteMemberPic(LoginMember loginMember);
	
	//회원탈퇴시 멤버 temptotal 삭제
	public int deleteMemberTempTotal(LoginMember loginMember);

	//회원탈퇴시 멤버 temp삭제
	public int deleteMemberTemp(LoginMember loginMember);
		
	//아이디 찾기  
	public String selectFindMemberId(Member member); 
	
	//비번찾기
	public int updateMemberFindPw(Member member); 
	
	//비밀번호 변경하기(새 비밀번호 입력)
	public int updateMemberPw(LoginMember loginMember);
	
	//비밀번호변경(현재 입력된 비밀번호 값 비교)
	public String selectMemberPwId(LoginMember checkIdPw);
	
	//회원가입시 온도 넣기 
	public int insertMemberTemp(String memberUniqueNo);
	
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
