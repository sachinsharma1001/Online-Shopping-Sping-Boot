package com.ecom.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseBean {

	private Boolean status;

//	@JsonProperty("data")
	private ProductRequestBean productRequestBean;

	@JsonProperty("page")
	private Page page;

	@JsonProperty("data")
	private List<ProductRequestBean> productList;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ProductRequestBean getProductRequestBean() {
		return productRequestBean;
	}

	public void setProductRequestBean(ProductRequestBean productRequestBean) {
		this.productRequestBean = productRequestBean;
	}

	public List<ProductRequestBean> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductRequestBean> productList) {
		this.productList = productList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
