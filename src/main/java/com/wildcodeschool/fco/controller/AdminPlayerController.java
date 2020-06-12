package com.wildcodeschool.fco.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Player;
import com.wildcodeschool.fco.entity.Team;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.repository.PlayerRepository;
import com.wildcodeschool.fco.repository.TeamRepository;
import com.wildcodeschool.fco.service.FileUpload;

@Controller
public class AdminPlayerController {

  @Autowired
  private ClientRepository clientRepository;

	private String DIR = "photoJoueur";

	@Autowired
	private FileUpload fileUpload;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/admin/player")
	public String toPlayerAdmin(Model model, @RequestParam (required = false) String search) {
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("messageCount", messageRepository.count());
		if (search == null)
			model.addAttribute("players", playerRepository.findAll());
		else {
			List<Player> players = playerRepository.findByLastnameContainingIgnoreCase(search);
			players.addAll(playerRepository.findByFirstnameContainingIgnoreCase(search));
			model.addAttribute("players", players);
		}
		return "adminPlayer";
	}
	
	@GetMapping("/admin/player/delete{id}")
	public String removePlayer(RedirectAttributes redirAttrs, @PathVariable Integer id) {
		Player playerToDelete = playerRepository.findById(id).get();
		fileUpload.deleteFile(playerToDelete.getPhoto());
		playerRepository.delete(playerToDelete);
		redirAttrs.addFlashAttribute("successMessage", "Le joueur a bien été supprimé.");
		return "redirect:/admin/player";
	}
	
	@GetMapping("/admin/player/update")
	public String toPlayerUpdate(@RequestParam(required = false) Integer id, Model model) {
		Player player = new Player();
        if (id != null) {
        	Optional<Player> optionalPlayer = playerRepository.findById(id);
        	if (optionalPlayer.isPresent()) {
        		player = optionalPlayer.get();
        	}
        }
        model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
        model.addAttribute("messageCount", messageRepository.count());
        model.addAttribute("player", player);
        model.addAttribute("teams", teamRepository.findAll());
		
		return "adminPlayerUpdate";
	}
	
	@PostMapping("/admin/player/update")
	public String updatePlayer(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("firstname")String firstname,
			@RequestParam ("lastname") String lastname,
			@RequestParam (name = "role", required = false) String role,
			@RequestParam (name = "number", required = false) Integer number,
			@RequestParam ("team") Team team,
			@RequestParam (name = "photo", required = false) MultipartFile imageFile,
			@RequestParam String category,
			@RequestParam String phoneNumber
			) {
		String path = "";
		if (id != null) {
			path = playerRepository.findById(id).get().getPhoto();
		}
		if (!imageFile.isEmpty()) {
			String fileName = "player_" + firstname.toLowerCase() + "_" + lastname.toLowerCase();
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Player player = new Player(id, firstname, lastname, role, number, path, phoneNumber, category, team);
		playerRepository.save(player);
		
		if (id != null) {
			redirAttrs.addFlashAttribute("successMessage", "Le joueur a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "Le joueur a bien été ajouté.");
		}
		return "redirect:/admin/player";
	}
	
	@GetMapping("/admin/player/deleteFromTeam{id}")
	public String removePlayerFromTeam(RedirectAttributes redirAttrs, @PathVariable Integer id) {
		Player playerToDeleteFromTeam = playerRepository.findById(id).get();
		playerToDeleteFromTeam.setTeam(null);
		playerRepository.save(playerToDeleteFromTeam);
		redirAttrs.addFlashAttribute("successMessage", "Le joueur a bien été supprimé de l'équipe.");
		return "redirect:/admin/team";
	}
	
}
