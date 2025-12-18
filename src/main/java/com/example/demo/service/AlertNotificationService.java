package com.example.demo.service;

import java.util.List;
import com.example.demo.model.AlertNotification;

public interface AlertNotificationService {
    AlertNotification getById(Long id);
    List<AlertNotification> getAll();
}
