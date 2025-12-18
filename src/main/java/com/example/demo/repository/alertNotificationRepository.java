package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AlertNotification;

@Repository
public interface AlertNotificationRepo extends JpaRepository<AlertNotification, Long> {
}
