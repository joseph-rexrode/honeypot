package com.josephrexrode.honeypot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josephrexrode.honeypot.models.Contribution;
import com.josephrexrode.honeypot.models.HoneyPot;
import com.josephrexrode.honeypot.models.User;
import com.josephrexrode.honeypot.repositories.ContributionRepository;

@Service
public class ContributionService {

	@Autowired
	ContributionRepository cRepo;
	
	// CRUD METHODS //
	
	// create method also has to update honeyPot's amountSaved attribute
	
	public Contribution create(Contribution c, User u, HoneyPot h) {
		c.setContributor(u);
		c.setContributionHoneyPot(h);
		h.setAmountSaved(h.getAmountSaved() + c.getContributionAmount());
		
		return cRepo.save(c);
	}
	
	
}
