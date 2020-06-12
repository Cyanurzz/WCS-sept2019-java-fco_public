package com.wildcodeschool.fco.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Product;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.repository.ShopRepository;
import com.wildcodeschool.fco.service.FileUpload;

@Controller
public class AdminShopController {

	@Autowired
	private ClientRepository clientRepository;

	private String DIR = "photoProduit";

	@Autowired
	private FileUpload fileUpload;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private ShopRepository shopRepository;


	@GetMapping("/admin/adminShop/adminProduct")
	public String toProduct(Model model, @RequestParam(required = false) Integer id) {
		Product product = new Product();
		if (id != null) {
			Optional<Product> optionalProduct = shopRepository.findById(id);
			if (optionalProduct.isPresent()) {
				product = optionalProduct.get();
			}
		}
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("product", product);
		model.addAttribute("messageCount", messageRepository.count());
		return "adminProduct";
	}

	@PostMapping("/admin/adminShop/adminProduct")
	public String postProduct(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("price") double price,  
			@RequestParam ("name") String name,
			@RequestParam ("description") String description,
			@RequestParam (name="quantity", required=false) Integer quantity,
			@RequestParam ("picture") MultipartFile imageFile,
			@RequestParam (name="quantityXs", required=false) Integer quantityXs,
			@RequestParam (name="quantityS", required=false) Integer quantityS,
			@RequestParam (name="quantityM", required=false) Integer quantityM,
			@RequestParam (name="quantityXl", required=false) Integer quantityXl,
			@RequestParam (name="quantityXxl", required=false) Integer quantityXxl,
			@RequestParam (name="quantityL", required=false) Integer quantityL) {
		String path = "";
		if (id != null) {
			path = shopRepository.findById(id).get().getPicture();
		}
		if (!imageFile.isEmpty()) {
			String fileName = "product_" + name.toLowerCase();
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Product product = new Product(id, name, description, path, price, quantity, quantityXs, quantityS, quantityM,
				quantityL, quantityXl, quantityXxl);
		shopRepository.save(product);
		if (id != null) {
			redirAttrs.addFlashAttribute("successMessage", "Le produit a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "Le produit a bien été ajouté.");
		}
		return "redirect:/admin/adminShop";
	}

	@GetMapping("/admin/adminShop")
	public String toAdminShop(Model model) {
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("Products", shopRepository.findAll());
		model.addAttribute("messageCount", messageRepository.count());
		return "adminShop";
	}

	@GetMapping("/admin/adminShop/delete")
	public String removeProduct(RedirectAttributes redirAttrs, @RequestParam Integer id) {
		Product productToDelete = shopRepository.findById(id).get();
		fileUpload.deleteFile(productToDelete.getPicture());
		shopRepository.delete(productToDelete);
		redirAttrs.addFlashAttribute("successMessage", "Le produit a bien été supprimé.");
		return "redirect:/admin/adminShop";
	}
}
