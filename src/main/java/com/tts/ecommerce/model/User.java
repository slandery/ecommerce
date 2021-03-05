package com.tts.ecommerce.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "user_id")
	  private Long id;
	  
	  @Length(min = 5, message = "A password must have at least 5 characters")
	  private String password;

	public Map<Product, Integer> getCart() {
		// TODO Auto-generated method stub
		return null;
	}
}
