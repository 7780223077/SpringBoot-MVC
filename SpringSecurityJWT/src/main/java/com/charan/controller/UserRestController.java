package com.charan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charan.dto.AuthenticationResponse;
import com.charan.dto.LoginRequest;
import com.charan.dto.RegisterRequest;
import com.charan.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private IUserService userService;
		
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody RegisterRequest registerRequest) {
		AuthenticationResponse response = userService.registerUser(registerRequest);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticateUser(
			@RequestBody LoginRequest loginRequest){
		AuthenticationResponse response = userService
				.authenticate(loginRequest);
		return ResponseEntity.ok(response);
	}
}
