package com.ecom.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.aspects.BadRequestException;
import com.ecom.dto.ProductRequestBean;
import com.ecom.dto.ProductResponseBean;
import com.ecom.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductServices provideService;

	@GetMapping
	public ProductResponseBean getAllProducts() {
		return provideService.getAllProducts();
	}

	@GetMapping("/{productId}")
	public ProductResponseBean getProductById(@PathVariable("productId") Long productId) throws BadRequestException {
		return provideService.getProductById(productId);
	}

	@PostMapping
	public void createProduct(@RequestBody @Valid ProductRequestBean productRequestBean) {
		provideService.saveProduct(productRequestBean);
	}

	@PutMapping(("/{productId}"))
	public void updateProduct(@PathVariable("productId") Long productId,
			@RequestBody @Valid ProductRequestBean productRequestBean) throws BadRequestException {
		provideService.updateProduct(productId, productRequestBean);
	}

	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable("productId") Long productId) {
		provideService.deleteProduct(productId);
	}

}
