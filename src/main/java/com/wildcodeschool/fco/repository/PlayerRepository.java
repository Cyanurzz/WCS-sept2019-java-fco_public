package com.wildcodeschool.fco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Convocation;
import com.wildcodeschool.fco.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
	Player findByTeamName(String teamName);
	
	List<Player> findByConvocation(Convocation convocation);

	List<Player> findByFirstnameContainingIgnoreCase(String search);
	
	List<Player> findByLastnameContainingIgnoreCase(String search);
}
