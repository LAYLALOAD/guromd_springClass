package com.java.service;

import java.util.HashMap;

import com.java.dto.BoardDto;
import com.java.dto.PageDto;

public interface BoardService {

	//게시글 전체가져오기
	HashMap<String, Object> selectAll(PageDto pageDto);

}
