package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.CompanyItem;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemAndCompanyAndCompanyItemPic;

@Mapper
public interface CompanyItemMapper {
	
	// 업체 아이템 추가(한번만 가능)
	public int insertCompanyItem(CompanyItem companyItem);
	
	// 한 업체 아이템 정보 출력하기
	public CompanyItem selectCompanyItemOne(CompanyItem companyItem);
	
	// 업체 아이템 수정 액션
	public int updateCompanyItem(CompanyItem companyItem);
	
	// 홍보중인  업체 리스트
	public List<CompanyItemAndCompanyAndCompanyItemPic> selectCompanyItemList(Map<String, Object> map);
	
	// 카테고리별 홍보중인  업체 리스트 
	public List<CompanyItemAndCompanyAndCompanyItemPic> selectCompanyItemListByCategory(Map<String, Object> map);
	
	// 내가 좋아요 한 업체 아이템 리스트 출력
	public List<CompanyItemAndCompanyAndCompanyItemPic> selectMyLikeCompanyItem(Map<String, Object> map);
	
	// 업체 아이템 삭제(비활성화)
	public int disabledCompanyItem(CompanyItem companyItem);
}
