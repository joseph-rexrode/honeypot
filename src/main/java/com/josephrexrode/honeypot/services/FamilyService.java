package com.josephrexrode.honeypot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josephrexrode.honeypot.models.Family;
import com.josephrexrode.honeypot.models.User;
import com.josephrexrode.honeypot.repositories.FamilyRepository;

@Service
public class FamilyService {

	@Autowired
	FamilyRepository fRepo;
	
	// CRUD METHODS
	
	// Creates a family where only one person is a member and that is the creator
	// add functionality (for loop probs) where each User that is selected...
	// ... from the list of Users is added to an array of Members...
	// ... which is then parsed through here and added to the users attribute
	public Family create(User u, Family f) {
		f.setUsers(new ArrayList<User>());
		f.getUsers().add(u);
		f.setCreator(u);
		return fRepo.save(f);
	}
	
	
	public Family getFamily(Long id) {
		return fRepo.findById(id).orElse(null);
	}
	
	public List<Family> getUserFamilies(User u) {
		
		return fRepo.findAllByUsers(u);
	}
	
	
}
