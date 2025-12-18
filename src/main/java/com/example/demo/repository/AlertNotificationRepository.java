package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AlertNotification;

@Repository
public interface AlertNotificationRepository extends JpaRepository<AlertNotification, Long> {
}
