package com.example.SpringBootAngular4.demo.repo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootAngular4.demo.domain.UserDomain;

@Repository
public interface UserRepository extends CrudRepository<UserDomain, Long> {

	/**
	 * Finds person by using the last name as a search criteria.
	 * 
	 * @param name
	 * @return A list of persons whose last name is an exact match with the given
	 *         last name. If no persons is found, this method returns null.
	 */
	@Query("SELECT p FROM UserDomain p WHERE LOWER(p.name) = LOWER(?1)")
	public UserDomain findByName(String name);

}
