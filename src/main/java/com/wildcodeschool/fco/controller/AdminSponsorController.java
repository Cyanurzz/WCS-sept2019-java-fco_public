package com.wildcodeschool.fco.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Sponsor;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;
import com.wildcodeschool.fco.service.FileUpload;

@Controller
public class AdminSponsorController {
	

	@Autowired
	private ClientRepository clientRepository;

	private String DIR = "photoSponsor";


	@Autowired
	private FileUpload fileUpload;

	@Autowired
	private SponsorRepository sponsorRepository;
	
	@Autowired
	private MessageRepository messageRepository;

	@GetMapping("/admin/sponsor")
	public String toSponsorPage(Model model) {
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		return "adminSponsor";

	}
	
	@GetMapping("/admin/sponsor/delete{id}")
	public String removeSponsor(RedirectAttributes redirAttrs, @PathVariable Integer id) {
		Sponsor sponsorToDelete = sponsorRepository.findById(id).get();
		fileUpload.deleteFile(sponsorToDelete.getUrlPhoto());
		sponsorRepository.delete(sponsorToDelete);
		redirAttrs.addFlashAttribute("successMessage", "Le partenaire a bien été supprimé.");
		return "redirect:/admin/sponsor";
	}
	
	@GetMapping("/admin/sponsor/update")
	public String updateSponsor(Model model, @RequestParam(required = false) Integer id) {
        Sponsor sponsor = new Sponsor();
        if (id != null) {
        	Optional<Sponsor> optionalSponsor = sponsorRepository.findById(id);
        	if (optionalSponsor.isPresent()) {
        		sponsor = optionalSponsor.get();
        	}
        }
        model.addAttribute("messageCount", messageRepository.count());
        model.addAttribute("sponsor", sponsor);
		return "adminSponsorUpdate";
	}
	
	@PostMapping("/admin/sponsor/update")
	public String postSponsor(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("name") String name,
			@RequestParam ("urlPageSponsor") String sponsorLink,
			@RequestParam ("priority") Integer priority,
			@RequestParam ("urlPhoto") MultipartFile imageFile
			) {
		String path = "";
		if (id != null) {
			path = sponsorRepository.findById(id).get().getUrlPhoto();
		}
		if (!imageFile.isEmpty()) {
			String fileName = "sponsor_" + name.toLowerCase();
			path =fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Sponsor sponsor = new Sponsor(id, name, sponsorLink, path, priority);
		sponsorRepository.save(sponsor);
		if (id != null) {
			redirAttrs.addFlashAttribute("successMessage", "Le partenaire a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "Le partenaire a bien été ajouté.");
		}
		return "redirect:/admin/sponsor";
	}
	
}
