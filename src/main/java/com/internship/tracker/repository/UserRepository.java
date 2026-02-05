package com.internship.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internship.tracker.entity.User;

public interface UserRepository extends JpaRepository<User , Long>{
	
	  User findByUsername(String username);

}
