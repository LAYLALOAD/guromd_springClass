package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.CustomerDto;
import com.java.dto.MemCustDto;
import com.java.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerMapper customerMapper;
	
	//공지사항 전체가져오기
	@Override
	public ArrayList<CustomerDto> selectAll() {
		
		ArrayList<CustomerDto> list = customerMapper.selectAll();
		return list;
	}

	//공지사항 전체가져오기 - 2개 테이블
	@Override
	public ArrayList<MemCustDto> selectAll2() {
		ArrayList<MemCustDto> list = customerMapper.selectAll2();
		return list;
	}

}
