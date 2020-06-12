package com.wildcodeschool.fco.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Encounter;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.EncounterRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.service.FileUpload;
import com.wildcodeschool.fco.service.FormatDate;

@Controller
public class AdminMatchController {
	
	private String DEFAULT_FILE = "visitorLogo";
	private String DIR = "logoClub";
	
    @Autowired
    private ClientRepository clientRepository;
	
	@Autowired
	private FileUpload fileUpload;
	
	@Autowired
	private FormatDate formatDate;
	
	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private EncounterRepository encounterRepository;
	
	@GetMapping("/admin/next-match")
	public String toAdminNextMatch(Model model) {
		model.addAttribute("encounter", encounterRepository.findTopByOrderByTimeUntilMatchAsc());
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("messageCount", messageRepository.count());
		return "adminNextMatch";
	}
	
	@PostMapping("/admin/next-match")
	public String updateNextMatch(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("teamName") String teamName,
			@RequestParam ("teamDivision") String teamDivision,
			@RequestParam ("matchDate") String matchDate,
			@RequestParam ("matchHour") String matchHour,
			@RequestParam ("visitorName") String visitorName,
			@RequestParam ("visitorLogo") MultipartFile visitorLogo
			) {
		String path = fileUpload.writeFile(visitorLogo, DIR, DEFAULT_FILE);
		Date date = formatDate.dateAndTimeToFull(matchDate, matchHour);
		Long time = date.getTime();
		Encounter encounter = new Encounter(id, time, teamName, teamDivision, visitorName, path);
		encounterRepository.save(encounter);
		redirAttrs.addFlashAttribute("successMessage", "Le match a bien été modifié.");
		return "redirect:/admin/next-match";
	}
}
