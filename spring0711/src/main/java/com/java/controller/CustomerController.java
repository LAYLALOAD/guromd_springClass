package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.CustomerDto;
import com.java.dto.MemCustDto;
import com.java.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired CustomerService customerService;

	//공지사항 전체가져오기
	@RequestMapping("/customer/notice")
	public String notice(Model model) {
		ArrayList<CustomerDto> list = customerService.selectAll();
		model.addAttribute("list", list);
		
		return "customer/notice";
	}
	
	//공지사항 전체가져오기 - 2개 테이블
	@RequestMapping("/customer/notice2")
	public String notice2(Model model) {
		ArrayList<MemCustDto> list = customerService.selectAll2();
		System.out.println("controller list customerDto : "+list.get(0).getCustomerDto().getBno());
		System.out.println("controller list memberDto : "+list.get(0).getMemberDto().getName());
		
		model.addAttribute("list", list);
		return "customer/notice2";
	}
}
