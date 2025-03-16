package com.charan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charan.entity.User;
import com.charan.model.UserRequest;
import com.charan.model.UserResponse;
import com.charan.service.IUserService;
import com.charan.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	//1.save user data in database
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		Integer id = userService.saveUser(user);
		String body = "User with '"+id+"' saved";
		return ResponseEntity.ok(body);
	}
	
	//2.validate user and generate token
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserRequest request){
		//TODO : validate username/password with database
		String token = jwtUtil.generateToken("10", request.getPassword());
		return ResponseEntity.ok(new UserResponse(token,"Success"));
	}
}
