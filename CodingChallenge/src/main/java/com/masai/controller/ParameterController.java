package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Parameter;
import com.masai.service.ParameterService;

@RestController
@RequestMapping("/parameter")
public class ParameterController {

	@Autowired
	private ParameterService pService;
	
	@PostMapping("/")
	public ResponseEntity<Parameter> saveParameterHandler(@RequestBody Parameter parameter) {
		
		Parameter savedParameter =  pService.saveParameter(parameter);		
		
		return new ResponseEntity<Parameter>(savedParameter,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/{category}")
	public ResponseEntity<Parameter> getCatagoryHandler(@PathVariable("category") String category) {
		
		Parameter savedParameter =  pService.findByCategory(category);	
		
		return new ResponseEntity<Parameter>(savedParameter,HttpStatus.CREATED);
		
	}
	
}
