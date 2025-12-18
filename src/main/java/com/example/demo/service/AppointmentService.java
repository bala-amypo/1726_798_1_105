package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Appointment;

public interface AppointmentService {

    Appointment createAppointment(Long visitorId, Long hostId, Appointment appointment);

    Appointment getAppointment(Long id);

    List<Appointment> getAppointmentsForHost(Long hostId);

    List<Appointment> getAppointmentsForVisitor(Long visitorId);
}
