package com.masai.exception;

public class ParameterNotFound extends RuntimeException{

	public ParameterNotFound() {
		
	}
	
	public ParameterNotFound(String message) {
		super(message);
	}
}
