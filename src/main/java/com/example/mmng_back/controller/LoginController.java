package com.example.mmng_back.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mmng_back.model.UserRequest;
import com.example.mmng_back.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Log4j2
public class LoginController {

	private final UserService userService;
	
	@PostMapping("/login")
	public Object login(@RequestBody(required = false) UserRequest request) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			
		} catch (Exception e) {
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("message", e.getMessage());
			log.info("LoginController > login: "+e.getMessage());
		}
		
		return response;
	}
	
}
