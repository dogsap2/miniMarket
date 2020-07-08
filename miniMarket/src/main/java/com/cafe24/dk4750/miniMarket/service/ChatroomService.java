package com.cafe24.dk4750.miniMarket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ChatroomMapper;
import com.cafe24.dk4750.miniMarket.vo.Chatroom;


@Service
@Transactional
public class ChatroomService {
	@Autowired
	private ChatroomMapper chatroomMapper;
	
	public List<Chatroom> getChatRoomListByMemberUniqueNo(String memberId){
		return chatroomMapper.selectChatRoomByMemberUniqueNo(memberId);
	}
	
	public int modifyChatroomDisconnect(Chatroom chatroom) {
	      return chatroomMapper.updateChatroomDisconnect(chatroom);
	   }
	
	public Chatroom getChatRoomOne(int chatroomNo) {
	      return chatroomMapper.selectChatroomOne(chatroomNo);
	   }
	
	public List<Chatroom> getChatRoomListBymemberId(Chatroom chatroom) {
		List<Chatroom> list = new ArrayList<>();
		list = chatroomMapper.selectChatRoomByMemberId(chatroom);
		return list;
	}
	public int addChatRoom(Chatroom chatroom) {
		System.out.println(chatroom);
		int checkroom = chatroomMapper.selectChatRoomCheck(chatroom);
		System.out.println(checkroom + "채팅방 유무 체크");
		if(checkroom > 0) {
			return 0;
		}else {
			
			return chatroomMapper.insertChatRoom(chatroom);
		}
		 
	}
}
