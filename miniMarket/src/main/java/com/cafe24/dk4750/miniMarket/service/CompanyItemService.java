package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.dk4750.miniMarket.mapper.CompanyItemMapper;
import com.cafe24.dk4750.miniMarket.mapper.CompanyItemPicMapper;
import com.cafe24.dk4750.miniMarket.vo.CompanyItem;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemAndCompanyAndCompanyItemPic;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemForm;

@Service
@Transactional
public class CompanyItemService {
	@Autowired private CompanyItemMapper companyItemMapper;
	@Autowired private CompanyItemPicMapper companyItemMapperPicMapper;
	@Value("D:\\spring_work\\maven.1593421934386\\miniMarket\\src\\main\\resources\\static\\images\\")
	private String path;
	
	// 홍보중인 업체 아이템 리스트 출력
	public List<CompanyItemAndCompanyAndCompanyItemPic> getCompanyItemList() {
		// beginRow, rowPerPage, bname, sigungu 등 입력할 데이터 담아서 보내주기.
		int beginRow = 0;
		int rowPerPage = 10;
		String companyBname = "company";
		String companySigungu = "company";
		String searchWord = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("companyBname", companyBname);
		map.put("companySigungu", companySigungu);
		map.put("searchWord", searchWord);
		
		// 리스트 받아오기
		List<CompanyItemAndCompanyAndCompanyItemPic> list = companyItemMapper.selectCompanyItemList(map);
		
		// 리스트 리턴
		return list;
	}
	
	// 업체 아이템 추가
	public void addCompanyItem(CompanyItemForm companyItemForm) {
		System.out.println(companyItemForm + "<===업체 아이템 서비스 / companyItemForm 디버깅");
		// 이미지 파일 저장
		MultipartFile multif1 = companyItemForm.getCompanyItemPic1();
		MultipartFile multif2 = companyItemForm.getCompanyItemPic2();
		MultipartFile multif3 = companyItemForm.getCompanyItemPic3();
		MultipartFile multif4 = companyItemForm.getCompanyItemPic4();
		MultipartFile multif5 = companyItemForm.getCompanyItemPic5();
		
		String originName1 = multif1.getOriginalFilename();
		String originName2 = multif2.getOriginalFilename();
		String originName3 = multif3.getOriginalFilename();
		String originName4 = multif4.getOriginalFilename();
		String originName5 = multif5.getOriginalFilename();
		
		String memberItemPic1 = null;
		String memberItemPic2 = null;
		String memberItemPic3 = null;
		String memberItemPic4 = null;
		String memberItemPic5 = null;
		
		
	}
	
	// 업체 아이템 삭제(비활성화)
	public int disabledCompanyItem(CompanyItem companyItem) {
		System.out.println(companyItem + "<== 업체 아이템 서비스 / 업체 아이템 삭제 /업체 아이템 디버깅");
		return companyItemMapper.disabledCompanyItem(companyItem);
	}
}
