package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecom.entities.ProductCategory;

@CrossOrigin
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
