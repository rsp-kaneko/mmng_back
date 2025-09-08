package com.example.mmng_back.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mmng_back.entity.User;
import com.example.mmng_back.model.UserRequest;
import com.example.mmng_back.repository.UserRepository;
import com.example.mmng_back.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Log4j2
public class LoginController {

	private final UserService userService;
	private final UserRepository userRepository;
	
	@PostMapping("/login")
	public Object login(@RequestBody(required = false) UserRequest request) {
		Map<String, Object> response = new HashMap<>();
		try {
			String errorMsg = this.userService.login(request);
			if (errorMsg == null) {
				User user = this.userRepository.findByUserName(request.getUserName());
				String token = Base64.getEncoder().encodeToString(user.getUserName().getBytes());
				user.setToken(token);
				this.userRepository.save(user);
				
				response.put("status", HttpStatus.OK.value());
				response.put("token", token);
				response.put("userName", user.getUserName());
				response.put("userId", user.getUserId());
				
			} else {
				response.put("status", HttpStatus.BAD_REQUEST.value());
				response.put("message", errorMsg);
			}
					
		} catch (Exception e) {
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("message", e.getMessage());
			log.info("LoginController > login: "+e.getMessage());
		}
		
		return response;
	}
	
	@PostMapping("/loginTokenCheck")
	public Object loginTokenCheck(@RequestBody(required = false) UserRequest request) {
		Map<String, Object> response = new HashMap<>();
		try {
			User user = this.userRepository.findByToken(request.getToken());
			if (user != null) {
				response.put("status", HttpStatus.OK.value());
				response.put("userName", user.getUserName());
				response.put("userId", user.getUserId());
				
			} else {
				response.put("status", HttpStatus.BAD_REQUEST.value());
			}
			
		} catch (Exception e) {
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("message", e.getMessage());
		}
		
		return response;
	}
}
