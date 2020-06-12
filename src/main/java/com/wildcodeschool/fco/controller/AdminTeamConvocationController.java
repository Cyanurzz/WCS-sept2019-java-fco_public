package com.wildcodeschool.fco.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.fco.entity.Convocation;
import com.wildcodeschool.fco.entity.Player;
import com.wildcodeschool.fco.entity.Team;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.ConvocationRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.repository.PlayerRepository;
import com.wildcodeschool.fco.repository.PoleRepository;
import com.wildcodeschool.fco.repository.TeamRepository;
import com.wildcodeschool.fco.service.FormatDate;

@Controller
@Secured(value = {"ROLE_SUPERADMIN", "ROLE_ADMIN", "ROLE_EDUCATEUR"})
public class AdminTeamConvocationController {
	
	@Autowired
	 private ClientRepository clientRepository;
	
	@Autowired
	private FormatDate formatDate;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired 
	private ConvocationRepository convocationRepository;
	
	@Autowired
	private PoleRepository poleRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/admin/team/{id}/selection")
 	public String toSelection( Model model, Convocation convocation, @PathVariable Integer id) {
		
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size());
		Team team = teamRepository.findById(id).get();
		model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("poles", poleRepository.findAll());
		model.addAttribute("team", team);
		model.addAttribute("players", team.getPlayers());
		return "adminTeamSelection";
	}

	
	@PostMapping("/admin/team/{id}/selection")

 	public String postSelection( Model model, @RequestParam ("id") Integer id, @RequestParam (value="selection", required = false) Integer[] playerId) {
	
		for( int i = 0; i < playerId.length; i++) {
	        Player p =	playerRepository.getOne(playerId[i]);
	        p.setConvocation(convocationRepository.getOne(id));
	        playerRepository.save(p);
		}
		Team team = teamRepository.getOne(id);
		team.setConvocation(convocationRepository.getOne(id));
		teamRepository.save(team);

		return "redirect:/admin/team/{id}";
	}
	
	@GetMapping("/admin/team/{id}/meet")
 	public String toDateMeet( Model model, Convocation convocation, @PathVariable Integer id) {
		
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size());
		Team team = teamRepository.findById(id).get();
		model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("poles", poleRepository.findAll());
		model.addAttribute("team", team);
		model.addAttribute("players", team.getPlayers());
		return "adminTeamMeetDate";
	}
	
	@PostMapping("/admin/team/{id}/meet")
 	public String posteet( Model model, @RequestParam ("id") Integer id,
 					@RequestParam ("matchDate") String matchDate,
 					@RequestParam ("matchHour") String matchHour, 
 					@RequestParam ("inviteDate") String inviteDate,
 					@RequestParam ("inviteHour") String inviteHour,
 					@RequestParam String locationM, 
					@RequestParam String locationI) {
		
		Date dateMatch = formatDate.dateAndTimeToFull(matchDate, matchHour);
		Date dateInvite = formatDate.dateAndTimeToFull(inviteDate, inviteHour);
		Convocation convocation = new Convocation(id, dateMatch, dateInvite, locationM, locationI);
		convocation = convocationRepository.save(convocation);

		return "redirect:/admin/team/{id}";
	}
	
	@GetMapping("/admin/player/invite/delete")
	public String deletePlayerInveted(@RequestParam Integer idPlayer, @RequestParam Integer idTeam) {
		Player p = playerRepository.getOne(idPlayer);
		p.setConvocation(null);
		playerRepository.save(p);
		return "redirect:/admin/team/"+idTeam;
	}
	
}
	
