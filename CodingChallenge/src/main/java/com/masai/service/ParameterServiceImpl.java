package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Parameter;
import com.masai.exception.ParameterNotFound;
import com.masai.repository.ParameterDao;

@Service
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	private ParameterDao pDao;
	
	
	@Override
	public Parameter saveParameter(Parameter parameter) throws ParameterNotFound {
		
		 Optional<Parameter> opt = pDao.findById(parameter.getId());
		 
		 if(opt.isPresent())
		 {
			 throw new ParameterNotFound("Details are present alraedy");
		 }
		 else
		 {
			 return pDao.save(opt.get());
		 }
		
		
	}

	@Override
	public Parameter findByCategory(String category) throws ParameterNotFound {
		
		
		Parameter parameter = pDao.findByCategory(category);
		
		if(parameter !=null)
		{
			return parameter;
		}
		else
		{
			throw new ParameterNotFound("Details not present");
		}
		
	}

}
