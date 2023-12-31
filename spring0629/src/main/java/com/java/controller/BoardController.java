package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.BoardDto;
import com.java.dto.CommentDto;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/notice")
	public String notice(Model model) {
		ArrayList<BoardDto> list = new ArrayList<>();
		//게시글 전체 가져오기
		list = boardService.selectAll();
		model.addAttribute("list", list);
		
		return "board/notice";
	}
	
	@RequestMapping("/board/noticeView")
	public String noticeView(int bno, Model model) {
		//게시글 1개 가져오기
		BoardDto bdto = boardService.selectOne(bno);
		//하단댓글 모두가져오기
		ArrayList<CommentDto> comList = boardService.selectComAll(bno);
		
		model.addAttribute("bdto", bdto);
		model.addAttribute("comList", comList);
		return "board/noticeView";
	}
	
	@RequestMapping("/board/commentInsert")
	@ResponseBody //그냥 데이터로 리턴해서 돌려줘
	public CommentDto commentInsert(CommentDto comDto) {
		System.out.println("ajax 넘어온 데이터 1: "+comDto.getCcontent());
		//하단댓글 저장, 1개 가져오기
		CommentDto cdto = boardService.commentInsert(comDto);
		
		return cdto;
	}
	
	@RequestMapping("/board/commentDelete")
	@ResponseBody
	public String commentDelete(int cno) {
		System.out.println("ajax 넘어온 데이터 : "+ cno);
		//하단댓글 1개삭제
		boardService.commentDelete(cno);
		
		String result="success";
		return result;
	}
	
	@RequestMapping("/board/commentUpdateSave") //댓글 수정저장
	@ResponseBody
	public CommentDto commentUpdateSave(CommentDto comDto) {
		System.out.println("BoardController commentUpdateSave : "+comDto.getCcontent());
		System.out.println("BoardController commentUpdateSave : "+comDto.getCno());
		
		//하단댓글 수정저장
		CommentDto cdto =  boardService.commentUpdateSave(comDto);
		//String result = "success";
		return cdto; 
		
	}
	
	
}
