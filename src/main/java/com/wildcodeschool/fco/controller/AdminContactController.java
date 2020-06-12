package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wildcodeschool.fco.entity.Contact;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.ContactRepository;

@Controller
public class AdminContactController {

	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private ClientRepository clientRepository;
	@GetMapping("/admin/contact")
	public String toContact(Model model) {
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("contact", contactRepository.findById(1).get());
		return "adminContact";
	}
	
	@PostMapping("/admin/contact")
	public String saveContact(Model model, @ModelAttribute Contact contact) {
		contactRepository.save(contact);
		model.addAttribute("successMessage", "Les informations de contact ont bien été mises à jour.");
		model.addAttribute("contact", contactRepository.findById(1).get());
		return "adminContact";
	}
}
