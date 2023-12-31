package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.dto.PageDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@PostMapping("/board/reviewAjax")
	@ResponseBody //데이터로 넘겨줌
	public ArrayList<BoardDto> reviewAjax(int bno, PageDto pageDto) {
		pageDto.setPage(1);
		System.out.println("BoardController bno : "+bno);
		
		//게시글 여러개 가져오기
		ArrayList<BoardDto> list = boardService.selectBoardAll(); //mapper데이터 여러개 가져옴.
		
		//게시글 1개 가져오기
		//BoardDto bdto = boardService.selectOne(bno); //mapper데이터 1개를 가져옴.
		//bdto.setBfiles(bdto.getBfile().split(",")); //bfile 1개 파일이름을 배열로 변환
		
		return list;
	}
	
	@GetMapping("/board/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	@PostMapping("/board/boardWrite")
	public String boardWrite(BoardDto boardDto, List<MultipartFile> files, Model model) {
		//게시글 1개 저장
		boardService.insertBoard(boardDto, files);
		String result="i_success";
		return "redirect:/board/boardList?result="+result;
	}
	
	@RequestMapping("/board/boardList")
	public String boardList(@RequestParam(defaultValue = "none") String result, PageDto pageDto, Model model) {
		System.out.println("BoardController page : "+pageDto.getPage());
		
		//게시글 전체 가져오기
		HashMap<String, Object> map = boardService.selectAll(pageDto);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("pageDto", map.get("pageDto"));
		model.addAttribute("result", result); //파일저장 결과변수
		
		return "board/boardList";
	}

}
