package com.tts.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.ecommerce.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	Product findById(long id);
	List<Product> findByBrand (String brand);
	List<Product> findByCategory(String category);
	List<Product> findByBrandAndCategory(String brand, String category);

	List<String> findDistinctBrands();
	List<String> findDistinctCategories();

	
}
