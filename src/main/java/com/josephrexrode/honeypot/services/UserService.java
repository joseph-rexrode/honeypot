package com.josephrexrode.honeypot.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.josephrexrode.honeypot.models.LoginUser;
import com.josephrexrode.honeypot.models.User;
import com.josephrexrode.honeypot.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepo;
	
	public User register(User newUser, BindingResult result) {
		
		Optional<User> optionalUser = uRepo.findByEmail(newUser.getEmail());
		
		if (optionalUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email already in use.");
			return null;
		}
		
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "Matches", "Password does not match confirm password.");
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		
		newUser.setPassword(hashed);
		
		return uRepo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		
		Optional<User> optionalUser = uRepo.findByEmail(newLogin.getEmail());
		
		if (optionalUser.isEmpty()) {
			result.rejectValue("email", "Matches", "This email is not recognized!");
			return null;
		}
		
		User user = optionalUser.get();
		
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid password.");
			return null;
		}
		
		return user;
	}
	
}
