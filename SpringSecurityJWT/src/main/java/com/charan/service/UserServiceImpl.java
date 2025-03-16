package com.charan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.charan.dto.AuthenticationResponse;
import com.charan.dto.LoginRequest;
import com.charan.dto.RegisterRequest;
import com.charan.entity.User;
import com.charan.repository.IUserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	@Transactional
	public AuthenticationResponse registerUser(RegisterRequest registerRequest) {
		var user = User.builder()
				.firstName(registerRequest.getFirstName())
				.lastName(registerRequest.getLastName())
				.email(registerRequest.getEmail())
				.password(passwordEncoder.encode(registerRequest.getPassword()))
				.role(registerRequest.getRole())
				.build();
		userRepo.save(user);
		String token = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(token).build();
	}
	
	@Override
	public AuthenticationResponse authenticate(LoginRequest loginRequest) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getEmail(), 
						loginRequest.getPassword())
				);
		User user = userRepo.
				findByEmail(loginRequest.getEmail())
				.orElseThrow();
		String token = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(token).build();
	}
}
