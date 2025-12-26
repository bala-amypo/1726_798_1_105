package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Host;
import com.example.demo.model.VisitLog;
import com.example.demo.model.Visitor;
import com.example.demo.repository.HostRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitLogService;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    @Autowired
    private VisitLogRepository visitLogRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private HostRepository hostRepository;

    // =========================
    // EXISTING METHODS (KEEP)
    // =========================

    @Override
    public VisitLog checkIn(Long visitorId, Long hostId, String purpose) {

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        Host host = hostRepository.findById(hostId)
                .orElseThrow(() -> new RuntimeException("Host not found"));

        VisitLog log = new VisitLog();
        log.setVisitor(visitor);
        log.setHost(host);
        log.setPurpose(purpose);
        log.setAccessGranted(true);
        log.setCheckInTime(LocalDateTime.now());

        return visitLogRepository.save(log);
    }

    @Override
    public VisitLog checkOut(Long visitLogId) {

        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));

        if (log.getCheckOutTime() != null) {
            throw new RuntimeException("Visit already checked out");
        }

        log.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(log);
    }

    @Override
    public List<VisitLog> getActive() {
        return visitLogRepository.findByCheckOutTimeIsNull();
    }

    @Override
    public VisitLog getById(Long id) {
        return visitLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
    }

    // =========================
    // METHODS REQUIRED BY TESTS
    // =========================

    // Test calls: checkInVisitor(...)
    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        return checkIn(visitorId, hostId, purpose);
    }

    // Test calls: checkoutVisitor(...)
    public VisitLog checkoutVisitor(Long visitLogId) {
        return checkOut(visitLogId);
    }

    // Test calls: getActiveVisits()
    public List<VisitLog> getActiveVisits() {
        return getActive();
    }

    // Test calls: getVisit(...)
    public VisitLog getVisit(Long id) {
        return getById(id);
    }
}
