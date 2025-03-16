package com.charan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charan.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByEmail(String email);
}
