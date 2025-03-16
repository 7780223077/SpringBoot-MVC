package com.charan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {
	
	private final ServletContext context;
	
	private final ServletConfig config;
	
	public TestController(ServletContext context, ServletConfig config) {
		super();
		this.context = context;
		this.config = config;
	}

	@GetMapping("/hello")
	public String welcomeMessage() {
		return "index";
	}
	
	@GetMapping("/index")
	public Map<String,Object> Wishmessage() {
		Map<String,Object> map = new HashMap<>();
		map.put("name", "charan");
		map.put("age", 20);
		map.put("sex", "male");
		map.put("DOB", LocalDate.of(2001, 06, 29));
		return map;
	}
	
	@GetMapping("/data")
	public String getData(Map<String, Object> map) {
		map.put("Course", "Java full stack");
		map.put("Fee", 25000.0);
		return "forward:show-data";
	}
	
	
	@GetMapping("/show-data")
	public String showData(Map<String, Object> map) {
		map.put("institue", "Naresh i technologies");
		return "show";
	}
	
	@GetMapping("/add")
	public String addData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("request :"+request.hashCode()+", response :"+response.hashCode());
		request.setAttribute("name", "iphone");
		request.setAttribute("price", 25000.0);
		return "product";
	}
	

	@GetMapping("/redirect")
	public String addData() {
		return "redirect:show-data";
	}
	
	@GetMapping("/")
	public String context() {
		System.out.println(context.getContextPath());
		System.out.println(config.getServletName());
		return "index";
	}
	
	@RequestMapping("/response")
	public void process(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.setHeader("Content-Disposition", "attachment;fileName=charan.txt");
		PrintWriter out = response.getWriter();
		out.println("<h2>Hello World</h2>");
	}
	
}
