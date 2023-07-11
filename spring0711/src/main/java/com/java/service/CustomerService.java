package com.java.service;

import java.util.ArrayList;

import com.java.dto.CustomerDto;
import com.java.dto.MemCustDto;

public interface CustomerService {

	//공지사항 전체가져오기
	ArrayList<CustomerDto> selectAll();

	//공지사항 전체가져오기 - 2개 테이블
	ArrayList<MemCustDto> selectAll2();

}
