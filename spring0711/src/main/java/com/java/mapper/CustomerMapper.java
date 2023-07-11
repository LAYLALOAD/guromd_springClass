package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.CustomerDto;
import com.java.dto.MemCustDto;

@Mapper
public interface CustomerMapper {

	//공지사항 전체 가져오기
	ArrayList<CustomerDto> selectAll();

	//공지사항 전체가져오기 - 2개 테이블
	ArrayList<MemCustDto> selectAll2();

}
