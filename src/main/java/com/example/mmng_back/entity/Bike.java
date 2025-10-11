package com.example.mmng_back.entity;

import java.sql.Timestamp;

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
@Table(name = "bikes")
@Data
public class Bike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bike_id")
	private Integer bikeId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "bike_name")
	private String bikeName;
	
	@Column(name = "maker_name")
	private String makerName;
	
	@Column(name = "size")
	private Integer size;
	
	@Column(name = "wheel_base")
	private Integer wheelBase;
	
	@Column(name = "bb_shell")
	private Integer bbShell;
	
	@Column(name = "delete_flg")
	private boolean deleteFlg;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;
	
	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;
	
}
