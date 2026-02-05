package com.internship.tracker.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "applications")
public class InternshipApplication {
      
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String companyName;

	    private String role;

	    private LocalDate appliedDate;

	    private String notes;
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	    
	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }
	    
	    
	    
	    
	    @Enumerated(EnumType.STRING)
	    private ApplicationStatus status;
	    
	   
		public InternshipApplication(Long id, String companyName, String role, LocalDate appliedDate, String notes, ApplicationStatus status) {
			super();
			this.id = id;
			this.companyName = companyName;
			this.role = role;
			this.appliedDate = appliedDate;
			this.notes = notes;
			  this.status = status;
		}
		

		public InternshipApplication() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public LocalDate getAppliedDate() {
			return appliedDate;
		}

		public void setAppliedDate(LocalDate appliedDate) {
			this.appliedDate = appliedDate;
		}

		public String getNotes() {
			return notes;
		}

		public void setNotes(String notes) {
			this.notes = notes;
		}
		
		public ApplicationStatus getStatus() {
			return status;
		}

		public void setStatus(ApplicationStatus status) {
			this.status = status;
		}

		

		@Override
		public String toString() {
			return "InternshipApplication [id=" + id + ", companyName=" + companyName + ", role=" + role
					+ ", appliedDate=" + appliedDate + ", notes=" + notes + "]";
		}



		
		
	    
	    
	    
	    
	    
}
