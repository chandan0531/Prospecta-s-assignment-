package com.masai.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ParameterNotFound.class)
	public ResponseEntity<MyError> departmentException(ParameterNotFound dr, WebRequest wr){
		
		
		MyError er = new MyError();
		er.setDate(LocalDate.now());
		er.setMessage(dr.getMessage());
		er.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyError>(er, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> noHandlerException(NoHandlerFoundException nh, WebRequest wr){
		
		
		MyError er = new MyError();
		er.setDate(LocalDate.now());
		er.setMessage(nh.getMessage());
		er.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyError>(er, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> myexceptionException(Exception ex, WebRequest wr){
		
		
		MyError er = new MyError();
		er.setDate(LocalDate.now());
		er.setMessage(ex.getMessage());
		er.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyError>(er, HttpStatus.BAD_REQUEST);
	}
	
	
	
}
