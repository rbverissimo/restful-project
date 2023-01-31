package com.rvrsmo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvrsmo.exception.ResourceNotFoundException;
import com.rvrsmo.model.Person;
import com.rvrsmo.repositories.PersonRepository;

@Service
public class PersonServices {
	
	
	private Logger logger = Logger
			.getLogger(PersonServices.class.getName());
	
	
	@Autowired
	PersonRepository repository;
	
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return repository.save(person); 
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		
		Person entity = repository.findById(person.getId())
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
		
		Person entity = repository.findById(id)
				.orElseThrow(() ->
					new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
	
	public List<Person> findAll() {
		
		logger.info("Finding all people");
		return repository.findAll();
	}
	

	public Person findById(Long id) {
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setFirstName("Leandro");
		person.setLastName("Costa");
		person.setAddress("Uberlândia - MG");
		person.setGender("male");
		
		return repository.findById(id)
				.orElseThrow(() -> 
					new ResourceNotFoundException("No records found for this ID")); 
	}
	
	
	@SuppressWarnings("unused")
	private Person mockPerson(int i) {
		Person person = new Person();
		// person.setId(counter.incrementAndGet());
		person.setFirstName("Person name" + i);
		person.setLastName("Last name" + i);
		person.setAddress("Address" + i);
		if(i % 2 == 0) person.setGender("male");  else person.setGender("female");
		return person; 
	
	}



	

}
