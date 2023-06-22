package com.java.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor //기본생성자
@AllArgsConstructor //전체생성자
@Data //get set
public class BoardDto {
	
	private int bno;
	private String btitle;
	

}
