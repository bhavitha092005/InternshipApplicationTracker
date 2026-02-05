package com.internship.tracker.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.internship.tracker.entity.*;
import com.internship.tracker.service.InternService;

@RestController
@RequestMapping("/applications")
@CrossOrigin
public class InternController {

    private final InternService service;

    public InternController(InternService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public InternshipApplication create(
            @PathVariable Long userId,
            @RequestBody InternshipApplication app) {

        return service.saveApplication(app, userId);
    }

    @GetMapping("/{userId}/status")
    public List<InternshipApplication> byStatus(
            @PathVariable Long userId,
            @RequestParam ApplicationStatus status) {

        return service.getByStatus(userId, status);
    }
    
    
    
    @GetMapping("/{userId}/count")
    public long getCount(
            @PathVariable Long userId,
            @RequestParam ApplicationStatus status) {

        return service.getCountByStatus(userId, status);
    }

}

