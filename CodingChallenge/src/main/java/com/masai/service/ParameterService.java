package com.masai.service;

import com.masai.entities.Parameter;
import com.masai.exception.ParameterNotFound;

public interface ParameterService {

	
	public Parameter saveParameter(Parameter parameter)throws ParameterNotFound;
	
	public Parameter findByCategory(String category) throws ParameterNotFound ;
}
