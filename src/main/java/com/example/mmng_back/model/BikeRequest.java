package com.example.mmng_back.model;

import lombok.Data;

@Data
public class BikeRequest {
	
	private String updateType;
	private Integer bikeId;
	private Integer userId;
    private String bikeName;
    private String makerName;
    private Integer size;
    private Integer wheelBase;
    private Integer bbShell;

}
