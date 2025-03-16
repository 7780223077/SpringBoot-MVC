package com.charan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private String id;
	private String name;
	private String description;
	private String specifications;
	private String features;
	private Double price;
	private String manufacturer="Apple";
}
