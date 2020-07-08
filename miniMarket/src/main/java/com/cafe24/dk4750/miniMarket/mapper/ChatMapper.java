package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Chat;

@Mapper
public interface ChatMapper {
	public List<Chat> selectChatList(int chatroomNo);
	public int insertChatList(Chat chat);
	public List<String> selectChatMemberId(int chatroomNo);
}
