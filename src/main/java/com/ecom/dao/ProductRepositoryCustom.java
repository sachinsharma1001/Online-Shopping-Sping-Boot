package com.ecom.dao;

import java.util.List;

import com.ecom.entities.Product;

public interface ProductRepositoryCustom {

	public List<Product> getProductByCategoryName();
}
