package com.rvrsmo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvrsmo.services.PersonServices;

@RestController
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@RequestMapping
	public Double sum() {
		return 0D; 
	}
	
	
}
