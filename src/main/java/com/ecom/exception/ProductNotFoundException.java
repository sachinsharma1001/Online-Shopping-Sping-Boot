package com.ecom.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = -1900652611695383604L;

	@JsonProperty("status_code")
	private int statusCode;

	@JsonProperty("field_name")
	private String fieldName;

	private String description;

	@JsonProperty("timestamp")
	private Date timeStamp;
	private String uri;

	public ProductNotFoundException(String fieldName, String description) {
		super();
		this.fieldName = fieldName;
		this.description = description;
	}

	public ProductNotFoundException(int statusCode, String fieldName, String description, Date timeStamp, String uri) {
		super();
		this.statusCode = statusCode;
		this.fieldName = fieldName;
		this.description = description;
		this.timeStamp = timeStamp;
		this.uri = uri;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
