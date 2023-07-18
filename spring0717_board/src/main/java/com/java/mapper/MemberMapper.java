package com.java.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {
	
	//회원 1명 가져오기(로그인)
	MemberDto selectOne(String id, String pw);

}
