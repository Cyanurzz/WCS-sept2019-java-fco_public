package com.wildcodeschool.fco.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.fco.entity.Article;
import com.wildcodeschool.fco.entity.Encounter;
import com.wildcodeschool.fco.repository.ArticleRepository;
import com.wildcodeschool.fco.repository.BackgroundRepository;
import com.wildcodeschool.fco.repository.EncounterRepository;
import com.wildcodeschool.fco.repository.ShopRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;
import com.wildcodeschool.fco.repository.VideoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private BackgroundRepository backgroundRepository;

	@Autowired
	private ArticleRepository articleRepository;
  
	@Autowired
	private SponsorRepository sponsorRepository;
  
	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private EncounterRepository encounterRepository;
	
	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping("/")
	public String toHome(Model model, @RequestParam (value = "logout", required = false) String logout) {
		
		Encounter encounter = encounterRepository.findTopByOrderByTimeUntilMatchAsc();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM");
		String formatedMatchDate = formatter.format(encounter.getTimeUntilMatch());
		
		List<Article> primaryArticles = articleRepository.findRecentByPriority(1);
		if (primaryArticles.size() > 3) {
			primaryArticles = articleRepository.findRecentByPriority(1).subList(0, 3);
		}
		
		if (logout != null) {
			model.addAttribute("successMessage", "Vous avez bien été deconnecté.");
		}
		
		model.addAttribute("backgroundAccueil", backgroundRepository.findByName("accueil"));
		model.addAttribute("backgroundMatch", backgroundRepository.findByName("match"));
		model.addAttribute("video", videoRepository.getOne(1).getUrl());
		model.addAttribute("primaryArticles", primaryArticles);
		model.addAttribute("secondArticle", articleRepository.findRecentByPriority(2).get(0));
		model.addAttribute("thirdArticles",articleRepository.findRecentByPriority(3));
		model.addAttribute("nextMatch", encounter);
		model.addAttribute("formatedMatchDate", formatedMatchDate);
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		model.addAttribute("goodies", shopRepository.findAllGoodies());
		model.addAttribute("clothes", shopRepository.findAllClothes());
		
		return "index";
	}
}
