# Internship Application Tracker

A full-stack web application built using Java and Spring Boot that allows users to securely track and manage their internship applications.

---

## Overview

The Internship Application Tracker helps students organize and monitor their internship journey in one centralized system.

Users can:
- Create an account and log in securely
- Add internship applications
- Track applications by status (Applied, Interview, Offer, Rejected)
- View a dashboard with status-based counts
- Manage user-specific data securely

This project demonstrates full-stack development using Spring Boot, REST APIs, MySQL, and a clean frontend built with HTML, CSS, and JavaScript.

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- REST APIs
- BCrypt Password Encryption
- MySQL Database

### Frontend
- HTML
- CSS
- JavaScript

---

## Key Features

- User Registration (Sign Up)
- Secure Login with BCrypt password encryption
- Add Internship Applications
- Track applications by status
- Dashboard with dynamic status counts
- User-specific data handling using relational mapping
- Logout functionality
- Clean and consistent UI design

---

## Project Structure

```
internship-application-tracker/
│
├── src/main/java/com/internship/tracker
│   ├── controller        # REST Controllers
│   ├── service           # Business Logic
│   ├── repository        # JPA Repositories
│   ├── entity            # Database Entities
│   └── config            # Security Configuration
│
├── src/main/resources
│   ├── static            # HTML, CSS, JS files
│   └── application.properties
│
└── README.md
```

## 🚀 Application Preview

### Login Page
![Login Page](screenshots/login.png)

### Dashboard
![Dashboard](screenshots/dashboard.png)

---

## Database Schema

### Users Table
- id
- username
- password (encrypted using BCrypt)

### Applications Table
- id
- company_name
- role
- status (APPLIED, INTERVIEW, OFFER, REJECTED)
- user_id (foreign key referencing Users table)

---

## Application Flow

1. User signs up and password is encrypted using BCrypt.
2. User logs in through REST API authentication.
3. On successful login, the user is redirected to the dashboard.
4. User can add internship applications.
5. Applications are stored with a foreign key reference to the logged-in user.
6. Dashboard displays applications filtered by status.
7. Status counts update dynamically.
8. User can log out securely.

---

## How to Run the Project

1. Clone the repository:

   ```bash
   git clone https://github.com/bhavitha092005/InternshipApplicationTracker.git
   ```

2. Configure MySQL database in `application.properties`:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/internship_tracker
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Run the Spring Boot application.

4. Open the browser and visit:

   ```
   http://localhost:8081/
   ```

---

## Learning Outcomes

- Building REST APIs using Spring Boot
- Implementing authentication using Spring Security
- Encrypting passwords securely with BCrypt
- Managing relational database mappings using JPA
- Integrating frontend and backend using JavaScript
- Debugging authentication and database issues
- Designing consistent and user-friendly UI

---

## Future Enhancements

- JWT-based authentication
- Pagination and search functionality
- Role-based authorization
- Mobile responsiveness
- Cloud deployment

---

# Author
Pala Bhavitha | 
Full Stack Developer

Focused on designing and developing full-stack web applications with Java, Spring Boot, and Spring Security. Actively advancing skills in React, Next.js, and microservices architecture, with an emphasis on building scalable, secure, and production-ready systems.
