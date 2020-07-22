package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.CompanyComment;
import com.cafe24.dk4750.miniMarket.vo.CompanyCommentAndMember;

@Mapper
public interface CompanyCommentMapper {
	// 댓글 입력
	public int insertCompanyComment(CompanyComment companyComment);
	// 댓글 페이지
	public int getTotalRow(int companyItemNo);
	// 댓글 리스트(페이징)
	public List<CompanyCommentAndMember> selectCompanyCommentList(Map<String, Object> map);
}
