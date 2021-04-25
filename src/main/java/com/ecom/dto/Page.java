package com.ecom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Page {

	@JsonProperty("total_record")
	private Integer totalRecord;

	@JsonProperty("page_count")
	private Integer pageCount;

	@JsonProperty("page_per_record")
	private Integer pagePerRecord;

	@JsonProperty("page")
	private Integer page;

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPagePerRecord() {
		return pagePerRecord;
	}

	public void setPagePerRecord(Integer pagePerRecord) {
		this.pagePerRecord = pagePerRecord;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

}
