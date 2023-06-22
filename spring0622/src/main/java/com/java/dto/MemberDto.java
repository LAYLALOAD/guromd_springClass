package com.java.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor //기본생성자
@AllArgsConstructor //전체생성자
@Data //get set
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String hobby;

}
