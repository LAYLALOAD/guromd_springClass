package com.java.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.dto.PageDto;

public interface BoardService {

	//게시글 전체가져오기
	HashMap<String, Object> selectAll(PageDto pageDto);

	//게시글 1개 저장
	void insertBoard(BoardDto boardDto, List<MultipartFile> files);

}
