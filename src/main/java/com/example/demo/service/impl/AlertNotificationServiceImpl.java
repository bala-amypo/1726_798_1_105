package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository alertNotificationRepository;
    private final VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl(
            AlertNotificationRepository alertNotificationRepository,
            VisitLogRepository visitLogRepository) {
        this.alertNotificationRepository = alertNotificationRepository;
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public AlertNotification sendAlert(Long visitLogId) {
        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));

        if (log.getAlertSent()) {
            throw new RuntimeException("Alert already sent");
        }

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setAlertMessage("Visitor arrived");
        alert.setSentTo("HOST");

        log.setAlertSent(true);
        visitLogRepository.save(log);

        return alertNotificationRepository.save(alert);
    }

    @Override
    public AlertNotification getById(Long id) {
        return alertNotificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    @Override
    public List<AlertNotification> getAll() {
        return alertNotificationRepository.findAll();
    }
}
