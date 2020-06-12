package com.wildcodeschool.fco.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Cart;
import com.wildcodeschool.fco.entity.CartProduct;
import com.wildcodeschool.fco.entity.Product;
import com.wildcodeschool.fco.repository.CartProductRepository;
import com.wildcodeschool.fco.repository.CartRepository;
import com.wildcodeschool.fco.repository.ShopRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;

@Controller
public class ShopController {

	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private SponsorRepository sponsorRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartProductRepository cartProductRepository;

    public static List<String> sessionList = new ArrayList<String>();
	public ShopController() {
		super();
       
	}

	@GetMapping("/shop")
	public String showShopPage( Model model , HttpSession session) {
		model.addAttribute("Products", shopRepository.findAll());
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		if(cartProductRepository.findAll().size()>0)
			 if(cartRepository.getBySessionId(session.getId()) != null)
			    model.addAttribute("numberOfProduct", cartProductRepository.findByCartId(cartRepository.getBySessionId(session.getId()).getId()).size());

		return "shop";
	}

	@GetMapping("/product")
	public String showProduct(Model model, @RequestParam Integer id, HttpSession session) {
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		model.addAttribute("product", shopRepository.getOne(id));
		if(cartProductRepository.findAll().size()>0)
			 if(cartRepository.getBySessionId(session.getId()) != null)
			    model.addAttribute("numberOfProduct", cartProductRepository.findByCartId(cartRepository.getBySessionId(session.getId()).getId()).size());

		return "product";
	}

	@GetMapping("/product/addToCart")
	public String addToBascket(Model model, RedirectAttributes redirAttrs, @RequestParam Integer idProduct,
			 HttpSession session, @RequestParam Integer quantity, @RequestParam String size) {
		Date date = new Date();
		if(!sessionList.contains(session.getId())) {
			sessionList.add(session.getId());
			Cart cart = new Cart(date, session.getId());
			cart = cartRepository.save(cart);
			
		}
		Product product = shopRepository.getOne(idProduct);
		Cart cart = cartRepository.getBySessionId(session.getId());
		cartProductRepository.save(new CartProduct(product, cart, quantity, size));
		redirAttrs.addFlashAttribute("successMessage", "votre produit a été ajouté  .");
		return "redirect:/shop";
	}

}
