package com.rvrsmo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvrsmo.data.vo.v1.PersonVO;
import com.rvrsmo.exception.ResourceNotFoundException;
import com.rvrsmo.repositories.PersonRepository;

@Service
public class PersonServices {
	
	
	private Logger logger = Logger
			.getLogger(PersonServices.class.getName());
	
	
	@Autowired
	PersonRepository repository;
	
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating one person!");
		return repository.save(person); 
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating one person!");
		
		PersonVO entity = repository.findById(person.getId())
			.orElseThrow(() ->
				new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person); 
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!"); 
		
		PersonVO entity = repository.findById(id)
				.orElseThrow(() ->
					new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
	
	public List<PersonVO> findAll() {
		
		logger.info("Finding all people");
		return repository.findAll();
	}
	

	public PersonVO findById(Long id) {
		logger.info("Finding one person!");
		
		PersonVO person = new PersonVO();
		person.setFirstName("Leandro");
		person.setLastName("Costa");
		person.setAddress("Uberlândia - MG");
		person.setGender("male");
		
		return repository.findById(id)
				.orElseThrow(() -> 
					new ResourceNotFoundException("No records found for this ID")); 
	}
	
	
	@SuppressWarnings("unused")
	private PersonVO mockPerson(int i) {
		PersonVO person = new PersonVO();
		// person.setId(counter.incrementAndGet());
		person.setFirstName("PersonVO name" + i);
		person.setLastName("Last name" + i);
		person.setAddress("Address" + i);
		if(i % 2 == 0) person.setGender("male");  else person.setGender("female");
		return person; 
	
	}



	

}
