package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.fco.entity.Event;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.EventRepository;
import com.wildcodeschool.fco.repository.MessageRepository;

@Controller
public class AdminController {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/admin")
	public String toAdmin(Model model) {
		int entrantCount = 0;
		for (Event event : eventRepository.findAll()) {
			entrantCount += event.getEntrants().size();
		}
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("eventCount", eventRepository.incommingByDate().size());
		model.addAttribute("shopReservationCount", clientRepository.findByIsValid(false).size());
		model.addAttribute("inscriptionCount", entrantCount);
		return "admin";
	}
	
}
