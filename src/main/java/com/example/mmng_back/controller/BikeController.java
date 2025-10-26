package com.example.mmng_back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mmng_back.entity.Bike;
import com.example.mmng_back.entity.User;
import com.example.mmng_back.model.BikeRequest;
import com.example.mmng_back.repository.BikeRepository;
import com.example.mmng_back.repository.UserRepository;
import com.example.mmng_back.service.BikeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j2
public class BikeController {
	
	private final UserRepository userRepository;
	private final BikeRepository bikeRepository;
	private final BikeService bikeService;

	@PostMapping("/getMyBikes")
	public Object getMyBikes(@RequestBody(required = false) BikeRequest request) {
		Map<String, Object> response = new HashMap<>();
		try {
			User user = this.userRepository.getReferenceById(request.getUserId());
			List<Bike> bikeList = this.bikeRepository.findByUserAndDeleteFlgOrderByCreatedAtDesc(user, false);
			response.put("status", HttpStatus.OK.value());
			response.put("bikeList", bikeList);
			log.info("*** [SUCCESS] Get My Bike Lists ***");
			
		} catch (Exception e) {
			log.error("■■■ [ERROR] /getMyBikes ■■■");
			log.error("■■■ ERROR MESSAGES: "+e);
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("message", e.getMessage());
		}
		return response;
	}
	
	@PostMapping("/createBike")
	public Object createBike(@RequestBody(required = false) BikeRequest request) {
		Map<String, Object> response = new HashMap<>();
		try {
			this.bikeService.createBike(request);
			response.put("status", HttpStatus.OK.value());
			log.info("*** [SUCCESS] Create Bike ***");
			
		} catch (Exception e) {
			log.error("■■■ [ERROR] /createBike ■■■");
			log.error("■■■ ERROR MESSAGES: "+e);
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("message", e.getMessage());
		}
		return response;
	}
	
	@PostMapping("/updateBike")
	public Object updateBike(@RequestBody(required = false) BikeRequest request) {
		Map<String, Object> response = new HashMap<>();
		try {
			this.bikeService.updateBike(request);
			response.put("status", HttpStatus.OK.value());
			response.put("updateType", request.getUpdateType());
			log.info("*** [SUCCESS] Update Bike ***");
			
		} catch (Exception e) {
			log.error("■■■ [ERROR] /updateBike ■■■");
			log.error("■■■ ERROR MESSAGES: "+e);
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("message", e.getMessage());
		}
		return response;
	}
}
