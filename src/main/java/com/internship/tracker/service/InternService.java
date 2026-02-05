package com.internship.tracker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.internship.tracker.entity.*;
import com.internship.tracker.repository.*;

@Service
public class InternService {

    private final InternRepository internRepo;
    private final UserRepository userRepo;

    public InternService(InternRepository internRepo, UserRepository userRepo) {
        this.internRepo = internRepo;
        this.userRepo = userRepo;
    }

    public InternshipApplication saveApplication(
            InternshipApplication app, Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        app.setUser(user);   // ✅ CRITICAL
        return internRepo.save(app);
    }

    public List<InternshipApplication> getByStatus(
            Long userId, ApplicationStatus status) {

        return internRepo.findByUserIdAndStatus(userId, status);
    }
    
    
    public long getCountByStatus(Long userId, ApplicationStatus status) {
        return internRepo.countByUserIdAndStatus(userId, status);
    }

}

