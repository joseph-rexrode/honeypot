package com.josephrexrode.honeypot.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Must include a username")
	private String username;
	
	@NotBlank(message = "Must include an email adddress")
	@Email(message = "Please enter a valid email address")
	private String email;
	
	@NotBlank(message = "Must include a password")
	private String password;
	
	@Transient
	private String confirm;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_families",
			joinColumns = @JoinColumn(name = "users_id"),
			inverseJoinColumns = @JoinColumn(name = "families_id")
			)
	private List<Family> families;
	
	
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<HoneyPot> createdPots;
	
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Family> createdFamilies;
	
	@OneToMany(mappedBy = "contributor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Contribution> userContributions;
	
	public User() {}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

	public List<HoneyPot> getCreatedPots() {
		return createdPots;
	}

	public void setCreatedPots(List<HoneyPot> createdPots) {
		this.createdPots = createdPots;
	}

	public List<Family> getCreatedFamilies() {
		return createdFamilies;
	}

	public void setCreatedFamilies(List<Family> createdFamilies) {
		this.createdFamilies = createdFamilies;
	}

	public List<Contribution> getUserContributions() {
		return userContributions;
	}

	public void setUserContributions(List<Contribution> userContributions) {
		this.userContributions = userContributions;
	}
}
