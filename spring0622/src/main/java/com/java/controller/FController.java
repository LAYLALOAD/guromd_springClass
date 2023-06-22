package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;

@Controller
public class FController {

	@Autowired //주입(DI: Dependency Injection)
	BService bService;
	
	@GetMapping("/index")
	public String index() {
		System.out.println("s(15) : "+bService.add());
		return "index";
	}

}
