package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Visitor visitor;

    @ManyToOne(optional = false)
    private Host host;

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    private String purpose;
    private Boolean accessGranted;
    private Boolean alertSent = false;

    public VisitLog() {}

    @PrePersist
    public void onCheckIn() {
        this.checkInTime = LocalDateTime.now();
    }

    // ---------- GETTERS ----------
    public Long getId() { return id; }
    public Visitor getVisitor() { return visitor; }
    public Host getHost() { return host; }
    public LocalDateTime getCheckInTime() { return checkInTime; }
    public LocalDateTime getCheckOutTime() { return checkOutTime; }
    public String getPurpose() { return purpose; }
    public Boolean getAccessGranted() { return accessGranted; }
    public Boolean getAlertSent() { return alertSent; }

    // ---------- SETTERS ----------
    public void setId(Long id) { this.id = id; }   // ⚠ required by tests
    public void setVisitor(Visitor visitor) { this.visitor = visitor; }
    public void setHost(Host host) { this.host = host; }
    public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; } // ✅ REQUIRED
    public void setCheckOutTime(LocalDateTime checkOutTime) { this.checkOutTime = checkOutTime; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public void setAccessGranted(Boolean accessGranted) { this.accessGranted = accessGranted; }
    public void setAlertSent(Boolean alertSent) { this.alertSent = alertSent; }
}
