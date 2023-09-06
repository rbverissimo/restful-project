package com.rvrsmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvrsmo.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}
