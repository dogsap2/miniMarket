package com.cafe24.dk4750.miniMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.MannerMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberTempMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberTempTotalMapper;
import com.cafe24.dk4750.miniMarket.vo.Manner;
import com.cafe24.dk4750.miniMarket.vo.MemberTemp;

@Service
@Transactional
public class MannerService {
	@Autowired private MannerMapper mannerMapper;
	@Autowired private MemberTempMapper memberTempMapper;
	@Autowired private MemberTempTotalMapper memberTempTotalMapper;
	
	// good 매너 평가하기
	public int addGoodManner(Manner manner) {
		// 매너평가하기
		mannerMapper.insertGoodManner(manner);
		
		// 매너평가 결과 템프에 insert하기.. manner에서 값 꺼내서 담아주기
		MemberTemp memberTemp = new MemberTemp();
		memberTemp.setMemberUniqueNo(manner.getMemberUniqueNo());
		if(manner.getBadManner() == 0) {
			memberTemp.setTempInsertScore(manner.getGoodManner());
		} else {
			memberTemp.setTempInsertScore(manner.getBadManner());
		}
		memberTempMapper.insertTemp(memberTemp);
		
		// 매너평가 insert된 스코어를 total에 인서트하기
		
		return 0;
	}
	
	// bad 매너 평가하기
	public int addBadManner(Manner manner) {
		
		mannerMapper.insertBadManner(manner);
		
		return 0;
	}
}
