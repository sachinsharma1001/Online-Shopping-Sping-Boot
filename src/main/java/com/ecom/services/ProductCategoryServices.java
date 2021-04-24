package com.ecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.ProductCategoryRepository;

@Service
public class ProductCategoryServices {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
}
