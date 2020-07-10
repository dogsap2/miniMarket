package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.QnaBoardCompany;

@Mapper
public interface QnaBoardCompanyMapper {
	// 총 페이지 (lastPage)
	public int getTotalRow();
	// QnA리스트 출력 (페이징)
	public List<QnaBoardCompany> selectCompanyBoardQnAList(Map<String, Object> map);
}
