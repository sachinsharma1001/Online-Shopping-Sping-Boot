package com.ecom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCategoryRequestBean {

	private Long id;

	@JsonProperty("category_name")
	private String categoryName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
