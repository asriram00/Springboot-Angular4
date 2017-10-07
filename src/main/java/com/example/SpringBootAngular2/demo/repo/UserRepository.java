package com.example.SpringBootAngular2.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootAngular2.demo.domain.UserDomain;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Long> {

}
