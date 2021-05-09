package com.ecom.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecom.dao.ProductRepositoryCustom;
import com.ecom.entities.Product;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Product> getProductByCategoryName() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> query = cb.createQuery(Product.class);
		Root<Product> product = query.from(Product.class);
		List<Predicate> predicateList = new ArrayList<>();
		
		
		return null;
	}

}
