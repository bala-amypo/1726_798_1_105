package com.example.demo.service;

import java.util.List;
import com.example.demo.model.AlertNotification;

public interface AlertNotificationService {

    AlertNotification sendAlert(Long visitLogId);

    AlertNotification getAlert(Long id);

    List<AlertNotification> getAllAlerts();
}
