package com.example.mmng_back.entity;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "parts")
@Data
public class Parts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parts_id")
	private Integer partsId;
	
	@ManyToOne
	@JoinColumn(name = "bike_id")
	private Bike bike;
	
	@ManyToOne
	@JoinColumn(name = "parts_category_id")
	private PartsCategory partsCategory;
	
	@Column(name = "parts_name")
	private String partsName;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "change_date")
	private Date changeDate;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "delete_flg")
	private boolean deleteFlg;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;
	
	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;
	
}
