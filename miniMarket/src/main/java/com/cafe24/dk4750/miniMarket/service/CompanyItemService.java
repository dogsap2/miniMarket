package com.cafe24.dk4750.miniMarket.service;

import java.io.File;
import java.io.IOException;
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
import com.cafe24.dk4750.miniMarket.vo.CompanyItemPic;

@Service
@Transactional
public class CompanyItemService {
	@Autowired private CompanyItemMapper companyItemMapper;
	@Autowired private CompanyItemPicMapper companyItemPicMapper;
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
		System.out.println(path + "<-- 이미지 파일 저장경로");
		
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
		
		String companyItemPic1 = null;
		String companyItemPic2 = null;
		String companyItemPic3 = null;
		String companyItemPic4 = null;
		String companyItemPic5 = null;
		
		//사진이 널일시.
		if(originName1.equals("")) {
			companyItemPic1 = "default.jpg";
		} else {
			int lastDot = originName1.lastIndexOf(".");
			System.out.println(lastDot + "<== 마지막 .의 위치... 확장자 앞까지만 나오게 하기 위해");
			String extension = originName1.substring(lastDot);
			companyItemPic1 = "comPic1"+extension;
		}
		//사진이 널일시.
		if(originName2.equals("")) {
			companyItemPic2 = "default.jpg";
		} else {
			int lastDot = originName2.lastIndexOf(".");
			System.out.println(lastDot + "<== 마지막 .의 위치... 확장자 앞까지만 나오게 하기 위해");
			String extension = originName2.substring(lastDot);
			companyItemPic2 = "comPic2"+extension;
		}
		//사진이 널일시.
		if(originName3.equals("")) {
			companyItemPic3 = "default.jpg";
		} else {
			int lastDot = originName3.lastIndexOf(".");
			System.out.println(lastDot + "<== 마지막 .의 위치... 확장자 앞까지만 나오게 하기 위해");
			String extension = originName3.substring(lastDot);
			companyItemPic3 = "comPic3"+extension;
		}
		//사진이 널일시.
		if(originName4.equals("")) {
			companyItemPic4 = "default.jpg";
		} else {
			int lastDot = originName4.lastIndexOf(".");
			System.out.println(lastDot + "<== 마지막 .의 위치... 확장자 앞까지만 나오게 하기 위해");
			String extension = originName4.substring(lastDot);
			companyItemPic4 = "comPic4"+extension;
		}
		//사진이 널일시.
		if(originName5.equals("")) {
			companyItemPic5 = "default.jpg";
		} else {
			int lastDot = originName5.lastIndexOf(".");
			System.out.println(lastDot + "<== 마지막 .의 위치... 확장자 앞까지만 나오게 하기 위해");
			String extension = originName5.substring(lastDot);
			companyItemPic5 = "comPic1"+extension;
		}
		
		// 사진이 널이 아닐시.
		if(!originName1.equals("")) {
			File file = new File(path+companyItemPic1);
			try {
				multif1.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 사진이 널이 아닐시.
		if(!originName2.equals("")) {
			File file = new File(path+companyItemPic2);
			try {
				multif2.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 사진이 널이 아닐시.
		if(!originName3.equals("")) {
			File file = new File(path+companyItemPic3);
			try {
				multif3.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 사진이 널이 아닐시.
		if(!originName4.equals("")) {
			File file = new File(path+companyItemPic4);
			try {
				multif4.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 사진이 널이 아닐시.
		if(!originName5.equals("")) {
			File file = new File(path+companyItemPic5);
			try {
				multif5.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 이름 변경된 값 디버깅
		System.out.println(companyItemPic1 + "<==companyItemPic1");
		System.out.println(companyItemPic2 + "<==companyItemPic2");
		System.out.println(companyItemPic3 + "<==companyItemPic3");
		System.out.println(companyItemPic4 + "<==companyItemPic4");
		System.out.println(companyItemPic5 + "<==companyItemPic5");
		
		// 지정해줄 companyItemNo 셀렉트로 구해오기
		int companyItemNo = companyItemMapper.selectMaxPlusCompanyItemNo();
		
		// 업체아이템 폼에서 업체아이템 속성 꺼내서 담아주기
		CompanyItem companyItem = new CompanyItem();
		companyItem.setCompanyItemNo(companyItemNo);
		companyItem.setCompanyUniqueNo(companyItemForm.getCompanyUniqueNo());
		companyItem.setCompanyItemTitle(companyItemForm.getCompanyItemTitle());
		companyItem.setCategoryName(companyItemForm.getCategoryName());
		companyItem.setCompanyPhone(companyItemForm.getCompanyPhone());
		companyItem.setCompanyItemPrice(companyItemForm.getCompanyItemPrice());
		companyItem.setCompanyItemContent(companyItemForm.getCompanyItemContent());
		System.out.println(companyItem + "<== 업체 아이템 서비스 / 업체 아이템 추가 / 업체 아이템 디버깅");
	
		// 아이템 넘버를 받아와서 아이템 등록하기
		companyItemMapper.insertCompanyItem(companyItem);
		
		// 사진추가하기
		CompanyItemPic companyItemPic = new CompanyItemPic();
		companyItemPic.setCompanyItemNo(companyItemNo);
		companyItemPic.setCompanyItemPic1(companyItemPic1);
		companyItemPic.setCompanyItemPic2(companyItemPic2);
		companyItemPic.setCompanyItemPic3(companyItemPic3);
		companyItemPic.setCompanyItemPic4(companyItemPic4);
		companyItemPic.setCompanyItemPic5(companyItemPic5);
		// 받아온 아이템 넘버에 해당하는 아이템 사진 등록하기
		companyItemPicMapper.insertCompanyItemPic(companyItemPic);
		
	}
	
	// 한개의 업체 아이템 정보 가져오기
//	public Map<String, Object> getCompanyItemOne(int companyItemNo) {
//	System.out.println(companyItemNo +
//	"<== 업체 아이템 서비스 / 한개의 업체 아이템 정보 가져오기 / 업체 아이템 넘버 디버깅");
//	  
//	// 리턴타입 map 생성 HashMap<String, Object> map = new HashMap<String,Object>();
//	  
//	// map에 담을 정보들
//	  
//	}
	
	// 업체 아이템 삭제(비활성화)
	public int disabledCompanyItem(CompanyItem companyItem) {
		System.out.println(companyItem + "<== 업체 아이템 서비스 / 업체 아이템 삭제 /업체 아이템 디버깅");
		return companyItemMapper.disabledCompanyItem(companyItem);
	}
}
