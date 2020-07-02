package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Category;

@Mapper
public interface CategoryMapper {
	
	// 카테고리 추가
	public int insertCategory(Category category); 

	// 카테고리 삭제
	public int deleteCategory(String categroyName);
	
	// 멤버 카테고리 리스트 출력
	public List<Category> selectCategoryListByMember(Category category);
	
	// 업체 카테고리 리스트 출력
	public List<Category> selectCategoryListByCompany(Category category);
}