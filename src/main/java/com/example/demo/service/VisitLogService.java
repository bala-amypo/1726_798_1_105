package com.example.demo.service;

import java.util.List;
import com.example.demo.model.VisitLog;

public interface VisitLogService {

    VisitLog checkIn(Long visitorId, Long hostId, String purpose);

    VisitLog checkOut(Long visitLogId);

    List<VisitLog> getActive();

    VisitLog getById(Long id);

    // ===== required by tests & controllers =====
    VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose);

    VisitLog checkoutVisitor(Long visitLogId);

    List<VisitLog> getActiveVisits();

    VisitLog getVisit(Long id);
}
