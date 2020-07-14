package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.NoticeMapper;
import com.cafe24.dk4750.miniMarket.vo.Notice;

@Service
@Transactional
public class NoticeService {
	@Autowired private NoticeMapper noticeMapper;
	
	// 공지사항 목록
	public List<Notice> getNoticeList() {
		int beginRow = 0;
		int rowPerPage = 10;
		String searchWord = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		List<Notice> list = noticeMapper.selectNoticeList(map);
		return list;
	}
	
	// 공지사항 자세히 보기
	public Notice getNoticeOne(int noticeNo) {
		return noticeMapper.selectNoticeOne(noticeNo);
	}
	
	// 공지사항 입력하기
	public int addNotice(Notice notice) {
		return noticeMapper.insertNotice(notice);
	}
	
	// 공지사항 수정하기
	public int modifyNotice(Notice notice) {
		return noticeMapper.updateNotice(notice);
	}
	
	
}
