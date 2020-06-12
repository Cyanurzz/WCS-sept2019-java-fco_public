package com.wildcodeschool.fco.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Client;
import com.wildcodeschool.fco.entity.Cart;
import com.wildcodeschool.fco.entity.CartProduct;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.CartProductRepository;
import com.wildcodeschool.fco.repository.CartRepository;
import com.wildcodeschool.fco.repository.SponsorRepository;

@Controller
public class CartController {
	@Autowired
	private SponsorRepository sponsorRepository;
	@Autowired
	private CartProductRepository cartProductRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CartRepository cartRepository ;

	
	@GetMapping("/cart")
	public String showPanier(Model model, HttpSession session) {
		model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
		Cart cart = cartRepository.getBySessionId(session.getId());
		if(cartProductRepository.findAll().size() > 0 && cart.getId() != null) {
			model.addAttribute("ProductInCart", cartProductRepository.findByCartId(cart.getId()));
			model.addAttribute("client", new Client());
			return "cart";
		} else {
			return "redirect:/shop";
		}
	}
	
	@GetMapping("/cart/delete")
	public String deletProductPanier(Model model, @RequestParam Long idProductInCart  ) {
		CartProduct panierProduct = cartProductRepository.getOne(idProductInCart);
		cartProductRepository.delete(panierProduct);
		
		return "redirect:/cart";
	}
	@PostMapping("/cart")
	public String addOrder(Model model, 
		                   RedirectAttributes redirAttrs, 
			               HttpSession session,
			               @Valid Client client ,
			               BindingResult result
			              ) {
		if (result.hasErrors()) {
			model.addAttribute("hasErrors", true);
			model.addAttribute("client", client);
			model.addAttribute("sponsorList", sponsorRepository.sponsorSortByPriority());
			if(cartProductRepository.findAll().size()>0)
				 if(cartRepository.getBySessionId(session.getId()) != null)
					 model.addAttribute("ProductInCart", cartProductRepository.findByCartId(cartRepository.getBySessionId(session.getId()).getId()));

			return "/cart";
		} else {

		client.setCart(cartRepository.getBySessionId(session.getId()));
		ShopController.sessionList.remove(session.getId());
		Cart cart = cartRepository.getBySessionId(session.getId());
		cart.setSessionId(null);
		cartRepository.save(cart);
		clientRepository.save(client);
		redirAttrs.addFlashAttribute("successMessage", "votre commande a été passée");
		return "redirect:/shop";
		}
	}

}