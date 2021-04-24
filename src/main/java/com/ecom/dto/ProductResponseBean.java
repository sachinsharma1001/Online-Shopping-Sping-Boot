package com.ecom.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseBean {

	private String status;

	@JsonProperty("total_record")
	private Integer totalRecord;

	@JsonProperty("page_count")
	private Integer pageCount;

	@JsonProperty("page_per_record")
	private Integer pagePerRecord;

	@JsonProperty("data")
	private ProductRequestBean productRequestBean;

	private List<ProductRequestBean> productList;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPagePerRecord() {
		return pagePerRecord;
	}

	public void setPagePerRecord(int pagePerRecord) {
		this.pagePerRecord = pagePerRecord;
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

}
