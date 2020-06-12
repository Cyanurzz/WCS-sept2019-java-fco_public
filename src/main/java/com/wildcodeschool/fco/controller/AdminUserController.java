package com.wildcodeschool.fco.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.User;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.repository.UserRepository;

@Controller
public class AdminUserController {
	
    @Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/admin/user")
	public String showUserPageAdmin(Model model) {
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size());
		model.addAttribute("messageCount", messageRepository.count());
	    model.addAttribute("user", userRepository.findAll());
		return "adminUser";
	}
	
	@GetMapping("/admin/user/delete{id}")
	public String deleteUser(RedirectAttributes redirAttrs, @PathVariable Long id, Model model) {
		if (id == 1) {
			redirAttrs.addFlashAttribute("errorMessage", "Cet utilisateur ne peut pas être supprimé !");
		} else {
			userRepository.deleteById(id);
			redirAttrs.addFlashAttribute("successMessage", "L'utilisateur a bien été supprimé.");
		}
		return "redirect:/admin/user";
	}
	
	@GetMapping("/admin/user/update")
	public String showUserForUpdate(Model model, @RequestParam (required = false) Long id) {
        User user = new User();
        if (id != null) {
        	Optional<User> optionalUser = userRepository.findById(id);
        	if (optionalUser.isPresent()) {
        		user = optionalUser.get();
        	}
        }
        model.addAttribute("messageCount", messageRepository.count());
        model.addAttribute("user", user);
		return "adminUserUpdate";
	}
	
	@PostMapping("/admin/user/update")
	public String updateUser(RedirectAttributes redirAttrs, @ModelAttribute User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		if (user.getId() != null) {
			redirAttrs.addFlashAttribute("successMessage", "L'utilisateur a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "L'utilisateur a bien été ajouté.");
		}
		return "redirect:/admin/user";
	}
	
}
