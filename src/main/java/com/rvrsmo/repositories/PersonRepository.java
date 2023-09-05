package com.rvrsmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvrsmo.data.vo.v1.PersonVO;

public interface PersonRepository extends JpaRepository<PersonVO, Long>{}
