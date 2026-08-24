package com.tracker.backend.service;


import com.tracker.backend.model.InternshipApplication;
import com.tracker.backend.repository.InternshipApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternshipApplicationService {
    private final InternshipApplicationRepository repository;

    public InternshipApplicationService(InternshipApplicationRepository repository) {
        this.repository = repository;
    }

    public List<InternshipApplication> getAllApplications(){
        return repository.findAll();
    }

    public Optional<InternshipApplication> getApplicationById(Long id)
    {
        return repository.findById(id);
    }

    public InternshipApplication createApplication(InternshipApplication application) {
        if (application.getStatus() == null || application.getStatus().isEmpty()) {
            application.setStatus("APPLIED");
        }
        return repository.save(application);
    }

    public InternshipApplication updateApplication(Long id, InternshipApplication updatedApp){
        return repository.findById(id).map(existing -> {
            existing.setCompanyName(updatedApp.getCompanyName());
            existing.setPositionTitle(updatedApp.getPositionTitle());
            existing.setApplicationDate(updatedApp.getApplicationDate());
            existing.setStatus(updatedApp.getStatus());
            existing.setLocation(updatedApp.getLocation());
            existing.setNotes(updatedApp.getNotes());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Application does not exist with id:" + id));
    }

    public void deleteApplication(Long id){
        repository.deleteById(id);
    }
}