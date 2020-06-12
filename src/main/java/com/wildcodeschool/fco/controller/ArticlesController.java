package com.wildcodeschool.fco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wildcodeschool.fco.entity.Sponsor;
import com.wildcodeschool.fco.repository.ArticleRepository;
import com.wildcodeschool.fco.repository.BackgroundRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;


@Controller
public class ArticlesController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private BackgroundRepository backgroundRepository;
	
	@Autowired
	private SponsorRepository sponsorRepository;
		
	  List<Sponsor> sponsorList;
	
	@GetMapping("/articles")
	public String toArticles(Model model)  {
		model.addAttribute("articles", articleRepository.findAllByOrderByDateDesc());
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		return "articles";
	}
	
	@GetMapping("/article/{id}")
	public String toArticle(@PathVariable("id") Integer id,  Model model) {
		model.addAttribute("backgroundArticle", backgroundRepository.findByName("article"));
		model.addAttribute("article", articleRepository.findById(id).get());
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		return "article";
	}
	
	
}
