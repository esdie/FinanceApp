package com.oracle.advice;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.oracle.dto.ApiError;
import com.oracle.exception.LoanApplicationException;

//Act as catch block for the entire app
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(LoanApplicationException.class)
	public ResponseEntity<ApiError> handleException(Exception e) {
		ApiError error=new ApiError();
		error.setError(e.getMessage());
		error.setStatusCode(404);
		return 
				new ResponseEntity<ApiError>
		(error, HttpStatusCode.valueOf(404));
	}
}

