package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.VisitLog;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    List<VisitLog> findByCheckOutTimeIsNull();

    List<VisitLog> findByVisitorId(Long visitorId);

    List<VisitLog> findByHostId(Long hostId);
}
