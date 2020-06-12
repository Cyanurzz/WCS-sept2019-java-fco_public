package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.fco.repository.SponsorRepository;

@Controller
public class SponsorController {

	@Autowired
	private SponsorRepository sponsorRepository;
	
	@GetMapping("/sponsor")
	public String sponsorPagePublic(Model model) {
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		return "sponsorPage";
	}
	
	
}