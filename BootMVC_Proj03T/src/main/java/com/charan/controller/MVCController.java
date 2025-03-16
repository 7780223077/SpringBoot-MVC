package com.charan.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.charan.model.Distributer;

@Controller
public class MVCController {
	
//	@RequestMapping("/")
	@GetMapping
	public String home() {
		return "index";
	}
	
	@GetMapping("/show")
	public String data(Map<String,Object> map) {
		map.put("productName", "DOLO 650");
		map.put("price", 2.0);
		map.put("expiry", LocalDate.now());
		return "show_data";
	}
	
	@GetMapping("/data")
	public String collectionData(Map<String,Object> map) {
		map.put("Arrays", new String[] {"RED", "BLUE", "GREEN", "YELLOW", "ORANGE"});
		map.put("List", List.of("Ramesh", "Suresh", "kamesh", "Venkatesh", "Mahesh"));
		map.put("Set", Set.of(7881112555455555l, 871328514551l, 788111256227862l, 86542659742l));
		map.put("Map", Map.of("Aadhar",404540454045l, "VoterId", 97412574, "Pan",81126641));
		return "collection_data";
	}
	
	@GetMapping("/model-data")
	public String modelData(Map<String, Object> map) {
		Distributer distributer = new Distributer("101", "Charan", "Hyderabad", LocalDate.now());
		Distributer distributer1 = new Distributer("102", "Naresh", "Medak", LocalDate.now());
		map.put("Dist1", distributer);
		map.put("Dist2", distributer1);
		return "model";
	}
	
	@GetMapping("/list-model-data")
	public String ListModelData(Map<String, Object> map) {
		Distributer distributer = new Distributer("101", "Charan", "Hyderabad", LocalDate.now());
		Distributer distributer1 = new Distributer("102", "Naresh", "Medak", LocalDate.now());
		Distributer distributer2 = new Distributer("101", "Charan", "Hyderabad", LocalDate.now());
		Distributer distributer3 = new Distributer("102", "Naresh", "Medak", LocalDate.now());
		map.put("Dist", List.of(distributer, distributer1, distributer2, distributer3));
//		map.put("Dist", null);
		return "list_model";
	}
}
