package com.wildcodeschool.fco.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Message;
import com.wildcodeschool.fco.repository.ContactRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;

@Controller
public class ContactController {

	@Autowired
	private SponsorRepository sponsorRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping("/contact")
	public String toCatalog(Model model) {
		model.addAttribute("contact", contactRepository.findById(1).get());
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		return "contact";
	}
	
	@PostMapping("/contact")
	public String getMessage(RedirectAttributes redirAttrs, @ModelAttribute Message message) {
		message.setDate(new Date());
		messageRepository.save(message);
		redirAttrs.addFlashAttribute("successMessage", "Votre message a bien été envoyé !");
		return "redirect:/contact";
	}

}
