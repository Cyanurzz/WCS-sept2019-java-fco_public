package com.wildcodeschool.fco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Convocation;

@Repository
public interface ConvocationRepository extends JpaRepository<Convocation, Integer> {
	
}
