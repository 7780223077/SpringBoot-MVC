package com.charan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.entity.User;
import com.charan.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepo;

	@Override
	public Integer saveUser(User user) {
		//TODO : encode password
		return userRepo.save(user).getId();
	}

}
