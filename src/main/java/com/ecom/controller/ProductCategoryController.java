package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.services.ProductCategoryServices;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryServices categoryServices;

	@GetMapping
	public void getAllProductCategory() {

	}

	@GetMapping("/{product-category-id}")
	public void getProductCategory() {

	}

	@PostMapping
	public void createProductCategory() {

	}

	@PutMapping
	public void updateProductCategory() {

	}

	@DeleteMapping
	public void deleteProductCategory() {

	}
}
