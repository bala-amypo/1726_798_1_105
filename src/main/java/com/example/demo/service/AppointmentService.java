package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Appointment;

public interface AppointmentService {
    Appointment create(Long visitorId, Long hostId);
    List<Appointment> getByHost(Long hostId);
    List<Appointment> getByVisitor(Long visitorId);
    Appointment getById(Long id);
}
