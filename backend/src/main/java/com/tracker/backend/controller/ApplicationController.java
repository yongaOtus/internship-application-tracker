package com.tracker.backend.controller;

import com.tracker.backend.model.InternshipApplication;
import com.tracker.backend.service.InternshipApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final InternshipApplicationService service;

    public ApplicationController(InternshipApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<InternshipApplication> getAllApplications(){
        return service.getAllApplications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternshipApplication> getApplication(@PathVariable Long id){
        Optional<InternshipApplication> app = service.getApplicationById(id);
        if(app.isPresent()){
            return ResponseEntity.ok(app.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<InternshipApplication> createApplication(@RequestBody InternshipApplication app){
        InternshipApplication created = service.createApplication(app);
        URI location = URI.create("/applications/" + created.getId());
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternshipApplication> updateApplication(@PathVariable Long id, @RequestBody InternshipApplication app){
        try {
            InternshipApplication updatedApp = service.updateApplication(id, app);
            return ResponseEntity.ok(updatedApp);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id){
        service.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
