package com.wildcodeschool.fco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.wildcodeschool.fco.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	

	public List<Client> findByIsValid (Boolean isValid);


}
