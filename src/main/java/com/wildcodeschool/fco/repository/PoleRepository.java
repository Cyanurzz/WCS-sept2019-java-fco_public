package com.wildcodeschool.fco.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Pole;

@Repository
public interface PoleRepository extends JpaRepository<Pole, Integer> {
	Pole findByName(String name);
	
	
}
