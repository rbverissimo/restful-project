package com.rvrsmo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvrsmo.data.vo.v1.PersonVO;
import com.rvrsmo.exception.ResourceNotFoundException;
import com.rvrsmo.mapper.DozerMapper;
import com.rvrsmo.model.Person;
import com.rvrsmo.repositories.PersonRepository;

@Service
public class PersonServices {
	
	
	private Logger logger = Logger
			.getLogger(PersonServices.class.getName());
	
	
	@Autowired
	PersonRepository repository;
	
	
	public PersonVO create(PersonVO personVO) {
		logger.info("Creating one person!");
		
		var entity = DozerMapper.parseObject(personVO, Person.class);
		
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class); 
		
		return vo;
	}
	
	public PersonVO update(PersonVO personVO) {
		logger.info("Updating one person!");
		
		var entity = repository.findById(personVO.getId())
			.orElseThrow(() ->
				new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(personVO.getFirstName());
		entity.setLastName(personVO.getLastName());
		entity.setAddress(personVO.getAddress());
		entity.setGender(personVO.getGender());
		
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class); 
		
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!"); 
		
		var entity = repository.findById(id)
				.orElseThrow(() ->
					new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
	
	public List<PersonVO> findAll() {
		
		logger.info("Finding all people");
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}
	

	public PersonVO findById(Long id) {
		logger.info("Finding one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> 
					new ResourceNotFoundException("No records found for this ID")); 
		
		return DozerMapper.parseObject(entity, PersonVO.class);
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
