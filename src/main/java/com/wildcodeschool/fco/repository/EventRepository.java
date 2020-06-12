package com.wildcodeschool.fco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	
	@Query("SELECT e FROM Event e WHERE e.date < NOW() ORDER BY e.date DESC")
	List<Event> pastByDate();
	
	@Query("SELECT e FROM Event e WHERE e.date >= NOW() ORDER BY e.date ASC")
	List<Event> incommingByDate();
	
}
