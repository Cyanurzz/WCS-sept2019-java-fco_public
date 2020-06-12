package com.wildcodeschool.fco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wildcodeschool.fco.entity.Sponsor;

	public interface SponsorRepository extends JpaRepository<Sponsor, Integer> {
		@Query("select s from Sponsor s order by priority")
		public List<Sponsor> sponsorSortByPriority ();

	}


