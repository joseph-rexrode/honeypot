package com.josephrexrode.honeypot.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josephrexrode.honeypot.models.HoneyPot;
import com.josephrexrode.honeypot.models.User;
import com.josephrexrode.honeypot.repositories.FamilyRepository;
import com.josephrexrode.honeypot.repositories.HoneyPotRepository;

@Service
public class HoneyPotService {

	@Autowired
	HoneyPotRepository hRepo;
	
	@Autowired
	FamilyRepository fRepo;
	
	// CRUD METHODS //
	
	public HoneyPot create(User u, HoneyPot h) {
		h.setCreator(u);
		h.setAmountSaved(0.00);
				
		return hRepo.save(h);
	}
	
	// OTHER METHODS
	
	public List<HoneyPot> findUserPots(User u) throws HibernateException {
		
		ArrayList<HoneyPot> pots = new ArrayList<HoneyPot>();
				
		u.getFamilies().forEach((family) -> {
			Hibernate.initialize(family.getHoneyPots());
			family.getHoneyPots().forEach((honeyPot) -> {
				pots.add(honeyPot);
			});
		});
		
		return (List<HoneyPot>)pots;
	}
}
