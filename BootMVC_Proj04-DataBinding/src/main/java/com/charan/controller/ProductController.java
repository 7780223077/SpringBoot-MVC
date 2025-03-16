package com.charan.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.charan.model.Product;

@Controller
public class ProductController {
	
	@GetMapping("/register")
	public String getProductRegisterPage(@ModelAttribute("prod") Product product) {
		System.out.println(product);
		return "product_register";
	}
	
	@PostMapping("/register")
	public String register(Map<String, Object> map, @ModelAttribute("prod") Product product) {
		System.out.println("Registration");
		System.out.println(product.toString());
		map.put("product", product);
		return "show_product";
	}

}
