package com.example.mmng_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mmng_back.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, Integer> {
	
}
