package com.josephrexrode.honeypot.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "contributions")
public class Contribution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double contributionAmount;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@PrePersist
	public void createdOn() {
		this.createdAt = new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User contributor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "honeypot_id")
	private HoneyPot contributionHoneyPot;
	
	public Contribution() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getContributionAmount() {
		return contributionAmount;
	}

	public void setContributionAmount(Double contributionAmount) {
		this.contributionAmount = contributionAmount;
	}

	public User getContributor() {
		return contributor;
	}

	public void setContributor(User contributor) {
		this.contributor = contributor;
	}

	public HoneyPot getContributionHoneyPot() {
		return contributionHoneyPot;
	}

	public void setContributionHoneyPot(HoneyPot contributionHoneyPot) {
		this.contributionHoneyPot = contributionHoneyPot;
	}
}
