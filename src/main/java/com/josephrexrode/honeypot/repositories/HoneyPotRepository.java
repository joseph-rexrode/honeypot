package com.josephrexrode.honeypot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.josephrexrode.honeypot.models.Family;
import com.josephrexrode.honeypot.models.HoneyPot;

@Repository
public interface HoneyPotRepository extends CrudRepository<HoneyPot, Long> {
	
	Optional<HoneyPot> findById(Long id);
		
	List<HoneyPot> findAllByHoneyFamilyIn(List<Family> f);
}
