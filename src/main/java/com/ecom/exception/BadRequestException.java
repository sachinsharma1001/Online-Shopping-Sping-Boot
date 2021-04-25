package com.ecom.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadRequestException extends Exception {

	private static final long serialVersionUID = 6979071006628872160L;

	@JsonProperty("status_code")
	private int statusCode;

	@JsonProperty("field_name")
	private String fieldName;

	private String description;

	@JsonProperty("timestamp")
	private Date timeStamp;
	private String uri;

	public BadRequestException(String fieldName, String description) {
		super();
		this.fieldName = fieldName;
		this.description = description;
	}

	public BadRequestException(int statusCode, String fieldName, String description, Date timeStamp, String uri) {
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
