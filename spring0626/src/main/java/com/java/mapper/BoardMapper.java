package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.java.dto.BoardDto;
import com.java.dto.Search;

@Mapper
public interface BoardMapper {

	//게시글 전체가져오기
	ArrayList<BoardDto> selectAll(int startRow, int endRow, @Param("search") Search search);
	
	//게시글 전체 개수
	int selectListCount(Search search);
	
	//게시글 1개 가져오기
	BoardDto selectOne(int bno);
	
	//게시글 이전글
	BoardDto selectPrevOne(int bno);
	
	//게시글 다음글
	BoardDto selectNextOne(int bno);
	
	//게시글 조회수 1증가
	void updateBhitUp(int bno);

	
	//게시글 1개저장
	void insertOne(BoardDto bdto);

	//게시글 1개삭제
	void deleteOne(int bno);

	//게시글 1개 수정
	void updateOne(BoardDto bdto);

	//게시글 bstep 1증가
	void updateBstopCount(BoardDto bdto);
	
	//게시글 답변달기
	void insertReplyOne(BoardDto bdto);

	


}
