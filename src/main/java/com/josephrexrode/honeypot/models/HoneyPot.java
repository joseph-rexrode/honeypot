package com.josephrexrode.honeypot.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "honeyPots")
public class HoneyPot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String occasion;
	
	private Double goalAmount;
	
	private Double amountSaved;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@PrePersist
	public void createdOn() {
		this.createdAt = new Date();
	}
	
	private Date goalDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "family_id")
	private Family honeyFamily;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private User creator;
	
	@OneToMany(mappedBy = "contributionHoneyPot", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Contribution> honeyPotContributions;
	
	public HoneyPot() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public Double getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(Double goalAmount) {
		this.goalAmount = goalAmount;
	}

	public Double getAmountSaved() {
		return amountSaved;
	}

	public void setAmountSaved(Double amountSaved) {
		this.amountSaved = amountSaved;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getGoalDate() {
		return goalDate;
	}

	public void setGoalDate(Date goalDate) {
		this.goalDate = goalDate;
	}

	public Family getHoneyFamily() {
		return honeyFamily;
	}

	public void setHoneyFamily(Family honeyFamily) {
		this.honeyFamily = honeyFamily;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<Contribution> getHoneyPotContributions() {
		return honeyPotContributions;
	}

	public void setHoneyPotContributions(List<Contribution> honeyPotContributions) {
		this.honeyPotContributions = honeyPotContributions;
	}
}
