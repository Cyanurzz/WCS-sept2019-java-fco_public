package com.wildcodeschool.fco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Encounter;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter, Integer> {
	
	Encounter findTopByOrderByTimeUntilMatchAsc();

}
