package com.rvrsmo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvrsmo.model.Person;
import com.rvrsmo.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger
			.getLogger(PersonServices.class.getName());
	
	
	@Autowired
	PersonRepository repository;
	
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return person; 
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		return person; 
	}
	
	public void delete(String id) {
		logger.info("Deleting one person!"); 
	}
	
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>(); 
		
		logger.info("Finding all people!!!");
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i); 
			persons.add(person);
			
		}
		
		return persons; 
	}
	

	public Person findById(String id) {
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leandro");
		person.setLastName("Costa");
		person.setAddress("Uberlândia - MG");
		person.setGender("male");
		
		return person; 
	}
	
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name" + i);
		person.setLastName("Last name" + i);
		person.setAddress("Address" + i);
		if(i % 2 == 0) person.setGender("male");  else person.setGender("female");
		return person; 
	
	}



	

}
