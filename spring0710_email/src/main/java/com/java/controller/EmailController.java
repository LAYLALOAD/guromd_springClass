package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.EmailService;

@Controller
public class EmailController {
	
	@Autowired EmailService emailService;
	
	@RequestMapping("/email/emailSend")
	@ResponseBody // 데이터를 리턴해서 가져오는 것 (= lastcontroller)
	public String emailSend(String name, String email) {
		System.out.println("name : "+name);
		System.out.println("email : "+email);
		
		//임시비밀번호 코드생성
		String pwCode = emailService.insertPwCode(name,email);
		
		//문자인증 코드 생성
		//공공데이터 api데이터 받아왔을때 구문 넣으면 됨.
		
		
		return pwCode;
		
	}
	
	@RequestMapping("/member/idsearch")
	public String idsearch() {
		return "member/idsearch";
		
	}

}
