package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.ChatroomService;
import com.cafe24.dk4750.miniMarket.vo.Chatroom;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;



@Controller
public class ChatroomController {
	
	@Autowired
	private ChatroomService chatroomService;
	
	@GetMapping("/modifyChatroomActive")
	public String modifyChatroom(@RequestParam("chatroomNo") int chatroomNo) {
		System.out.println(chatroomNo + "<--chatroomNo modifyChatroomActive");
		String chatroomActive = "connect";
		Chatroom chatroom = new Chatroom();
		chatroom.setChatroomNo(chatroomNo);
		chatroom.setChatroomActive(chatroomActive);
		chatroomService.modifyChatroomDisconnect(chatroom);
		return "redirect:/chatroomList";
	}
	
	@GetMapping("/button")
	public String getButton() {
		return "button";
	}
	@GetMapping("/chatroomList")
	public String getChatRoomListByMemberId(HttpSession session, Model model) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:login";
		}
		String memberUniqueNo = ((LoginMember)session.getAttribute("loginMember")).getMemberUniqueNo();
		String memberId = ((LoginMember)session.getAttribute("loginMember")).getMemberId();
		String memberNickname = ((LoginMember)session.getAttribute("loginMember")).getMemberNickname();
		Chatroom chatRoom = new Chatroom();
		chatRoom.setMemberId(memberId);
		chatRoom.setMemberUniqueNo(memberUniqueNo);
		List<Chatroom> list = chatroomService.getChatRoomListBymemberId(chatRoom);
		System.out.println(list + "<--채팅방 리스트");
		model.addAttribute("list", list);
		model.addAttribute("memberId", memberId);
		model.addAttribute("memberUniqueNo", memberUniqueNo);
		model.addAttribute("memberNickname", memberNickname);
		return "chatroomList";
	}
	
	@PostMapping("/chatroom")
	public String addChatRoom(/*세션으로 받*/ @RequestParam("memberId") String memberId/*받는 사람*/, Model model, HttpSession session) {
		String memberUniqueNo = ((LoginMember)session.getAttribute("loginMember")).getMemberUniqueNo();
		System.out.println(memberUniqueNo);
		System.out.println(memberId);
		int memberItemNo = 5;
		String active = "disconnect"; 
		Chatroom chatroom = new Chatroom();
		chatroom.setMemberItemNo(memberItemNo);
		chatroom.setMemberUniqueNo(memberUniqueNo);
		chatroom.setMemberId(memberId);
		chatroom.setChatroomActive(active);
		
		
		int chatRoomCheck = chatroomService.addChatRoom(chatroom);
		if(chatRoomCheck == 0) {
			model.addAttribute("msg", "이미 채팅방이 존재합니다.");
			return "button";
		}else {
			return "redirect:/chatroomList";
		}
	}
}
