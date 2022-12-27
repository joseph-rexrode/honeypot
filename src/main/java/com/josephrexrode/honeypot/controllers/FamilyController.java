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
			@ModelAttribute("family") Family family,
			Model model) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		User u = (User) session.getAttribute("loggedUser");
		
		List<User> otherUsers = uServ.findAllUsersExceptYou(u.getId());
		
		model.addAttribute("users", otherUsers);
				
		return "/families/new.jsp";
	}
	
	@PostMapping("/new")
	public String createFamily(
			HttpSession session,
			@Valid @ModelAttribute("family") Family family,
			BindingResult result,
			Model model) {
		
		User u = (User) session.getAttribute("loggedUser");
		
		if (result.hasErrors()) {
			
			List<User> otherUsers = uServ.findAllUsersExceptYou(u.getId());
			model.addAttribute("users", otherUsers);
			return "/families/new.jsp";
		}
		
		
		fServ.create(u, family);
				
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
	
	@PostMapping("/{famId}/add")
	public String add(
			@PathVariable("famId") Long id,
			Model model,
			HttpSession session) {
		
		return "";
	}
	
		// Remove Family Members
		// TODO
	
	@PostMapping("/{famId}/remove")
	public String removeMembers(
			@PathVariable("famId") Long id,
			Model model,
			HttpSession session) {
		
		return "";
		
	}
	
		// Request to join Family
		// TODO
		// This will be additional functionality to be completed later
	
	
		// Leave Family
		// TODO
	
	@PostMapping("/{famId}/leave")
	public String leaveFamily(
			@PathVariable("famId") Long id,
			Model model,
			HttpSession session) {
		
		return "";
		
	}
	
	
	
	
	
}
