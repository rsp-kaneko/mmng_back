package com.example.mmng_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "parts_categories")
@Data
public class PartsCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parts_category_id")
	private Integer partsCategoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "icon_url")
	private String iconUrl;
	
}
