package com.josephrexrode.honeypot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
		f.getUsers().add(u);
		f.setCreator(u);
		return fRepo.save(f);
	}
	
	
	// Finds a family by its Id
	public Family getFamily(Long id) {
		return fRepo.findById(id).orElse(null);
	}
	
	
	// Add family members
	public Family addMembers(Family f, List<User> members, BindingResult result) {
		// if members list is null, return error
		if (members == null) {
			result.rejectValue("users", "Matches", "No Users Selected");
			return null;
		}
		
		// for each member in list of added members
		for (var i = 0; i < members.size(); i++) {
			// add to family f
			f.getUsers().add(members.get(i));
		}
		return fRepo.save(f);
	}
	
	
	// Remove family members
	public Family removeMembers(Family f, List<User> members, BindingResult result) {
		// if members list is null, return error
		if (members == null) {
			result.rejectValue("users", "Matches", "No Users Selected");
			return null;
		}
		
		// for each member in list of members to remove
		for (var i = 0; i < members.size(); i++) {
			User u = members.get(i);
			f.getUsers().removeIf(n -> (n.equals(u)));
		}
		
		return fRepo.save(f);
	}
	
	
	// Update family
	public Family update(Family f, Family changes) {
		f.setFamilyName(changes.getFamilyName());
		f.setUsers(changes.getUsers());
		return fRepo.save(f);
	}
	
	
	// Delete a family
	public String destroy(Long id) {
		fRepo.deleteById(id);
		return "This family has been deleted";
	}
	
	
	// OTHER METHODS
	
	// Finds a list of all families the User is in
	public List<Family> getUserFamilies(User u) {
		
		return fRepo.findAllByUsers(u);
	}
	
	
}
