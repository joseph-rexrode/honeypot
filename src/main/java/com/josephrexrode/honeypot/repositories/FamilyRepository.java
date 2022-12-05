package com.josephrexrode.honeypot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.josephrexrode.honeypot.models.Family;
import com.josephrexrode.honeypot.models.User;


@Repository
public interface FamilyRepository extends CrudRepository<Family, Long> {

	Optional<Family> findByFamilyName(String familyName);
	
	List<Family> findAllByUsers(User u);
}
