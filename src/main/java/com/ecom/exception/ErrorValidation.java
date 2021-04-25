package com.ecom.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorValidation {

	@JsonProperty("field_name")
	private String fieldName;

	@JsonProperty("description")
	private String description;

	public ErrorValidation(String fieldName, String description) {
		this.fieldName = fieldName;
		this.description = description;
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

}
