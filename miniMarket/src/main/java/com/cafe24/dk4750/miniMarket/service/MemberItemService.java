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

import com.cafe24.dk4750.miniMarket.mapper.MemberItemMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberItemPicMapper;
import com.cafe24.dk4750.miniMarket.vo.MemberItem;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMember;
import com.cafe24.dk4750.miniMarket.vo.MemberItemForm;
import com.cafe24.dk4750.miniMarket.vo.MemberItemPic;

@Service
@Transactional
public class MemberItemService {
	@Autowired private MemberItemMapper memberItemMapper;
	@Autowired private MemberItemPicMapper memberItemPicMapper;
	@Value("D:\\spring_work\\maven.1593421934386\\miniMarket\\src\\main\\resources\\static\\images\\")
	private String path;
	
	// 멤버 아이템 추가
	public void addMemberItem(MemberItemForm memberItemForm) {
		System.out.println(memberItemForm + " <== 멤버 서비스 / memberItemForm 디버깅");
		System.out.println(path + " <== 이미지 파일 저장경로");
		
		// 이미지 파일 저장
		MultipartFile multif1 = memberItemForm.getMemberItemPic1();
		MultipartFile multif2 = memberItemForm.getMemberItemPic2();
		MultipartFile multif3 = memberItemForm.getMemberItemPic3();
		MultipartFile multif4 = memberItemForm.getMemberItemPic4();
		MultipartFile multif5 = memberItemForm.getMemberItemPic5();
		
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
		
		// 사진이 널일시.
		if(originName1.equals("")) {
			memberItemPic1 = "default.jpg";
		} else {
			int lastDot = originName1.lastIndexOf(".");
			System.out.println(lastDot + " <== 마지막 .의 위치... 확장자 앞까지만 나오게하기 위해");
			String extension = originName1.substring(lastDot);
			memberItemPic1 = "1"+extension;
		}
		
		if(originName2.equals("")) {
			memberItemPic2 = "default.jpg";
		} else {
			int lastDot = originName2.lastIndexOf(".");
			System.out.println(lastDot + " <== 마지막 .의 위치... 확장자 앞까지만 나오게하기 위해");
			String extension = originName2.substring(lastDot);
			memberItemPic2 = "2"+extension;
		}
		
		if(originName3.equals("")) {
			memberItemPic3 = "default.jpg";
		} else {
			int lastDot = originName3.lastIndexOf(".");
			System.out.println(lastDot + " <== 마지막 .의 위치... 확장자 앞까지만 나오게하기 위해");
			String extension = originName3.substring(lastDot);
			memberItemPic3 = "3"+extension;
		}
		
		if(originName4.equals("")) {
			memberItemPic4 = "default.jpg";
		} else {
			int lastDot = originName4.lastIndexOf(".");
			System.out.println(lastDot + " <== 마지막 .의 위치... 확장자 앞까지만 나오게하기 위해");
			String extension = originName4.substring(lastDot);
			memberItemPic4 = "4"+extension;
		}
		
		if(originName5.equals("")) {
			memberItemPic5 = "default.jpg";
		} else {
			int lastDot = originName5.lastIndexOf(".");
			System.out.println(lastDot + " <== 마지막 .의 위치... 확장자 앞까지만 나오게하기 위해");
			String extension = originName5.substring(lastDot);
			memberItemPic5 = "5"+extension;
		}
		
		// 사진이 널이 아닐시.
		if(!originName1.equals("")) {
			File file = new File(path+memberItemPic1);
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
			File file = new File(path+memberItemPic2);
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
			File file = new File(path+memberItemPic3);
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
			File file = new File(path+memberItemPic4);
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
			File file = new File(path+memberItemPic5);
			try {
				multif5.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 이름 변경된 값 디버깅
		System.out.println(memberItemPic1 + " <== memberItemPic1");
		System.out.println(memberItemPic2 + " <== memberItemPic2");
		System.out.println(memberItemPic3 + " <== memberItemPic3");
		System.out.println(memberItemPic4 + " <== memberItemPic4");
		System.out.println(memberItemPic5 + " <== memberItemPic5");
		
		// 멤버아이템 폼에서 멤버아이템 속성 꺼내서 담아주기
		MemberItem memberItem = new MemberItem();
		memberItem.setMemberUniqueNo(memberItemForm.getMemberUniqueNo());
		memberItem.setMemberItemTitle(memberItemForm.getMemberItemTitle());
		memberItem.setCategoryName(memberItemForm.getCategoryName());
		memberItem.setMemberItemPrice(memberItemForm.getMemberItemPrice());
		memberItem.setMemberItemContent(memberItemForm.getMemberItemContent());
		System.out.println(memberItem + " <== 멤버 아이템 서비스/멤버 아이템 추가/멤버 아이템 디버깅");
		
		MemberItemPic memberItemPic = new MemberItemPic();
		int memberItemNo = 1;
		memberItemPic.setMemberItemNo(memberItemNo);
		memberItemPic.setMemberItemPic1(memberItemPic1);
		memberItemPic.setMemberItemPic2(memberItemPic2);
		memberItemPic.setMemberItemPic3(memberItemPic3);
		memberItemPic.setMemberItemPic4(memberItemPic4);
		memberItemPic.setMemberItemPic5(memberItemPic5);
		memberItemMapper.insertMemberItem(memberItem);
		memberItemPicMapper.insertMemberItemPic(memberItemPic);
	}
	
	// 한개의 멤버 아이템 정보 가져오기
	public MemberItem getMemberItemOne(int memberItemNo) {
		System.out.println(memberItemNo + " <== 멤버 아이템 서비스/한개의 멤버 아이템 정보 가져오기/멤버 아이템 넘버 디버깅");
		// 리턴
		return memberItemMapper.selectMemberItemOne(memberItemNo);
	}
	
	// 멤버 아이템 수정
	public int modifyMemberItem(MemberItem memberItem) {
		System.out.println(memberItem + " <== 멤버 아이템 서비스/멤버 아이템 수정/멤버 아이템 디버깅");
		
		// 리턴
		return memberItemMapper.updateMemberItem(memberItem);
	}
	
	// 판매중인 동네 아이템 리스트 출력
	public List<MemberItemAndMember> getMemberItemList() {
		// beginRow, rowPerPage, bname, sigungu 등 입력할 데이터 담아서 보내주기.
		int beginRow = 0;
		int rowPerPage = 10;
		String memberBname = "test1";
		String memberSigungu = "test1";
		String searchWord = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("memberBname", memberBname);
		map.put("memberSigungu", memberSigungu);
		map.put("searchWord", searchWord);
		
		// 리스트 받아오기
		List<MemberItemAndMember> list = memberItemMapper.selectItemList(map);
		
		// 리스트 리턴
		return list;
	}
	
	// 아이템 삭제(비활성화)
	public int disabledMemberItem(MemberItem memberItem) {
		System.out.println(memberItem + " <== 멤버 아이템 서비스/멤버 아이템 삭제/멤버 아이템 디버깅");
		
		return memberItemMapper.disabledMemberItem(memberItem);
	}
}
