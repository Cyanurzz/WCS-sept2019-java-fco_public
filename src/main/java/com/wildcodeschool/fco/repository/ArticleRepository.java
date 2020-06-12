package com.wildcodeschool.fco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{
	

	@Query("SELECT a FROM Article a WHERE a.priority = ?1 ORDER BY a.date DESC")
	List<Article> findRecentByPriority(int priority);
	
	List<Article> findAllByOrderByDateDesc();
}
