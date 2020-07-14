package com.cafe24.dk4750.miniMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.dk4750.miniMarket.mapper.AdminMapper;
import com.cafe24.dk4750.miniMarket.vo.Admin;
import com.cafe24.dk4750.miniMarket.vo.LoginAdmin;

@Service
public class AdminService {
	@Autowired private AdminMapper adminMapper;

	// 관리자 로그인
	public LoginAdmin getLoginAdmin(Admin admin) {
		return adminMapper.selectLoginAdmin(admin);
	}
}
