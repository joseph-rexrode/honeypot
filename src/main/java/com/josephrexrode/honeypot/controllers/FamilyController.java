package com.josephrexrode.honeypot.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.josephrexrode.honeypot.models.Family;
import com.josephrexrode.honeypot.services.FamilyService;
import com.josephrexrode.honeypot.services.UserService;

@Controller
@RequestMapping("/families")
public class FamilyController {

	@Autowired
	FamilyService fServ;
	
	@Autowired
	UserService uServ;
	
	// See your families
	// TODO
	
	@GetMapping("")
	public String families(
			HttpSession session,
			Model model) {
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		
		return "/families/fam.jsp";
	}
	
	// Create new Family
	// TODO
	
	@GetMapping("/new")
	public String newFamily(
			HttpSession session,
			Model model) {
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		
		return "/families/new.jsp";
	}
	
	// Specific Family screen
	
		// Add Family Members
		// TODO
	
	@GetMapping("/{famId}")
	public String show(
			@PathVariable("famId") Long id,
			Model model,
			HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		Family fam = fServ.getFamily(id);
		
		model.addAttribute("loggedUser", session.getAttribute("loggedAttribute"));
		model.addAttribute("fam", fam);
		
		return "/families/show.jsp";
	}
	
		// Remove Family Members
		// TODO
	
		// Request to join Family
		// TODO
	
		// Leave Family
		// TODO
	
	
	
	
	
	
}
