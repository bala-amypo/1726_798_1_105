package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/visits")
public class VisitLogController {

    @Autowired
    private VisitLogService visitLogService;

    @PostMapping("/checkin")
public VisitLog checkIn(@RequestParam Long visitorId,
                        @RequestParam Long hostId,
                        @RequestParam String purpose) {
    return visitLogService.checkIn(visitorId, hostId, purpose);
}


    @PostMapping("/checkout/{visitLogId}")
    public VisitLog checkOut(@PathVariable Long visitLogId) {
        return visitLogService.checkOut(visitLogId);
    }

    @GetMapping("/active")
    public List<VisitLog> getActiveVisits() {
        return visitLogService.getActive();
    }

    @GetMapping("/{id}")
    public VisitLog getVisit(@PathVariable Long id) {
        return visitLogService.getById(id);
    }
}
