package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private VisitLog visitLog;

    private String sentTo;

    private String alertMessage;

    private LocalDateTime sentAt;

    public AlertNotification() {}

    @PrePersist
    public void onSend() {
        this.sentAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public VisitLog getVisitLog() {
        return visitLog;
    }

    public String getSentTo() {
        return sentTo;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setVisitLog(VisitLog visitLog) {
        this.visitLog = visitLog;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }
}
