package com.charan.service;

import org.springframework.stereotype.Repository;

import com.charan.entity.User;

@Repository
public interface IUserService {
	public Integer saveUser(User user);
}
