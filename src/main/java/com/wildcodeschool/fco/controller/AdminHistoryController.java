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

import com.wildcodeschool.fco.entity.Card;
import com.wildcodeschool.fco.entity.Paragraph;
import com.wildcodeschool.fco.repository.CardRepository;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.ParagraphRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.service.FileUpload;

@Controller
public class AdminHistoryController {
	
	private String DIR = "photoHistoire";

	@Autowired
	private FileUpload fileUpload;
	
	@Autowired
	private ParagraphRepository paragraphRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
    @Autowired
    ClientRepository clientRepository;
    
	@GetMapping("/admin/history")
	public String toAdminHistory(Model model) {
		model.addAttribute("paragraphs", paragraphRepository.findAll());
		model.addAttribute("cards", cardRepository.findAll());
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("messageCount", messageRepository.count());
		return "adminHistoire";
	}
	
	@GetMapping("/admin/history/paragraph/delete{id}")
	public String deleteParagraph(RedirectAttributes redirAttrs, @PathVariable Integer id) {
		Paragraph paragraphToDelete = paragraphRepository.findById(id).get();
		fileUpload.deleteFile(paragraphToDelete.getPicture());
		paragraphRepository.delete(paragraphToDelete);
		redirAttrs.addFlashAttribute("successMessage", "Le paragraphe a bien été supprimé.");
		return "redirect:/admin/history";
	}
	
	@GetMapping("/admin/history/card/delete{id}")
	public String deleteCard(RedirectAttributes redirAttrs, @PathVariable Integer id) {
		Card cardToDelete = cardRepository.findById(id).get();
		fileUpload.deleteFile(cardToDelete.getPicture());
		cardRepository.delete(cardToDelete);
		redirAttrs.addFlashAttribute("successMessage", "Le paragraphe a bien été supprimé.");
		return "redirect:/admin/history";
	}
	
	@GetMapping("/admin/history/paragraph/update")
	public String toParagraphUpdate(Model model, @RequestParam(required = false) Integer id) {
        Paragraph paragraph = new Paragraph();
        if (id != null) {
        	Optional<Paragraph> optionalParagraph = paragraphRepository.findById(id);
        	if (optionalParagraph.isPresent()) {
        		paragraph = optionalParagraph.get();
        	}
        }
        model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
        model.addAttribute("messageCount", messageRepository.count());
        model.addAttribute("paragraph", paragraph);
		return "adminParagraphUpdate";
	}
	
	@GetMapping("/admin/history/card/update")
	public String toCardUpdate(Model model, @RequestParam(required = false) Integer id) {
        Card card = new Card();
        if (id != null) {
        	Optional<Card> optionalCard = cardRepository.findById(id);
        	if (optionalCard.isPresent()) {
        		card = optionalCard.get();
        	}
        }
        model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
        model.addAttribute("messageCount", messageRepository.count());
        model.addAttribute("card", card);
		return "adminCardUpdate";
	}
	
	@PostMapping("/admin/history/paragraph/update")
	public String updateParagraph(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("resume") String resume,
			@RequestParam ("picture") MultipartFile imageFile
			) {
		String path = "";
		if (id != null) {
			path = paragraphRepository.findById(id).get().getPicture();
		}
		if (!imageFile.isEmpty()) {
			String fileName = "paragraph_" + resume.split(" ")[0].toLowerCase();
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Paragraph paragraph = new Paragraph(id, resume, path);
		paragraphRepository.save(paragraph);
		if (id != null) {
			redirAttrs.addFlashAttribute("successMessage", "Le paragraphe a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "Le paragraphe a bien été ajouté.");
		}
		return "redirect:/admin/history";
	}
	
	@PostMapping("/admin/history/card/update")
	public String updateParagraph(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("firstname") String firstname,
			@RequestParam ("lastname") String lastname,
			@RequestParam (name = "picture", required = false) MultipartFile imageFile,
			@RequestParam (name = "url", required = false) String url
			) {
		String path = "";
		if (id != null) {
			path = cardRepository.findById(id).get().getPicture();
		}
		if (!imageFile.isEmpty()) {
			String fileName = "card_" + lastname;
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Card card = new Card(id, firstname, lastname, path, url);
		cardRepository.save(card);
		if (id != null) {
			redirAttrs.addFlashAttribute("successMessage", "Le joueur a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "Le joueur a bien été ajouté.");
		}
		return "redirect:/admin/history";
	}
	
}
