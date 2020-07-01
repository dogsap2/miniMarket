package com.cafe24.dk4750.miniMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ReportMByMMapper;

@Service
@Transactional
public class ReportMByMService {
	@Autowired
	private ReportMByMMapper reportMByMMapper;
}
