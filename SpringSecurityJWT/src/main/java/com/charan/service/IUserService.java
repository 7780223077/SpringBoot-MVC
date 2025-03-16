package com.charan.service;

import com.charan.dto.AuthenticationResponse;
import com.charan.dto.LoginRequest;
import com.charan.dto.RegisterRequest;

public interface IUserService {
	public AuthenticationResponse registerUser(RegisterRequest registerRequest);
	public AuthenticationResponse authenticate(LoginRequest loginRequest);
}
