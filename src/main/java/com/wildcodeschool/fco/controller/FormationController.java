package com.wildcodeschool.fco.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wildcodeschool.fco.entity.Team;
import com.wildcodeschool.fco.entity.Training;
import com.wildcodeschool.fco.repository.BackgroundRepository;
import com.wildcodeschool.fco.repository.PlayerRepository;
import com.wildcodeschool.fco.repository.PoleRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;
import com.wildcodeschool.fco.repository.TeamRepository;

@Controller
public class FormationController {
	
	@Autowired
	private BackgroundRepository backgroundRepository;

	@Autowired
	private SponsorRepository sponsorRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PoleRepository poleRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/pole/{poleName}")
	public String toPole(@PathVariable String poleName, Model model) {
		List<Team> teams = teamRepository.findByPoleName(poleName);
		List<Training> trainings = new ArrayList<>();
		for (Team team : teams) {
			trainings.add(team.getTraining());
		}
		
		model.addAttribute("backgroundPole", backgroundRepository.findByName("poles"));
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		model.addAttribute("teams", teamRepository.findByPoleName(poleName));
		model.addAttribute("pole", poleRepository.findByName(poleName));
		model.addAttribute("trainings", trainings);
		model.addAttribute("players", playerRepository.findAll());
		return "pole";
	}
	
	@GetMapping("/pole/{poleName}/{seniorName}")
	public String toSenior(@PathVariable String poleName, Model model, @PathVariable String seniorName) {
		model.addAttribute("teams", teamRepository.findByPoleName(poleName));
		model.addAttribute("pole", poleRepository.findByName(poleName));
		return "adminSeniors";
	}

}
