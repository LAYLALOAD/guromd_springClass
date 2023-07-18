package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.dto.PageDto;
import com.java.mapper.BoardMapper;

@Service
public class BoradServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	 
	@Override //게시글 전체가져오기 - 현재페이지
	public HashMap<String, Object> selectAll(PageDto pageDto) {
		HashMap<String, Object> map = new HashMap<>();
		
		//페이지정보 메소드 호출
	    pageDto = pageMethod(pageDto);
		
		//게시글 전체 가져오기
		ArrayList<BoardDto> list = boardMapper.selectAll(pageDto);
		System.out.println("BoradServiceImpl remainDate : "+list.get(0).getRemainDate());
		
		map.put("list", list);
		map.put("pageDto", pageDto);
		
		
		return map;
	}
	
	//페이지 정보 매소드
	public PageDto pageMethod(PageDto pageDto) {
		
		//전체게시글 수-142, 현재페이지, 최대페이지, 시작페이지, 끝페이지 : 하단 넘버링이 필요 1-시작, 2, 3, 4, 5-현재, 6, 7, 8, 9, 10-끝 15-최대
		//시작번호, 끝나는번호 1-10, 11-20, 21-30
		
		//전체게시글 수 저장
		pageDto.setListCount(boardMapper.selectListCount());
		//최대 하단넘버링 페이지
		pageDto.setMaxPage((int)Math.ceil((double)pageDto.getListCount()/10));
		//시작 넘버링 페이지
		pageDto.setStartPage((int)((pageDto.getPage()-1)/10)*10 + 1);
		//끝 넘버링 페이지
		pageDto.setEndPage(pageDto.getStartPage()+10-1);
		//시작번호
		pageDto.setStartRow((pageDto.getPage()-1)*10+1);
		//끝나는 번호
		pageDto.setEndRow(pageDto.getStartRow()+10-1);
		
		
		return pageDto;
		
	}

}
