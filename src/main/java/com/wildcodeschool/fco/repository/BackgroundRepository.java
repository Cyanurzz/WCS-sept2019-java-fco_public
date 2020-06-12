package com.wildcodeschool.fco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Background;

@Repository
public interface BackgroundRepository extends JpaRepository<Background, Integer> {
	
	Background findByName(String name);
	
}
