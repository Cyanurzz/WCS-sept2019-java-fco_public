package com.wildcodeschool.fco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Entrant;

@Repository
public interface EntrantRepository extends JpaRepository<Entrant, Integer> {

}
