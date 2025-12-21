package com.example.mmng_back.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mmng_back.entity.Bike;
import com.example.mmng_back.entity.Parts;
import com.example.mmng_back.entity.PartsCategory;
import com.example.mmng_back.model.PartsRequest;
import com.example.mmng_back.repository.BikeRepository;
import com.example.mmng_back.repository.PartsCategoryRepository;
import com.example.mmng_back.repository.PartsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartsService {
	
	private final PartsRepository partsRepository;
	private final BikeRepository bikeRepository;
	private final PartsCategoryRepository partsCategoryRepository;
	
	@Transactional
	public void createParts(PartsRequest request) throws ParseException {
		Bike bike = this.bikeRepository.findById(request.getBikeId()).get();
		PartsCategory partsCategory = this.partsCategoryRepository.findById(request.getPartsCategoryId()).get();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date changeDate = sdf.parse(request.getChangeDate());
		Parts parts = new Parts();
		
		parts.setBike(bike);
		parts.setPartsCategory(partsCategory);
		parts.setPartsName(request.getPartsName());
		parts.setImageUrl(null);
		parts.setChangeDate(changeDate);
		parts.setPrice(request.getPrice());
		parts.setDeleteFlg(false);
		this.partsRepository.save(parts);
	}
	
}
