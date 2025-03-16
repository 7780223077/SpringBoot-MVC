package com.charan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charan.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

}
