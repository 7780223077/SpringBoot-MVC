package com.charan.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WisMessageController {
	
	@GetMapping("/")
	public String Wishmessage(Map<String,Object> map) {
		map.put("name", "charan");
		map.put("age", 20);
		map.put("sex", "male");
		map.put("DOB", LocalDate.of(2001, 06, 29));
		return "hello";
	}
	
}
