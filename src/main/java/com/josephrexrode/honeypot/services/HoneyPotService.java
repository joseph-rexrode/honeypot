package com.josephrexrode.honeypot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josephrexrode.honeypot.models.HoneyPot;
import com.josephrexrode.honeypot.models.User;
import com.josephrexrode.honeypot.repositories.HoneyPotRepository;

@Service
public class HoneyPotService {

	@Autowired
	HoneyPotRepository hRepo;
	
	// CRUD METHODS //
	
	public HoneyPot create(User u, HoneyPot h) {
		h.setCreator(u);
		return hRepo.save(h);
	}
	
	
}
