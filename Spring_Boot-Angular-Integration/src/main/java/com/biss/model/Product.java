package com.biss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer prodId;
	private String prodCode;
	private Double prodPrice;
	private String prodVendor;
	private String prodColor;
	
}
