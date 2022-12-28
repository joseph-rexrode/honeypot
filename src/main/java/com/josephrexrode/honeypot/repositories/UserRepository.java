package com.josephrexrode.honeypot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.josephrexrode.honeypot.models.Family;
import com.josephrexrode.honeypot.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByEmail(String email);
	
	List<User> findByIdNot(Long id);
	
	List<User> findAllDistinctByFamiliesNotContaining(Family f);
}
