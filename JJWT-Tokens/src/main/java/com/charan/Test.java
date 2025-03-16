package com.charan;

import io.jsonwebtoken.Claims;

public class Test {

	public static void main(String[] args) {
		
		String key = "0123456789ABCDEF0123456789ABCDEF";
		
		JwtUtil util = new JwtUtil();
//		String token = util.generateToken("ACIN", "Naresh", key);
//		System.out.println(token);
//		
//		Claims claims = util.getClaims(key, token);
//		System.out.println(claims.getId());
		
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJBQ0lOIiwic3ViIjoiTmFyZXNoIiwiaXNzIjoiTmFyZXNoIiwiaWF0IjoxNzE1NTE0OTYzLCJleHAiOjE3MTU1MTUwMjN9.PCD8KnMHGUbKnujA7BLOZQj2VSuHIrTnejX36184_lw";
		System.out.println(util.isValidToken(key, token));
		
	}
}