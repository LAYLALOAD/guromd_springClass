package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.CustomerDto;
import com.java.service.CustomerService;

@Controller
public class ProductController {
	
	@Autowired CustomerService customerService;

	@RequestMapping("/product/productList")
	public String productList(Model model) {
		ArrayList<CustomerDto> list = customerService.selectAll();
		model.addAttribute("list", list);
		return "product/productList";
	}
}
