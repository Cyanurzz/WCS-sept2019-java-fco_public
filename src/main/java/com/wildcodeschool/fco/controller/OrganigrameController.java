package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.fco.repository.BackgroundRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;
import com.wildcodeschool.fco.repository.StaffRepository;

@Controller
public class OrganigrameController {
	
	@Autowired
	private BackgroundRepository backgroundRepository;

	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private SponsorRepository sponsorRepository;
	
	
	@GetMapping("/organizationalChart")
	public String toOrganigrammePage(Model model) {
		model.addAttribute("backgroundOrga", backgroundRepository.findByName("organigramme"));
		model.addAttribute("members", staffRepository.findAll());
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		return "organigramme";
	}
}
