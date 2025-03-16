package com.charan.dto;

import com.charan.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
	public String firstName;
	
	public String lastName;
	
	public String email;
	
	public String password;
	
	public Role role; 
}
