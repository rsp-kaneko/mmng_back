package com.example.mmng_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mmng_back.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUserName(String userName);
	
}
