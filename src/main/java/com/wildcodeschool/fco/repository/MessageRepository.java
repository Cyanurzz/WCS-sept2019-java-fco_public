package com.wildcodeschool.fco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
	List<Message> findAllByOrderByDateDesc();
}
