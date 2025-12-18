package com.example.demo.service;

import java.util.List;
import com.example.demo.model.VisitLog;

public interface VisitLogService {
    VisitLog checkIn(Long visitorId, Long hostId);
    VisitLog checkOut(Long visitLogId);
    List<VisitLog> getActive();
    VisitLog getById(Long id);
}

