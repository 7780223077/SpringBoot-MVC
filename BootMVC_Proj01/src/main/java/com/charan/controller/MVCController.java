package com.charan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
public class MVCController {
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ServletConfig servletConfig;

	@RequestMapping("/home")
	public String getData(Map<String,Object> map) {
		map.put("name", "charan");
		map.put("age", 10);
		return "forward:view";
	}
	
	@RequestMapping("/view")
	public String getDataView(Map<String,Object> map) {
		map.put("sal", 35000.0);
		return "home";
	}
	
	@RequestMapping("/session")
	public String getSession(HttpSession session) {
		System.out.println(session);
		System.out.println(servletContext);
		System.out.println(servletConfig);
		session.setAttribute("name", "charan");
		session.setAttribute("age",25);
		session.setAttribute("sal",250000.0);
		return "home";
	}
	
}
