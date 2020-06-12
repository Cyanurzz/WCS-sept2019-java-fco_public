package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.MessageRepository;

@Controller
@Secured(value = {"ROLE_SUPERADMIN", "ROLE_ADMIN"})
public class AdminMessageController {

	@Autowired
	private MessageRepository messageRepository;
	
	 @Autowired
	 private ClientRepository clientRepository;
	 
	@GetMapping("/admin/messages")
	public String toAdminMessage(Model model) {
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("messages", messageRepository.findAllByOrderByDateDesc());
		return "adminMessage";
	}
	
	@GetMapping("/admin/messages/delete{id}")
	public String removeMessage(RedirectAttributes redirAttrs, @PathVariable int id) {
		messageRepository.deleteById(id);
		redirAttrs.addFlashAttribute("successMessage", "Le message a bien été supprimé.");
		return "redirect:/admin/messages";
	}
}
