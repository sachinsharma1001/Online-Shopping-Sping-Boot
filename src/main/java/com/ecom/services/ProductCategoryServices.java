package com.ecom.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.ProductCategoryRepository;
import com.ecom.dto.ProductCategoryRequestBean;
import com.ecom.dto.ProductCategoryResponseBean;
import com.ecom.entities.ProductCategory;

@Service
public class ProductCategoryServices {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public ProductCategoryResponseBean getAllProductCategory() {
		ProductCategoryResponseBean categoryResponseBean = new ProductCategoryResponseBean();

		List<ProductCategoryRequestBean> beans = new ArrayList<>();
		List<ProductCategory> productCategory = productCategoryRepository.findAll();
		productCategory.forEach(p -> {
			ProductCategoryRequestBean requestBean = new ProductCategoryRequestBean();
			requestBean.setId(p.getId());
			requestBean.setCategoryName(p.getCategoryName());

			beans.add(requestBean);
		});

		categoryResponseBean.setCategoryRequestBeanList(beans);
		return categoryResponseBean;
	}

	public ProductCategoryResponseBean getProductCategory(Long productCategoryId) {
		Optional<ProductCategory> categoryRequestBean = productCategoryRepository.findById(productCategoryId);
		ProductCategoryResponseBean responseBean = new ProductCategoryResponseBean();

		if (categoryRequestBean.isPresent()) {
			ProductCategory productCategory = categoryRequestBean.get();

			ProductCategoryRequestBean requestBean = new ProductCategoryRequestBean();
			requestBean.setId(productCategory.getId());
			requestBean.setCategoryName(productCategory.getCategoryName());
			responseBean.setCategoryRequestBean(requestBean);
		}

		return responseBean;
	}

	public void createProductCategory() {

	}

	public void updateProductCategory() {

	}

	public void deleteProductCategory() {

	}
}
