package com.rvrsmo.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.rvrsmo.data.vo.v2.PersonVOV2;
import com.rvrsmo.model.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVO(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		
		vo.setId(person.getId());
		vo.setFirstName(person.getLastName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		vo.setAddress(person.getAddress());
		vo.setBirthday(new Date());
		
		return vo;		
	}
	
	public Person convertVOtoEntity(PersonVOV2 vo) {
		Person entity = new Person();
		
		entity.setId(vo.getId());
		entity.setFirstName(vo.getLastName());
		entity.setLastName(vo.getLastName());
		entity.setGender(vo.getGender());
		entity.setAddress(vo.getAddress());
		
		return entity;		
	}	
}
