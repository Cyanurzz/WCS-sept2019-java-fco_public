package com.wildcodeschool.fco.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Team;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.ConvocationRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.repository.PlayerRepository;
import com.wildcodeschool.fco.repository.PoleRepository;
import com.wildcodeschool.fco.repository.TeamRepository;
import com.wildcodeschool.fco.service.FileUpload;

@Controller
public class AdminTeamController {
	
	private String DIR = "photoEquipe";
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private FileUpload fileUpload;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PoleRepository poleRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ConvocationRepository convocationRepository;
	
	@Autowired
	private PlayerRepository playerRepository ;
	@GetMapping("/admin/team")
	public String toTeamAdmin(Model model) {
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
	 	model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("teams", teamRepository.findAll());
		return "adminTeam";
	}
	
	@GetMapping("/admin/team/delete{id}")
	private String removeTeam(RedirectAttributes redirAttrs, @PathVariable Integer id) {
		Team teamToDelete = teamRepository.findById(id).get();
		fileUpload.deleteFile(teamToDelete.getImage());
		teamRepository.delete(teamToDelete);
		redirAttrs.addFlashAttribute("successMessage", "L'équipe a bien été supprimée.");
		return "redirect:/admin/team";
	}
	
	@GetMapping("/admin/team/{id}")
 	public String toTeamUpdate(Model model,@PathVariable Integer id) {
		Team team = teamRepository.findById(id).get(); 
		if (convocationRepository.findAll().size() > 0) {
			if(!convocationRepository.findById(id).isEmpty() ) {
			model.addAttribute("listConvocation", playerRepository.findByConvocation(convocationRepository.getOne(id)));
			model.addAttribute("dateMatch", convocationRepository.getOne(id).getDateMatch());
		}
		}
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("poles", poleRepository.findAll());
		model.addAttribute("team", team);
		model.addAttribute("players", team.getPlayers());
		model.addAttribute("planning", team.getTraining());
		model.addAttribute("localDateTime", LocalDateTime.now());
		
		return "adminTeamUpdate";
	}
	
	@PostMapping("/admin/team/{id}")
	public String teamUpdate(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("name") String name,
			@RequestParam (name = "image", required = false) MultipartFile imageFile,
			@RequestParam ("pole") Integer poleId 
			) {
		String path = teamRepository.findById(id).get().getImage();
		if (!imageFile.isEmpty()) {
			String fileName = "team_" + name.toLowerCase();
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Team team = new Team(id, name, path, poleRepository.findById(poleId).get());
		teamRepository.save(team);
		redirAttrs.addFlashAttribute("successMessage", "L'équipe a bien été modifié.");

		return "redirect:/admin/team/" + id;
	}
	
	@GetMapping("/admin/team/create")
	public String toCreateTeam(Team team, Model model) {
	     	model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
        	model.addAttribute("messageCount", messageRepository.count());
        	model.addAttribute("poles", poleRepository.findAll());

		return "adminTeamCreate";
	}
	
	@PostMapping("/admin/team/create")
	public String createTeam(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("name") String name,
			@RequestParam (name = "image", required = false) MultipartFile imageFile,
			@RequestParam ("pole") Integer poleId 
			) {
		String path = "";
		if (!imageFile.isEmpty()) {
			String fileName = "team_" + name.toLowerCase();
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Team team = new Team(id, name, path, poleRepository.findById(poleId).get());
		teamRepository.save(team);
		redirAttrs.addFlashAttribute("successMessage", "L'équipe a bien été ajouté.");

		
		return "redirect:/admin/team";
	}

}
