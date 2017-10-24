package com.example.SpringBootAngular2.demo.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootAngular2.demo.domain.UserRole;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
	
	@Query("select a.role from UserRole a, UserDomain b where b.name=?1 and a.userid=b.id")
    public List<String> findRoleByUserName(String username);
	
}