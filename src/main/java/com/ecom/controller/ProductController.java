package com.ecom.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.ProductRequestBean;
import com.ecom.dto.ProductResponseBean;
import com.ecom.exception.BadRequestException;
import com.ecom.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	private Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductServices provideService;

	@GetMapping
	public ProductResponseBean getAllProducts(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id") String sortBy) {

		logger.debug("Hello debug message");
		logger.info("Hello info message");
		return provideService.getAllProducts(pageNo, pageSize, sortBy);
	}

	@GetMapping("/{productId}")
	public ProductResponseBean getProductById(@PathVariable("productId") Long productId) throws Exception {
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
