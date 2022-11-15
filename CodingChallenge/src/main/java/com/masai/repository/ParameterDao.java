package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Parameter;


@Repository
public interface ParameterDao extends JpaRepository<Parameter,Integer>{

	public Parameter findByCategory(String category);
	
}
