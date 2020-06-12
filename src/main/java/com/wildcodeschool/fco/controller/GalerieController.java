package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.fco.repository.GalerieRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;

@Controller
public class GalerieController {

	@Autowired
	private SponsorRepository sponsorRepository;
	
	@Autowired
	private GalerieRepository galerieRepository;
	
	@GetMapping("/galerie")
	public String showGalery(Model model) {
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		model.addAttribute("galerieList", galerieRepository.findAll());
		return "galerie";
	}
	
}
