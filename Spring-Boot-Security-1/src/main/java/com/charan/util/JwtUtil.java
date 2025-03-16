package com.charan.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	@Value("${app.secret}")
	private String key;
	
	//1. Generate token
	public String generateToken(String id, String subject) {
		return Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuer("Charan")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(10)))
				.signWith(Keys.hmacShaKeyFor(key.getBytes()), SignatureAlgorithm.HS256)
				.compact();
	}
	
	//2. Read claims
	public Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	//3. Read Exp Date
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	//4. Read subject/username
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	//5. Validate Exp Date
	public boolean isTokenExp(String token) {
		Date expDate = getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}
	
	//6. Validate token
	public boolean validateToken(String token, String username) {
		String tokenUserName = getUsername(token);
		return (username.equals(tokenUserName) && !isTokenExp(token));
	}
}
