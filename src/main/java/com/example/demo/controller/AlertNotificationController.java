package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.AlertNotification;
import com.example.demo.service.AlertNotificationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/alerts")
public class AlertNotificationController {

    @Autowired
    private AlertNotificationService alertService;

    @PostMapping("/send/{visitLogId}")
    public AlertNotification sendAlert(@PathVariable Long visitLogId) {
        return alertService.sendAlert(visitLogId);
    }

    @GetMapping("/{id}")
    public AlertNotification getAlert(@PathVariable Long id) {
        return alertService.getById(id);
    }

    @GetMapping
    public List<AlertNotification> getAllAlerts() {
        return alertService.getAll();
    }
}
