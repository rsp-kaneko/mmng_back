package com.example.mmng_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mmng_back.entity.Bike;
import com.example.mmng_back.entity.User;

public interface BikeRepository extends JpaRepository<Bike, Integer> {
	
	public List<Bike> findByUserAndDeleteFlgOrderByCreatedAtDesc(User user, boolean deleteFlg);
	
}
