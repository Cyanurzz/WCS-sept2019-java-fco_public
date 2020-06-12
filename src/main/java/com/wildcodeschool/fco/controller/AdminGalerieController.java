package com.wildcodeschool.fco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wildcodeschool.fco.entity.Galerie;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.GalerieRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.service.FileUpload;

@Controller
public class AdminGalerieController {
	
	private String DIR = "photoGalerie";
	
	@Autowired
	private GalerieRepository galerieRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
    private FileUpload fileUpload;
	
	
	 @GetMapping("/admin/galerie")
	 public String showAdminGalery(Model model) {
		 model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		 model.addAttribute("messageCount", messageRepository.count());
		 model.addAttribute("galerieList", galerieRepository.findAll());
		 return "adminGalerie";
		 
	 }
		
	 @GetMapping("/admin/galerie/update")
	 public String showFormAddNewPhoto(Model model , @RequestParam(required = false) Long id  ) {
		Galerie galerie =new Galerie();
	    	if (id != null) {
	    		galerie = galerieRepository.getOne(id);
	    	}
	    	model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
	    	model.addAttribute("messageCount", messageRepository.count());
			model.addAttribute("galerie", galerie);
		 return "adminGalerieUpdate";
		 
	 }
	 @PostMapping("/admin/galerie/update")
	 public String addNewPhoto(Model model , Galerie galerie, @RequestParam MultipartFile[] photos , @RequestParam(required = false) Long id ) {
	     
		 if(galerie.getTitle().isEmpty())
			 galerie.setTitle("Photo du club");
		 String path = "";
		 for (int i = 0; i < photos.length; i++) {
			 String fileName = photos[i].getOriginalFilename();
			 path = fileUpload.writeFile(photos[i], DIR, fileName);
			 if (id != null)
				 galerieRepository.save(new Galerie(galerie.getId(),galerie.getTitle(), path));
			 else
			      galerieRepository.save(new Galerie(galerie.getTitle(), path));
		}
		 model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		 model.addAttribute("messageCount", messageRepository.count());
		 return "redirect:/admin/galerie"; 
	 }
	 
	 @GetMapping("/admin/galerie/delete")
	 public String deleteArticles(@RequestParam Long id) {
		 Galerie galerie = galerieRepository.getOne(id);
		 fileUpload.deleteFile(galerie.getPhoto());
		 galerieRepository.delete(galerie);
		 return "redirect:/admin/galerie";
	 }
	 
}
