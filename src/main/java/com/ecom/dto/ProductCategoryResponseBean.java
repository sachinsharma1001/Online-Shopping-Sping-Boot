package com.ecom.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCategoryResponseBean {

	private Boolean status;

	@JsonProperty("data")
	private ProductCategoryRequestBean categoryRequestBean;

	@JsonProperty("page")
	private Page page;

	private List<ProductCategoryRequestBean> categoryRequestBeanList;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ProductCategoryRequestBean getCategoryRequestBean() {
		return categoryRequestBean;
	}

	public void setCategoryRequestBean(ProductCategoryRequestBean categoryRequestBean) {
		this.categoryRequestBean = categoryRequestBean;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<ProductCategoryRequestBean> getCategoryRequestBeanList() {
		return categoryRequestBeanList;
	}

	public void setCategoryRequestBeanList(List<ProductCategoryRequestBean> categoryRequestBeanList) {
		this.categoryRequestBeanList = categoryRequestBeanList;
	}

}
