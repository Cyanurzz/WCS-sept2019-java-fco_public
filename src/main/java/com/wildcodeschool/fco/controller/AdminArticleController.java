package com.wildcodeschool.fco.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Article;
import com.wildcodeschool.fco.entity.Video;
import com.wildcodeschool.fco.repository.ArticleRepository;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.repository.VideoRepository;
import com.wildcodeschool.fco.service.FileUpload;


@Controller
public class AdminArticleController {

  @Autowired
  private ClientRepository clientRepository;

	private String DIR = "photoArticle";

	@Autowired
	private FileUpload fileUpload;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired 
	private VideoRepository videoRepository;
	
	@GetMapping("/admin/article")
	public String toAdminArticles(Model model)  {
		model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("articles", articleRepository.findAllByOrderByDateDesc());
		return "adminArticle";
	}
	
	@GetMapping("/admin/article/update")
	public String toArticle(Model model ,@RequestParam(required = false) Integer id) {
	 	Article article =new Article();
    	if (id != null) {
    		Optional<Article> optionalArticle = articleRepository.findById(id);
    		if (optionalArticle.isPresent()) {
    			article = optionalArticle.get();
    		}
    	}
    	model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
    	model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("article", article);
		return "adminArticleUpdate";
	}
	
	@PostMapping("/admin/article/update")
	public String postArticle(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("author") String author,  
			@RequestParam ("title") String title,
			@RequestParam ("content") String content, 
			@RequestParam ("division") String division,
			@RequestParam ("priority") int priority,
			@RequestParam ("picture") MultipartFile imageFile
			) {
		String path = "";
		if (id != null) {
			path = articleRepository.findById(id).get().getPicture();
		}
		if (!imageFile.isEmpty()) {
			String fileName = "article_" + title.replaceAll(" ", "_").toLowerCase();
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
	 	Article article = new Article(id, division, author, title, content, new Date(), path, priority);
    	articleRepository.save(article);
		if (id != null) {
			redirAttrs.addFlashAttribute("successMessage", "L'article a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "L'article a bien été ajouté.");
		}
		return "redirect:/admin/article";
	}
    
    @GetMapping("/admin/article/delete")
    public String deleteArticles(RedirectAttributes redirAttrs, @RequestParam Integer id) {
    	Article articleToDelete = articleRepository.findById(id).get();
    	fileUpload.deleteFile(articleToDelete.getPicture());
    	articleRepository.delete(articleToDelete);
    	redirAttrs.addFlashAttribute("successMessage", "L'article a bien été supprimé.");
    	
    	return "redirect:/admin/article";
    }
    
	@GetMapping("/admin/video/update")
	public String toVideoUpdate(Model model , @RequestParam(required = false) Integer id) {
	 	Video video =new Video();
    	if (id != null) {
    		Optional<Video> optionalVideo = videoRepository.findById(id);
    		if (optionalVideo.isPresent()) {
    			video = optionalVideo.get();
    		}
    	}
    	model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
    	model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("video", video);
		return "adminVideoUpdate";
	}
	
	@PostMapping("/admin/video/update")
	public String postVideo( RedirectAttributes redirAttrs, @RequestParam ("id") Integer id, @RequestParam ("url") String url
			) {
		String newUrl = "https://www.youtube.com/embed/";
		String testUrl = url.substring(0,7);
		if (testUrl.equals("youtube")) {
			newUrl += url.substring(20);
		}
		else {
			newUrl += url.substring(32);
		}
		
	 	Video video = new Video(id, newUrl);
    	videoRepository.save(video);
    	redirAttrs.addFlashAttribute("successMessage", "La vidéo a bien été modifié.");

		return "redirect:/admin/article";
	}
}
