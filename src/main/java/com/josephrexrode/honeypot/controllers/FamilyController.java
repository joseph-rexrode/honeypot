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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.josephrexrode.honeypot.models.Family;
import com.josephrexrode.honeypot.models.User;
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
		
		User u = (User) session.getAttribute("loggedUser");
		
		List<Family> families = fServ.getUserFamilies(u);
		
		model.addAttribute("families", families);
				
		return "/families/fam.jsp";
	}
	
	// Create new Family
	// TODO
	
	@GetMapping("/new")
	public String newFamily(
			HttpSession session,
			@ModelAttribute("family") Family family) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
				
		return "/families/new.jsp";
	}
	
	@PostMapping("/new")
	public String createFamily(
			HttpSession session,
			@Valid @ModelAttribute("family") Family family,
			BindingResult result,
			Model model) {
		
		if (result.hasErrors()) {
			return "/families/new.jsp";
		}
		
		User user = (User) session.getAttribute("loggedUser");
		
		fServ.create(user, family);
		
		return "redirect:/families";
		
	}
	
	// Specific Family screen
	
	
	@GetMapping("/{famId}")
	public String show(
			@PathVariable("famId") Long id,
			Model model,
			HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		Family fam = fServ.getFamily(id);
		
		model.addAttribute("fam", fam);
		
		return "/families/show.jsp";
	}
	
		// Add Family Members
		// TODO
	
		// Remove Family Members
		// TODO
	
		// Request to join Family
		// TODO
	
		// Leave Family
		// TODO
	
	
	
	
	
	
}
