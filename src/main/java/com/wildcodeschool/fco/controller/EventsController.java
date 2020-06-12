package com.wildcodeschool.fco.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Entrant;
import com.wildcodeschool.fco.entity.Event;
import com.wildcodeschool.fco.repository.EntrantRepository;
import com.wildcodeschool.fco.repository.EventRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;

@Controller
public class EventsController {

	@Autowired
	private EventRepository eventsRepository;
	
	@Autowired
	private SponsorRepository sponsorRepository;
	
	@Autowired
	private EntrantRepository entrantRepository;
	
	@GetMapping("/events")
	public String toAllEvents(Model model) {
		model.addAttribute("events", eventsRepository.incommingByDate());
		model.addAttribute("pastEvents", eventsRepository.pastByDate());
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		
		return "events";
	}
	
	@GetMapping("/event/{id}")
	public String toEvent(@PathVariable("id") Integer id,  Model model) {
		Event event = eventsRepository.findById(id).get();
		model.addAttribute("entrant", new Entrant());
		model.addAttribute("event", event);
		model.addAttribute("places", event.getPlaces() - event.getEntrants().size());
		model.addAttribute("timeLeft", event.getDate().getTime() - new Date().getTime());
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		return "event";
	}
	
	@PostMapping("/event/{id}")
	public String inscriptionToEvent(@PathVariable int id, @Valid Entrant entrant, BindingResult result, RedirectAttributes redirAttrs, Model model) {
		Event event = eventsRepository.findById(id).get();
		if (result.hasErrors()) {
			model.addAttribute("hasErrors", true);
			model.addAttribute("entrant", entrant);
			model.addAttribute("event", event);
			model.addAttribute("places", event.getPlaces() - event.getEntrants().size());
			model.addAttribute("timeLeft", event.getDate().getTime() - new Date().getTime());
			model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
			return "event";
		} else {
			if (event.getPlaces() - event.getEntrants().size() > 0) {
				entrant.setEvent(event);
				entrantRepository.save(entrant);
				redirAttrs.addFlashAttribute("successMessage", "Vous avez bien été ajouté à la liste des inscrits.");
			} else {
				redirAttrs.addFlashAttribute("errorMessage", "Il n'est plus possible de s'inscrire.");
			}
		}
		return "redirect:/event/" + id;
	}
	
}
