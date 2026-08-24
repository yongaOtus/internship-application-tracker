package com.tracker.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "internship_applications")
public class InternshipApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String positionTitle;

    private LocalDate applicationDate;

    private String status; // "APPLIED", "INTERVIEWING", "ACCEPTED", "REJECTED"

    private String location; // "Remote", "Hybrid", "On-site"

    @Column(columnDefinition = "TEXT")
    private String notes;

    public InternshipApplication(){}

    public InternshipApplication(String companyName, String
                                         positionTitle, LocalDate applicationDate,
                                 String status, String location, String notes) {
        this.companyName = companyName;
        this.positionTitle = positionTitle;
        this.applicationDate = applicationDate;
        this.status = status;
        this.location = location;
        this.notes = notes;
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

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
