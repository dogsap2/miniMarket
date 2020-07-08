package com.cafe24.dk4750.miniMarket.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.dk4750.miniMarket.service.ChatService;
import com.cafe24.dk4750.miniMarket.service.ChatroomService;
import com.cafe24.dk4750.miniMarket.vo.Chat;
import com.cafe24.dk4750.miniMarket.vo.Chatroom;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;




@Controller
public class ChatController {
	@Autowired
	private ChatroomService chatroomService;
	@Autowired 
	private ChatService chatService;
	
	
	@GetMapping("/chatroom")
	public String getChatRoom(HttpSession session, Model model, @RequestParam("chatroomNo") int chatroomNo) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:login";
		}
		String memberId = ((LoginMember)session.getAttribute("loginMember")).getMemberId();
		String memberNickname = ((LoginMember)session.getAttribute("loginMember")).getMemberNickname();
		System.out.println(chatroomNo);
		List<String> list = chatService.getChatMemberId(chatroomNo);
		System.out.println(list + "<--출력");
		Chatroom chatroom = chatroomService.getChatRoomOne(chatroomNo);
		model.addAttribute("chatroom", chatroom);
		model.addAttribute("memberNickname", memberNickname);
		model.addAttribute("memberId", memberId);
		model.addAttribute("MymemberId", chatroom.getMemberId());
		model.addAttribute("list", list);

		return "chatroom";
	}
	
	@PostMapping("/addMessage")
	@ResponseBody
	public int addMessage(Chat chat){
		System.out.println(chat);	
		return chatService.addChatList(chat);
	}
	
	@RequestMapping("/getAllMessages")
	@ResponseBody
	public List<Chat> getAllMessages(@RequestParam("chatroomNo") int chatroomNo){
		System.out.println(chatroomNo+"<--chatroomNo");
		
		List<Chat> list = chatService.getChatList(chatroomNo);
		System.out.println(list.toString() + "<--list");
		return list;
	}
}
