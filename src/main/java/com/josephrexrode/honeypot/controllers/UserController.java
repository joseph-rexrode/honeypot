package com.josephrexrode.honeypot.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.josephrexrode.honeypot.models.LoginUser;
import com.josephrexrode.honeypot.models.User;
import com.josephrexrode.honeypot.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService uServ;
	
	// LOGIN/REGISTER PAGE
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "/index.jsp";
	}
	
	// REGISTER
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "/index.jsp";
		}
		
		User user = uServ.register(newUser, result);
		
		if (user == null) {
			model.addAttribute("newLogin", new LoginUser());
			return "/index.jsp";
		}
		
		session.setAttribute("loggedUser", user);
		
		return "redirect:/home";
		
	}
	
	// LOGIN
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "/index.jsp";
		}
		
		User user = uServ.login(newLogin, result);
		
		if (user == null) {
			model.addAttribute("newUser", new User());
			return "/index.jsp";
		}
		
		session.setAttribute("loggedUser", user);
		
		return "redirect:/home";
	}
	
	// HOME SCREEN
	
	@GetMapping("/home")
	public String home(
			Model model,
			HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		
		return "/home.jsp";
	}
	
	// LOGOUT
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	
}
