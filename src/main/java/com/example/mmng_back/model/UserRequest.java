package com.example.mmng_back.model;

import lombok.Data;

@Data
public class UserRequest {
	
	private Integer userId;
	private String userName;
	private String password;
	private String token;

}
