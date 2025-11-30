package com.example.mmng_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mmng_back.entity.PartsCategory;

public interface PartsCategoryRepository extends JpaRepository<PartsCategory, Integer> {
	
}
