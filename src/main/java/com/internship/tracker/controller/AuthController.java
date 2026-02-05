package com.internship.tracker.controller;

import org.springframework.web.bind.annotation.*;
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

    // 🔐 LOGIN (compare hashed password)
    @PostMapping("/login")
    public User login(@RequestBody User user) {

        User dbUser = repo.findByUsername(user.getUsername());

        if (dbUser == null) {
            throw new RuntimeException("Invalid credentials");
        }

        // 🔥 compare raw password with hashed password
        boolean match = encoder.matches(
                user.getPassword(),
                dbUser.getPassword()
        );

        if (!match) {
            throw new RuntimeException("Invalid credentials");
        }

        return dbUser;
    }

    // 🆕 SIGNUP (hash password before saving)
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        if (repo.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("User already exists");
        }

        // 🔥 hash password
        user.setPassword(encoder.encode(user.getPassword()));

        return repo.save(user);
    }
}
