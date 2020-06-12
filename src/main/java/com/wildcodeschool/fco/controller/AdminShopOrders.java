package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.fco.entity.Client;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.MessageRepository;

@Controller
@Secured(value = {"ROLE_SUPERADMIN", "ROLE_ADMIN"})
public class AdminShopOrders {
	
    @Autowired
    private ClientRepository clientRepository;
    
	@Autowired
	private MessageRepository messageRepository;
    
	@GetMapping("/admin/adminOrders")
	public String showOrder(Model model) {
		model.addAttribute("messageCount", messageRepository.count()); 
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("listOfClientsNotValid", clientRepository.findByIsValid(false));
		model.addAttribute("listOfClientsValid", clientRepository.findByIsValid(true));
		return "adminOrders";
	}
	@GetMapping("/admin/adminOrders/delete")
	public String deleteOrder(@RequestParam Long id) {
		clientRepository.delete(clientRepository.getOne(id));
		return "redirect:/admin/adminOrders";
	}
	
	@GetMapping("/admin/adminOrders/valid")
	public String validOrder(@RequestParam long id) {
		Client client = clientRepository.getOne(id);
		client.setIsValid(true);
		clientRepository.save(client);
		return "redirect:/admin/adminOrders";
	}
	
	
}
