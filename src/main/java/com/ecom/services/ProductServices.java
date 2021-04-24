package com.ecom.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.aspects.BadRequestException;
import com.ecom.dao.ProductRepository;
import com.ecom.dto.ProductRequestBean;
import com.ecom.dto.ProductResponseBean;
import com.ecom.entities.Product;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;

	public ProductResponseBean getAllProducts() {
		ProductResponseBean productResponseBean = new ProductResponseBean();
		List<ProductRequestBean> productRequestBeans = new ArrayList<>();

		List<Product> products = productRepository.findAll();
		products.forEach(p -> {
			ProductRequestBean bean = setProductResponse(p);
			productRequestBeans.add(bean);
		});

		productResponseBean.setProductList(productRequestBeans);
		return productResponseBean;
	}

	public ProductResponseBean getProductById(Long productId) throws BadRequestException {
		if (productId == 0) {
			throw new BadRequestException("id", "Id can not be 0");
		}

		ProductResponseBean productResponseBean = new ProductResponseBean();

		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			productResponseBean.setProductRequestBean(setProductResponse(product.get()));
		}

		return productResponseBean;
	}

	public void saveProduct(ProductRequestBean productRequestBean) {
		Product product = new Product();
		product.setActive(true);
		product.setCreatedDate(new Date());
		product.setDescription(productRequestBean.getDescription());
		product.setImageUrl(productRequestBean.getImageUrl());
		product.setName(productRequestBean.getName());
		product.setSku(productRequestBean.getSku());
		product.setUnitPrice(productRequestBean.getUnitPrice());
		product.setUnitsInStock(productRequestBean.getUnitsInStock());

		productRepository.save(product);
	}

	public void updateProduct(Long productId, ProductRequestBean productRequestBean) throws BadRequestException {
		if (productId == 0) {
			throw new BadRequestException(403, "Product Id can not be 0", "", new Date(), "");
		}
		Optional<Product> optProduct = productRepository.findById(productId);

		if (optProduct.isPresent()) {
			Product product = new Product();
			product.setId(productId);
			product.setActive(true);
			product.setCreatedDate(new Date());
			product.setDescription(productRequestBean.getDescription());
			product.setImageUrl(productRequestBean.getImageUrl());
			product.setName(productRequestBean.getName());
			product.setSku(productRequestBean.getSku());
			product.setUnitPrice(productRequestBean.getUnitPrice());
			product.setUnitsInStock(productRequestBean.getUnitsInStock());

			productRepository.save(product);
		} else {
			throw new BadRequestException(403, "Product Id not found", "", new Date(), "");
		}
	}

	public void deleteProduct(Long productId) {
		Optional<Product> optProduct = productRepository.findById(productId);
		if (optProduct.isPresent()) {
			productRepository.delete(optProduct.get());
		}
	}

	private ProductRequestBean setProductResponse(Product product) {
		ProductRequestBean requestBean = new ProductRequestBean();

		requestBean.setId(product.getId());
		requestBean.setSku(product.getSku());
		requestBean.setDescription(product.getDescription());
		requestBean.setImageUrl(product.getImageUrl());
		requestBean.setName(product.getName());
		requestBean.setUnitPrice(product.getUnitPrice());
		requestBean.setUnitsInStock(product.getUnitsInStock());
		requestBean.setUpdatedDate(product.getUpdatedDate());
		requestBean.setCreatedDate(product.getCreatedDate());

		return requestBean;
	}

}
