package com.josephrexrode.honeypot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/")
	public String families() {
		return "";
	}
	
	// Create new Family
	// TODO
	
	@GetMapping("/families/new")
	public String newFamily() {
		return "";
	}
	
	// Specific Family screen
	
		// Add Family Members
		// TODO
	
		// Remove Family Members
		// TODO
	
		// Request to join Family
		// TODO
	
		// Leave Family
		// TODO
	
	
	
	
	
	
}
