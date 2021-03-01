package com.anurag.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.anurag.exception.RequiredNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

	
	@ExceptionHandler(RequiredNotFoundException.class)
public ResponseEntity<String> handleRequiredNotFound(RequiredNotFoundException rnfe){
		
		return  new ResponseEntity<String>(rnfe.getMessage(), HttpStatus.NOT_FOUND);
	}
}
