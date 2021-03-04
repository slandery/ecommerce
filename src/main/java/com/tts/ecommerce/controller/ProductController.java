package com.tts.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/product/{id}")
	public String show()
	{
		Product product = productService.findById(id);
		model.addAttribute(product);
		return "product";
	}	

	
	@RequestMapping (value = "/product" , method = {RequestMethod.POST, RequestMethod.PUT})
	public String createOrUpdate(@Valid Product product) {
		productService.save(product);
		return "redirect/product/" + product.getId;
	}
}
