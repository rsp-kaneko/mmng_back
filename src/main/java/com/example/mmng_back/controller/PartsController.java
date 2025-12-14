package com.example.mmng_back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mmng_back.entity.PartsCategory;
import com.example.mmng_back.repository.PartsCategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PartsController {
	
	private final PartsCategoryRepository partsCategoryRepository;
	
	@GetMapping("/getAllPartsCategories")
	public Object getAllPartsCategories() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<PartsCategory> partsCategoryList = this.partsCategoryRepository.findAll();
			response.put("status", HttpStatus.OK.value());
			response.put("partsCategoryList", partsCategoryList);
			
		} catch (Exception e) {
			log.error("■■■ [ERROR] /getAllPartsCategories ■■■");
			log.error("■■■ ERROR MESSAGES: "+e);
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("message", e.getMessage());
		}
		return response;
	}

}
