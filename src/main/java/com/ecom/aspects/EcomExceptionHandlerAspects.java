package com.ecom.aspects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EcomExceptionHandlerAspects extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ErrorValidation> list = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			list.add(new ErrorValidation(fieldName, errorMessage));
		});

		return new ResponseEntity<>(list, status);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> handleBadRequestExceptions(BadRequestException ex, WebRequest request) {
		ErrorValidation errorValidation = new ErrorValidation(ex.getFieldName(), ex.getDescription());
		return new ResponseEntity<>(errorValidation, HttpStatus.BAD_REQUEST);
	}

}
