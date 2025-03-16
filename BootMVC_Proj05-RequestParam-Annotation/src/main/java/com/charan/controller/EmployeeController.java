package com.charan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class EmployeeController {

	@GetMapping("/emp")
	public String requestParam(Map<String, Object> map,
			@RequestParam(required = false, defaultValue = "102") List<Integer> empNo,
			@RequestParam(required = false, defaultValue = "java developer") List<String> desig) {
		map.put("empNo", empNo);
		map.put("desig", desig);	
		System.out.println(empNo +", "+desig);
		return "request_param";
	}
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
}
