package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/{visitorId}/{hostId}")
    public Appointment createAppointment(
            @PathVariable Long visitorId,
            @PathVariable Long hostId) {
        return appointmentService.create(visitorId, hostId);
    }

    @GetMapping("/host/{hostId}")
    public List<Appointment> getByHost(@PathVariable Long hostId) {
        return appointmentService.getByHost(hostId);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<Appointment> getByVisitor(@PathVariable Long visitorId) {
        return appointmentService.getByVisitor(visitorId);
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.getById(id);
    }
}
