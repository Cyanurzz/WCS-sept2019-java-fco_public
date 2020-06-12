package com.wildcodeschool.fco.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.fco.repository.SponsorRepository;

@Controller
public class GlobalErrorController implements ErrorController {

	@Autowired
	private SponsorRepository sponsorRepository;
	
	@GetMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    model.addAttribute("sponsorList", sponsorRepository.findAll());
	    
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error/404";
	        } else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error/500";
	        } else if(statusCode == HttpStatus.FORBIDDEN.value()) {
	        	return "error/403";
	        }
	    }
	    return "error";
	}
	
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
