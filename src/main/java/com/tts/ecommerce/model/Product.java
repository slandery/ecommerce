package com.tts.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "user_id")
	  private Long id;
	  
	//add this in
	private int quantity;
	private double price;
	private String description;
	private String name;
	private String brand;
	private String category;
	private String image;

	public String getId;

	public static List<String> findDistinctBrands() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Product> findByBrandAndOrCategory(String brand2, String category2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
