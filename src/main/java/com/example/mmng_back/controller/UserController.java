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
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j2
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/updateUser")
	public Object updateUser(@RequestBody(required = false) UserRequest request) {
		Map<String, Object> response = new HashMap<>();
		try {
			boolean existUser = this.userService.existUserCheck(request.getUserId(), request.getUserName());
			if (request.getUpdateType().equals("userName") && existUser) {
				response.put("status", HttpStatus.BAD_REQUEST.value());
				response.put("message", "そのユーザー名は既に使われています");
			} else {
				this.userService.updateUser(request);
				response.put("status", HttpStatus.OK.value());				
			}
			
		} catch (Exception e) {
			log.info("■■■ updateUser ERROR ■■■");
			log.info("■■■ ERROR MESSAGES:"+e);
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("messages", e);
		}
		return response;
	}

}
