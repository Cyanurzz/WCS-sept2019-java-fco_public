package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.fco.repository.CardRepository;
import com.wildcodeschool.fco.repository.ParagraphRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;



@Controller
public class HistoryController {
	
	@Autowired
	private ParagraphRepository paragraphRepository;
	
	@Autowired
	private CardRepository cardsRepository;
	
	@Autowired
	private SponsorRepository sponsorRepository;

	@GetMapping("/history")
	public String toHistoryPage(Model model) {
		model.addAttribute("paragraphs", paragraphRepository.findAll());
		model.addAttribute("cards", cardsRepository.findAll() );
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		return "histoire";
	}
}
