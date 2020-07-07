package com.cafe24.dk4750.miniMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ChatMapper;
import com.cafe24.dk4750.miniMarket.vo.Chat;


@Service
@Transactional
public class ChatService {
	@Autowired
	private ChatMapper chatMapper;
	
	public List<Chat> getChatList(int chatroomNo){
		System.out.println(chatroomNo);
		List<Chat> list = chatMapper.selectChatList(chatroomNo);
		
		return list;
	}
	
	public int addChatList(Chat chat) {
		System.out.println(chat);
		
		return chatMapper.insertChatList(chat);
	}
}
