package com.josephrexrode.honeypot.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.josephrexrode.honeypot.models.Contribution;
import com.josephrexrode.honeypot.models.Family;
import com.josephrexrode.honeypot.models.HoneyPot;
import com.josephrexrode.honeypot.models.User;
import com.josephrexrode.honeypot.services.ContributionService;
import com.josephrexrode.honeypot.services.FamilyService;
import com.josephrexrode.honeypot.services.HoneyPotService;

@Controller
@RequestMapping("/honeypots")
public class HoneyPotController {
	
	
	@Autowired
	HoneyPotService hServ;
	
	@Autowired
	FamilyService fServ;
	
	@Autowired
	ContributionService cServ;

	// Added init binder to allow form dates to be parsed correctly from front to back
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@GetMapping("")
	public String honeypots(
			Model model,
			HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		User u = (User) session.getAttribute("loggedUser");
		
		
		List<HoneyPot> userPots = hServ.findUserPots(u);
		
		model.addAttribute("userPots", userPots);

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
			HttpSession session) throws ParseException {
		
		User u = (User) session.getAttribute("loggedUser");
		
		if (result.hasErrors()) {
						
			List<Family> userFamilies = fServ.getUserFamilies(u);
			
			model.addAttribute("userFamilies", userFamilies);
			
			return "/honeypots/new.jsp";
		}
		
		
		hServ.create(u, honeypot);
		
		return "redirect:/honeypots";
	}
	
	@GetMapping("/{honeyId}")
	public String specificHoneyPot(
			@PathVariable("honeyId") Long id,
			Model model,
			HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		HoneyPot honeypot = hServ.getById(id);
		
		model.addAttribute("honeypot", honeypot);
		
		return "/honeypots/show.jsp";
	}
	
	
	// CONTRIBUTIONS //
	
	@GetMapping("/{honeyId}/contributions/new")
	public String newContribution(
			Model model,
			@ModelAttribute("contribution") Contribution contribution,
			HttpSession session,
			@PathVariable("honeyId") Long honeyId) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		HoneyPot h = hServ.getById(honeyId);
		
		model.addAttribute("honeypot", h);
		
		return "/honeypots/newContribution.jsp";
	}
	
	@PostMapping("/{honeyId}/contributions/new")
	public String createContribution(
			@Valid @ModelAttribute("contribution") Contribution contribution,
			BindingResult result,
			Model model,
			HttpSession session,
			@PathVariable("honeyId") Long honeyId) {
		
		User u = (User) session.getAttribute("loggedUser");
		HoneyPot h = hServ.getById(honeyId);
		
		if (result.hasErrors()) {
			model.addAttribute("honeypot", h);
			
			return "/honeypots/{honeyId}";
		}
		
		cServ.create(contribution, u, h);
		
		return "redirect:/honeypots/{honeyId}";
	}
}
