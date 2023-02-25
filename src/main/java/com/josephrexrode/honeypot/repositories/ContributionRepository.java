package com.josephrexrode.honeypot.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.josephrexrode.honeypot.models.Contribution;

@Repository
public interface ContributionRepository extends CrudRepository<Contribution, Long> {
	
	Optional<Contribution> findById(Long id);
}
