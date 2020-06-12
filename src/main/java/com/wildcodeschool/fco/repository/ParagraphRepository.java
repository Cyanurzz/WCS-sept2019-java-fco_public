package com.wildcodeschool.fco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Paragraph;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, Integer> {
	public List<Paragraph> findAll();
}
