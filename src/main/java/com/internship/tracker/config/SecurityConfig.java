package com.internship.tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
     
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                		  "/", "/index.html",
                		    "/login.html", "/signup.html",
                		    "/dashboard.html", "/add.html",
                		    "/style.css",
                		    "/login.js", "/signup.js",
                		    "/dashboard.js", "/add.js",
                		    "/auth/**",
                		    "/applications/**",
                		    "/logout" 
                ).permitAll()
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
