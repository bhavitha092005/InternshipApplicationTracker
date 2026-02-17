package com.internship.tracker.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.internship.tracker.entity.User;
import com.internship.tracker.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;

    public AuthController(UserRepository repo,
                          BCryptPasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        User dbUser = repo.findByUsername(user.getUsername());

        if (dbUser == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        boolean match = encoder.matches(
                user.getPassword(),
                dbUser.getPassword()
        );

        if (!match) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        return ResponseEntity.ok(new UserResponse(dbUser));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        if (repo.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        user.setPassword(encoder.encode(user.getPassword()));

        return ResponseEntity.ok(new UserResponse(repo.save(user)));
    }
}
