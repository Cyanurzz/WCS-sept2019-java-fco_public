package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Background;
import com.wildcodeschool.fco.repository.BackgroundRepository;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.service.FileUpload;

@Controller
public class AdminBackgroundController {
	

	private String DEFAULT_IMAGE = "black.png";
	private String DIR = "backgrounds";
	
    @Autowired
    private ClientRepository clientRepository;

	@Autowired
	private FileUpload fileUpload;
	
	@Autowired
	private BackgroundRepository backgroundRepository;
	
	@GetMapping("/admin/backgrounds")
	public String toAdminBackground(Model model) {
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("backgrounds", backgroundRepository.findAll());
		return "adminBackground";
	}
	
	@PostMapping("/admin/backgrounds")
	public String changeBackground(RedirectAttributes redirAttrs, @RequestParam int id, @RequestParam MultipartFile imageFile) {
		Background background = backgroundRepository.findById(id).get();
		background.setPath(fileUpload.writeFile(imageFile, DIR, background.getName()));
		backgroundRepository.save(background);
		redirAttrs.addFlashAttribute("successMessage", "Le background a bien été modifié.");
		return "redirect:/admin/backgrounds";
	}
	
	@GetMapping("/admin/backgrounds/remove{id}")
	public String deleteBackground(RedirectAttributes redirAttrs, @PathVariable int id) {
		Background background = backgroundRepository.findById(id).get();
		background.setPath(fileUpload.replaceFile(background.getPath(), DIR, DEFAULT_IMAGE));
		redirAttrs.addFlashAttribute("successMessage", "Le background a bien été retiré.");
		return "redirect:/admin/backgrounds";
	}
	
}
