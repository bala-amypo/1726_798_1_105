package com.example.demo.service;

import java.util.List;
import com.example.demo.model.VisitLog;

public interface VisitLogService {

    VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose);

    VisitLog checkOutVisitor(Long visitLogId);

    List<VisitLog> getActiveVisits();

    VisitLog getVisitLog(Long id);
}
