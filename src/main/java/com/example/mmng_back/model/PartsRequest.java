package com.example.mmng_back.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PartsRequest {

	private Integer partsId;
	private Integer bikeId;
	private Integer partsCategoryId;
	private String partsName;
	private MultipartFile imageData;
	private String changeDate;
	private Integer price;
	
}
