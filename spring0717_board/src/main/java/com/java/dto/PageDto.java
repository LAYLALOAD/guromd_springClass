package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageDto {

	private int page=1; 
	private int listCount; 
	private int maxPage; 
	private int startPage; 
	private int endPage; 
	private int startRow; 
	private int endRow; 
	private int rowPerPage=10; 
	private int numberringPerPage=10; 
}
