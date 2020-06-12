package com.wildcodeschool.fco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	List<Team> findByPoleName(String poleName);
	
}
