package com.example.mmng_back.model;

import lombok.Data;

@Data
public class UserRequest {
	
	private String userId;
	private String roleId;
	private String userName;
	private String password;
	private String token;
	private String deleteFlg;
	private String createdAt;
	private String updatedAt;

}
