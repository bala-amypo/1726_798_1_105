package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Appointment;

public interface AppointmentService {

    // Existing methods
    Appointment create(Long visitorId, Long hostId, Appointment appointment);

    Appointment getById(Long id);

    List<Appointment> getByHost(Long hostId);

    List<Appointment> getByVisitor(Long visitorId);

    // ===== Methods REQUIRED by tests =====
    Appointment createAppointment(Long visitorId, Long hostId);

    Appointment getAppointment(Long id);

    List<Appointment> getAppointmentsForHost(Long hostId);

    List<Appointment> getAppointmentsForVisitor(Long visitorId);
}
