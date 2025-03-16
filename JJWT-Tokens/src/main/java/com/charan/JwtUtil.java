package com.charan;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	
	public String generateToken(String id, String subject, String key) {
		return Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuer("Naresh")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(1)))
				.signWith(getKey(key), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public Claims getClaims(String key, String token) {
		return Jwts.parserBuilder()
                .setSigningKey(getKey(key))
                .build()
                .parseClaimsJws(token)
                .getBody();

	}
	
	private SecretKey getKey(String key) {
		return Keys.hmacShaKeyFor(key.getBytes());
	}
	
	public boolean isValidToken(String key, String token) {
		return getClaims(key, token)
				.getExpiration()
				.after(new Date(System.currentTimeMillis()));
	}
}
