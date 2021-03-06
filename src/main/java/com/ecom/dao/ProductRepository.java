package com.ecom.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.entities.Product;

@CrossOrigin
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, ProductRepositoryCustom {

	Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
}
