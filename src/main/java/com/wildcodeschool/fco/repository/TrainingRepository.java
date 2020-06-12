package com.wildcodeschool.fco.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.wildcodeschool.fco.entity.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer>{
	
	
}
