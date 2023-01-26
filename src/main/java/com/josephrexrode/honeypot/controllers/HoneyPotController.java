package com.josephrexrode.honeypot.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.josephrexrode.honeypot.models.Family;
import com.josephrexrode.honeypot.models.HoneyPot;
import com.josephrexrode.honeypot.models.User;
import com.josephrexrode.honeypot.services.FamilyService;
import com.josephrexrode.honeypot.services.HoneyPotService;

@Controller
@RequestMapping("/honeypots")
public class HoneyPotController {
	
	@Autowired
	HoneyPotService hServ;
	
	@Autowired
	FamilyService fServ;

	
	@GetMapping("")
	public String honeypots(
			Model model,
			HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		return "/honeypots/pots.jsp";
		
	}
	
	@GetMapping("/new")
	public String newHoney(
			Model model,
			@ModelAttribute("honeyPot") HoneyPot honeypot,
			HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		User u = (User) session.getAttribute("loggedUser");
		
		List<Family> userFamilies = fServ.getUserFamilies(u);
		
		model.addAttribute("userFamilies", userFamilies);
		
		return "/honeypots/new.jsp";
		
	}
	
	@PostMapping("/new")
	public String createHoney(
			@Valid @ModelAttribute("honeyPot") HoneyPot honeypot,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		User u = (User) session.getAttribute("loggedUser");
		
		if (result.hasErrors()) {
						
			List<Family> userFamilies = fServ.getUserFamilies(u);
			
			model.addAttribute("userFamilies", userFamilies);
			
			return "/honeypots/new.jsp";
		}
		
		hServ.create(u, honeypot);
		
		return "redirect:/honeypots";
	}
}
