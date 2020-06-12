package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.fco.entity.User;
import com.wildcodeschool.fco.repository.SponsorRepository;
import com.wildcodeschool.fco.repository.UserRepository;

@Controller
public class ProfilController {
	
	@Autowired
	private SponsorRepository sponsorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	@GetMapping("/profil")
	public String toProfil(Model model) {
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		model.addAttribute("user", userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
		return "profil";
	}
	
	@PostMapping("/profil")
	@PreAuthorize("hasRole('READ_PRIVILEGE')")
	public String updatePassword(
			Model model,
			@RequestParam("password") String password,
			@RequestParam("passwordValid") String passwordValid,
			@RequestParam("oldPassword") String oldPassword
			) {
		User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		
		if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
			model.addAttribute("errorMessage", "Le mot de passe rentré est incorrect.");
		} else if (!password.equals(passwordValid)) {
			model.addAttribute("errorMessage", "Les deux champs ne correspondent pas.");
		} else {
			user.setPassword(passwordEncoder.encode(password));
			userRepository.save(user);
			model.addAttribute("successMessage", "Le mot de passe a bien été mis à jour.");
		}
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		model.addAttribute("user", userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
		return "profil";
	}
	
}
