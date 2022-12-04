package com.josephrexrode.honeypot.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/honeypots")
public class HoneyPotController {

	
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
			HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		return "/honeypots/new.jsp";
		
	}
}
