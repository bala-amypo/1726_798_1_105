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

    private final VisitLogRepository visitLogRepo;
    private final VisitorRepository visitorRepo;
    private final HostRepository hostRepo;

    public VisitLogServiceImpl(
            VisitLogRepository visitLogRepo,
            VisitorRepository visitorRepo,
            HostRepository hostRepo) {
        this.visitLogRepo = visitLogRepo;
        this.visitorRepo = visitorRepo;
        this.hostRepo = hostRepo;
    }

    @Override
    public VisitLog checkIn(Long visitorId, Long hostId, String purpose) {
        Visitor visitor = visitorRepo.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        Host host = hostRepo.findById(hostId)
                .orElseThrow(() -> new RuntimeException("Host not found"));

        VisitLog log = new VisitLog();
        log.setVisitor(visitor);
        log.setHost(host);
        log.setPurpose(purpose);
        log.setAccessGranted(true);

        return visitLogRepo.save(log);
    }

    @Override
    public VisitLog checkOut(Long visitLogId) {
        VisitLog log = visitLogRepo.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));

        log.setCheckOutTime(LocalDateTime.now());
        return visitLogRepo.save(log);
    }

    @Override
    public List<VisitLog> getActive() {
        return visitLogRepo.findByCheckOutTimeIsNull();
    }

    @Override
    public VisitLog getById(Long id) {
        return visitLogRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
    }

    // ===== test wrappers =====
    @Override
    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        return checkIn(visitorId, hostId, purpose);
    }

    @Override
    public VisitLog checkoutVisitor(Long visitLogId) {
        return checkOut(visitLogId);
    }

    @Override
    public List<VisitLog> getActiveVisits() {
        return getActive();
    }

    @Override
    public VisitLog getVisit(Long id) {
        return getById(id);
    }
}
