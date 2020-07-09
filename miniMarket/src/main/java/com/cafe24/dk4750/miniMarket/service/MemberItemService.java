package com.cafe24.dk4750.miniMarket.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.dk4750.miniMarket.mapper.ChatroomMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberItemMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberItemPicMapper;
import com.cafe24.dk4750.miniMarket.mapper.SoldoutMapper;
import com.cafe24.dk4750.miniMarket.vo.Chatroom;
import com.cafe24.dk4750.miniMarket.vo.ItemSoldout;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.MemberItem;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.MemberItemForm;
import com.cafe24.dk4750.miniMarket.vo.MemberItemPic;

@Service
@Transactional
public class MemberItemService {
	@Autowired private MemberItemMapper memberItemMapper;
	@Autowired private MemberItemPicMapper memberItemPicMapper;
	@Autowired private SoldoutMapper soldoutMapper;
	@Autowired private ChatroomMapper chatroomMapper;
	@Value("D:\\spring_work\\maven.1593421934386\\miniMarket\\src\\main\\resources\\static\\images\\")
	private String path;
	
	
	// 구매자의 구매완료 리스트
	public List<ItemSoldout> getBuyListByMember(HttpSession session) {
		
		// 세션에서 받아온 유니크넘버
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		
		int beginRow = 0;
		int rowPerPage = 10;
		String searchWord = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("memberUniqueNo", memberUniqueNo);
		
		// 구매자의 구매완료 리스트
		List<ItemSoldout> list = soldoutMapper.selectBuyListByMember(map);
		
		return list;
	}
	
	// 나의 판매완료 목록 리스트
	public List<MemberItemAndMemberAndMemberItemPic> getItemListBySaleMyItem(HttpSession session) {
		
		// 임시로 설정한 유니크넘버 번호
		int beginRow = 0;
		int rowPerPage = 10;
		String searchWord = "";
		// 세션에서 유니크넘버꺼내주기
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberUniqueNo", memberUniqueNo);
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		
		// 리스트 불러오기
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemMapper.selectItemListBySaleMyItem(map);
		
		return list;
	}
	
	// 판매자의 판매중인 아이템 판매완료로 수정
	public int itemSalesComplete(int memberItemNo , String memberUniqueNo) {
		
		System.out.println(memberItemNo + "sevice itemno");
		System.out.println(memberUniqueNo + "sevice memberUniqueNo");
        MemberItem memberItem = new MemberItem();
        // 판매자의 판매중인 아이템 판매완료로 수정
        String memberItemState = "판매완료";
        memberItem.setMemberItemState(memberItemState);
        memberItem.setMemberItemNo(memberItemNo);
        // 판매자의 판매중인 아이템 판매완료로 수정
        memberItemMapper.itemSalesComplete(memberItem);
      
        Chatroom chatroom = new Chatroom();
        chatroom.setMemberItemNo(memberItemNo);
        //채팅방 비활성화
        chatroomMapper.updateSoldOutItem(memberItemNo);
      
        // 판매자가 누구한테 어떤 아이템을 팔았는지 정보 입력
        ItemSoldout itemSoldout = new ItemSoldout();
        itemSoldout.setMemberItemNo(memberItemNo);
        itemSoldout.setMemberUniqueNo(memberUniqueNo);
      
        // 판매자가 판매중인 아이템을 누구에게 팔았는지 판매완료 테이블에 추가
        return soldoutMapper.insertSoldoutItem(itemSoldout);
	    }
		
	
	// 나의 판매중인 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPic> getItemListMyItem(HttpSession session) {
		
		int beginRow = 0;
		int rowPerPage = 10;
		String searchWord = "";
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberUniqueNo", memberUniqueNo);
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemMapper.selectItemListMyItem(map);
		
		return list;
	}
	
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
			// 랜덤 사진 이름 생성
			UUID uuid = UUID.randomUUID();
			String pic1Name = uuid.toString().substring(0, 6);
			memberItemPic1 = pic1Name+"1"+extension;
		}
		
		if(originName2.equals("")) {
			memberItemPic2 = "default.jpg";
		} else {
			int lastDot = originName2.lastIndexOf(".");
			System.out.println(lastDot + " <== 마지막 .의 위치... 확장자 앞까지만 나오게하기 위해");
			String extension = originName2.substring(lastDot);
			// 랜덤 사진 이름 생성
			UUID uuid = UUID.randomUUID();
			String pic2Name = uuid.toString().substring(0, 6);
			memberItemPic2 = pic2Name+"2"+extension;
		}
		
		if(originName3.equals("")) {
			memberItemPic3 = "default.jpg";
		} else {
			int lastDot = originName3.lastIndexOf(".");
			System.out.println(lastDot + " <== 마지막 .의 위치... 확장자 앞까지만 나오게하기 위해");
			String extension = originName3.substring(lastDot);
			// 랜덤 사진 이름 생성
			UUID uuid = UUID.randomUUID();
			String pic3Name = uuid.toString().substring(0, 6);
			memberItemPic3 = pic3Name+"3"+extension;
		}
		
		if(originName4.equals("")) {
			memberItemPic4 = "default.jpg";
		} else {
			int lastDot = originName4.lastIndexOf(".");
			System.out.println(lastDot + " <== 마지막 .의 위치... 확장자 앞까지만 나오게하기 위해");
			String extension = originName4.substring(lastDot);
			// 랜덤 사진 이름 생성
			UUID uuid = UUID.randomUUID();
			String pic4Name = uuid.toString().substring(0, 6);
			memberItemPic4 = pic4Name+"4"+extension;
		}
		
		if(originName5.equals("")) {
			memberItemPic5 = "default.jpg";
		} else {
			int lastDot = originName5.lastIndexOf(".");
			System.out.println(lastDot + " <== 마지막 .의 위치... 확장자 앞까지만 나오게하기 위해");
			String extension = originName5.substring(lastDot);
			// 랜덤 사진 이름 생성
			UUID uuid = UUID.randomUUID();
			String pic5Name = uuid.toString().substring(0, 6);
			memberItemPic5 = pic5Name+"5"+extension;
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
		
		// 지정해줄 memberItemNo 셀렉트로 구해오기
		int memberItemNo = memberItemMapper.selectMaxPlusMemberItemNo();
		System.out.println(memberItemNo + " <== 새로 생성 될 멤버 아이템 넘버");
		
		// 멤버아이템 폼에서 멤버아이템 속성 꺼내서 담아주기
		MemberItem memberItem = new MemberItem();
		memberItem.setMemberItemNo(memberItemNo);
		memberItem.setMemberUniqueNo(memberItemForm.getMemberUniqueNo());
		memberItem.setMemberItemTitle(memberItemForm.getMemberItemTitle());
		memberItem.setCategoryName(memberItemForm.getCategoryName());
		memberItem.setMemberItemPrice(memberItemForm.getMemberItemPrice());
		memberItem.setMemberItemContent(memberItemForm.getMemberItemContent());
		System.out.println(memberItem + " <== 멤버 아이템 서비스/멤버 아이템 추가/멤버 아이템 디버깅");
		// 아이템 넘버를 받아와서 아이템 등록하기
		memberItemMapper.insertMemberItem(memberItem);
		
		// 사진 추가하기
		MemberItemPic memberItemPic = new MemberItemPic();
		memberItemPic.setMemberItemNo(memberItemNo);
		memberItemPic.setMemberItemPic1(memberItemPic1);
		memberItemPic.setMemberItemPic2(memberItemPic2);
		memberItemPic.setMemberItemPic3(memberItemPic3);
		memberItemPic.setMemberItemPic4(memberItemPic4);
		memberItemPic.setMemberItemPic5(memberItemPic5);
		// 받아온 아이템 넘버에 해당하는 아이템 사진 등록하기
		memberItemPicMapper.insertMemberItemPic(memberItemPic);
	}
	
	// 한개의 멤버 아이템 정보 가져오기
	public Map<String, Object> getMemberItemOne(int memberItemNo) {
		System.out.println(memberItemNo + " <== 멤버 아이템 서비스/한개의 멤버 아이템 정보 가져오기/멤버 아이템 넘버 디버깅");
		
		// 리턴타입 map 생성
		HashMap<String, Object> map = new HashMap<String, Object>();
		// map에 담을 정보들
		MemberItemPic memberItemPic = memberItemPicMapper.selectMemberItemPicName(memberItemNo);
		MemberItem memberItem = memberItemMapper.selectMemberItemOne(memberItemNo);
		// map에 담아주기
		map.put("memberItemPic", memberItemPic);
		map.put("memberItem", memberItem);
		System.out.println(memberItemPic + " <== memberItemPic");
		System.out.println(memberItemPic.getMemberItemPic1() + " <== memberItemPic1");
		System.out.println(map.get("memberItemPic") + " <== map / memberItemPic");
		System.out.println(memberItem + " <== memberItem");
		// 리턴
		return map;
	}
	
	// 멤버 아이템 수정
	public int modifyMemberItem(MemberItemForm memberItemForm) {
		System.out.println(memberItemForm + " <== 멤버 아이템 서비스/멤버 아이템 수정/멤버 아이템 디버깅");
		System.out.println(path + " <== 이미지 파일 저장경로");
		// 기존 아이템 사진 이름 가져오기
		int memberItemNo = memberItemForm.getMemberItemNo();
		MemberItemPic memberItemPicc = memberItemPicMapper.selectMemberItemPicName(memberItemNo);
		String originMemberItemPic1 = memberItemPicc.getMemberItemPic1();
		String originMemberItemPic2 = memberItemPicc.getMemberItemPic2();
		String originMemberItemPic3 = memberItemPicc.getMemberItemPic3();
		String originMemberItemPic4 = memberItemPicc.getMemberItemPic4();
		String originMemberItemPic5 = memberItemPicc.getMemberItemPic5();
		System.out.println(originMemberItemPic1);
		System.out.println(originMemberItemPic2);
		System.out.println(originMemberItemPic3);
		System.out.println(originMemberItemPic4);
		System.out.println(originMemberItemPic5);													// db에 저장되어있는 사진 이름
		
		// 폼에서 넘어온 파일
		MultipartFile mf1 = memberItemForm.getMemberItemPic1();
		MultipartFile mf2 = memberItemForm.getMemberItemPic2();
		MultipartFile mf3 = memberItemForm.getMemberItemPic3();
		MultipartFile mf4 = memberItemForm.getMemberItemPic4();
		MultipartFile mf5 = memberItemForm.getMemberItemPic5();										// 폼에서 넘어온 파일
		
		// 폼에서 넘어온 파일의 실제이름 구하기
		String originalName1 = mf1.getOriginalFilename();
		String originalName2 = mf2.getOriginalFilename();
		String originalName3 = mf3.getOriginalFilename();
		String originalName4 = mf4.getOriginalFilename();
		String originalName5 = mf5.getOriginalFilename();
		System.out.println(originalName1);
		System.out.println(originalName2);
		System.out.println(originalName3);
		System.out.println(originalName4);
		System.out.println(originalName5);															// 폼에서 넘어온 파일의 실제이름 구하기
		
		// 새로 db에 입력될 이름
		String memberItemPic1 = "";
		String memberItemPic2 = "";
		String memberItemPic3 = "";
		String memberItemPic4 = "";
		String memberItemPic5 = "";																	// 새로 db에 입력될 이름
		
		// 값이 없으면 삭제 X, 있으면 삭제 실행
		if(!originalName1.equals("")) {
			// 이미지 삭제
			File originFile = new File(path + originMemberItemPic1);
			// 초기설정 이미지 삭제 X
			if(originFile.exists() && !originMemberItemPic1.equals("default.jpg")) {
				originFile.delete();
			}
			int lastDot = originalName1.lastIndexOf(".");
			String extension = originalName1.substring(lastDot);
			memberItemPic1 = "1" + extension;
		} else {
			memberItemPic1 = originMemberItemPic1;
		}
		
		// 값이 없으면 삭제 X, 있으면 삭제 실행
		if(!originalName2.equals("")) {
			// 이미지 삭제
			File originFile = new File(path + originMemberItemPic2);
			// 초기설정 이미지 삭제 X
			if(originFile.exists() && !originMemberItemPic2.equals("default.jpg")) {
				originFile.delete();
			}
			int lastDot = originalName2.lastIndexOf(".");
			String extension = originalName2.substring(lastDot);
			memberItemPic2 = "2" + extension;
		} else {
			memberItemPic2 = originMemberItemPic2;
		}
		
		// 값이 없으면 삭제 X, 있으면 삭제 실행
		if(!originalName3.equals("")) {
			// 이미지 삭제
			File originFile = new File(path + originMemberItemPic3);
			// 초기설정 이미지 삭제 X
			if(originFile.exists() && !originMemberItemPic3.equals("default.jpg")) {
				originFile.delete();
			}
			int lastDot = originalName3.lastIndexOf(".");
			String extension = originalName3.substring(lastDot);
			memberItemPic3 = "3" + extension;
		} else {
			memberItemPic3 = originMemberItemPic3;
		}
		
		// 값이 없으면 삭제 X, 있으면 삭제 실행
		if(!originalName4.equals("")) {
			// 이미지 삭제
			File originFile = new File(path + originMemberItemPic4);
			// 초기설정 이미지 삭제 X
			if(originFile.exists() && !originMemberItemPic4.equals("default.jpg")) {
				originFile.delete();
			}
			int lastDot = originalName4.lastIndexOf(".");
			String extension = originalName4.substring(lastDot);
			memberItemPic4 = "4" + extension;
		} else {
			memberItemPic4 = originMemberItemPic4;
		}
		
		// 값이 없으면 삭제 X, 있으면 삭제 실행
		if(!originalName5.equals("")) {
			// 이미지 삭제
			File originFile = new File(path + originMemberItemPic5);
			// 초기설정 이미지 삭제 X
			if(originFile.exists() && !originMemberItemPic5.equals("default.jpg")) {
				originFile.delete();
			}
			int lastDot = originalName5.lastIndexOf(".");
			String extension = originalName5.substring(lastDot);
			memberItemPic5 = "5" + extension;
		} else {
			memberItemPic5 = originMemberItemPic5;
		}
		
		// 멤버 아이템 업데이트
		MemberItem memberItem = new MemberItem();
		memberItem.setMemberItemNo(memberItemForm.getMemberItemNo());
		memberItem.setMemberItemTitle(memberItemForm.getMemberItemTitle());
		memberItem.setMemberItemContent(memberItemForm.getMemberItemContent());
		memberItem.setMemberItemPrice(memberItemForm.getMemberItemPrice());
		memberItem.setCategoryName(memberItemForm.getCategoryName());
		System.out.println(memberItem + " <== memberItem");
		memberItemMapper.updateMemberItem(memberItem);
		
		MemberItemPic memberItemPic = new MemberItemPic();
		memberItemPic.setMemberItemNo(memberItemForm.getMemberItemNo());
		memberItemPic.setMemberItemPic1(memberItemPic1);
		memberItemPic.setMemberItemPic2(memberItemPic2);
		memberItemPic.setMemberItemPic3(memberItemPic3);
		memberItemPic.setMemberItemPic4(memberItemPic4);
		memberItemPic.setMemberItemPic5(memberItemPic5);
		memberItemPicMapper.updateMemberItemPic(memberItemPic);
		
		// 사진 저장
		if(!originalName1.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + memberItemPic1);
			// mf의 파일을 옮겨준다
			try {
				mf1.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		
		// 사진 저장
		if(!originalName2.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + memberItemPic2);
			// mf의 파일을 옮겨준다
			try {
				mf2.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		
		// 사진 저장
		if(!originalName3.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + memberItemPic3);
			// mf의 파일을 옮겨준다
			try {
				mf3.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		
		// 사진 저장
		if(!originalName4.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + memberItemPic4);
			// mf의 파일을 옮겨준다
			try {
				mf4.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		
		// 사진 저장
		if(!originalName5.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + memberItemPic5);
			// mf의 파일을 옮겨준다
			try {
				mf5.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		return 0;
	}
	
	// 판매중인 동네 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPic> getMemberItemList(HttpSession session) {
		// beginRow, rowPerPage, bname, sigungu 등 입력할 데이터 담아서 보내주기.
		int beginRow = 0;
		int rowPerPage = 10;
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberBname = loginMember.getMemberBname();
		String memberSigungu = loginMember.getMemberSigungu();
		String searchWord = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("memberBname", memberBname);
		map.put("memberSigungu", memberSigungu);
		map.put("searchWord", searchWord);
		
		// 리스트 받아오기
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemMapper.selectItemList(map);
		
		// 리스트 리턴
		return list;
	}
	
	
	
	// 아이템 삭제(비활성화)
	public int disabledMemberItem(MemberItem memberItem) {
		System.out.println(memberItem + " <== 멤버 아이템 서비스/멤버 아이템 삭제/멤버 아이템 디버깅");
		
		return memberItemMapper.disabledMemberItem(memberItem);
	}
}
