package com.josephrexrode.honeypot.models;

import javax.validation.constraints.Email;

public class LoginUser {

	@Email(message = "Please input a valid email address")
	private String email;
	
	private String password;
	
	public LoginUser() {}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
