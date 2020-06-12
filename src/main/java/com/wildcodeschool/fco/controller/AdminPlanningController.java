package com.wildcodeschool.fco.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wildcodeschool.fco.entity.Training;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.repository.TeamRepository;
import com.wildcodeschool.fco.repository.TrainingRepository;

@Controller
public class AdminPlanningController {
	
    @Autowired
    private ClientRepository clientRepository;

	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	
	@GetMapping("/admin/team/{id}/planning")
	public String showPlanAdmin(@PathVariable Integer id, Model model) {
        Training training = new Training();
        if (id != null) {
        	Optional<Training> optional = trainingRepository.findById(id);
        	if (optional.isPresent()) {
        		training = optional.get();
        	}
        }
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size());
		model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("team", teamRepository.findById(id).get());
	    model.addAttribute("planning", training);
	    
		return "practicePlanning";		
	}
	
	@PostMapping("/admin/team/{id}/planning")
	public String postUpdatePlanning(@ModelAttribute Training training,@PathVariable Integer id) {
		trainingRepository.save(training);
		return "redirect:/admin/team";
	}
	
	@GetMapping("/admin/team/{id}/planning/delete")
	public String removePlanning(@PathVariable Integer teamId) {
		Integer id = teamRepository.findById(teamId).get().getTraining().getId();
		trainingRepository.deleteById(id);
		return "redirect:/admin/team/update/planning";
	}
}
