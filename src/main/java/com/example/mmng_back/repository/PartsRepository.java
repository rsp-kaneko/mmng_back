package com.example.mmng_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mmng_back.entity.Parts;

public interface PartsRepository extends JpaRepository<Parts, Integer> {
	
}
