package com.internship.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internship.tracker.entity.ApplicationStatus;
import com.internship.tracker.entity.InternshipApplication;

public interface InternRepository extends   
       JpaRepository<InternshipApplication, Long>
 
{
	List<InternshipApplication>
	findByUserIdAndStatus(Long userId, ApplicationStatus status);
	
	long countByUserIdAndStatus(Long userId, ApplicationStatus status);


}