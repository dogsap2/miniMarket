package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Admin;
import com.cafe24.dk4750.miniMarket.vo.LoginAdmin;

@Mapper
public interface AdminMapper {
	
	// 관리자 로그인 
	public LoginAdmin selectLoginAdmin(Admin admin);
}
