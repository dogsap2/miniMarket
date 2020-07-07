package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Chatroom;


@Mapper
public interface ChatroomMapper {
	public int selectChatRoomCheck(Chatroom chatroom);
	public List<Chatroom> selectChatRoomByMemberId(Chatroom chatroom);
	public int insertChatRoom(Chatroom chatroom);
	public int selectMaxNum();
	public Chatroom selectChatroomOne(int chatroomNo);
	public int updateChatroomDisconnect(Chatroom chatroom);
}
