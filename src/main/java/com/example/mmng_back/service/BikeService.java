package com.example.mmng_back.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mmng_back.entity.Bike;
import com.example.mmng_back.entity.User;
import com.example.mmng_back.model.BikeRequest;
import com.example.mmng_back.repository.BikeRepository;
import com.example.mmng_back.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BikeService {

	private final UserRepository userRepository;
	private final BikeRepository bikeRepository;
	
	@Transactional
	public void createBike(BikeRequest request) {
		try {
			User user = this.userRepository.getReferenceById(request.getUserId());
			Bike bike = new Bike();
			bike.setUser(user);
			bike.setBikeName(request.getBikeName());
			bike.setMakerName(request.getMakerName());
			bike.setSize(request.getSize());
			bike.setWheelBase(request.getWheelBase());
			bike.setBbShell(request.getBbShell());
			bike.setDeleteFlg(false);
			this.bikeRepository.save(bike);
			
		} catch (Exception e) {
			log.error("■■■ [SERVICE ERROR] createBike ■■■");
			log.error("■■■ ERROR MESSAGES: "+e);
		}
	}
	
	@Transactional
	public void updateBike(BikeRequest request) {
		try {
			Bike bike = this.bikeRepository.findById(request.getBikeId()).get();
			switch(request.getUpdateType()) {
				case "makerName":
					bike.setMakerName(request.getMakerName());
					break;
				case "bikeName":
					bike.setBikeName(request.getBikeName());
					break;
				case "size":
					bike.setSize(request.getSize());
					break;
				case "wheelBase":
					bike.setWheelBase(request.getWheelBase());
					break;
				case "bbShell":
					bike.setBbShell(request.getBbShell());
					break;
			}
			this.bikeRepository.save(bike);
			
		} catch (Exception e) {
			log.error("■■■ [SERVICE ERROR] updateBike ■■■");
			log.error("■■■ ERROR MESSAGES: "+e);			
		}
	}
	
}
