package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.model.Host;
import com.example.demo.model.Visitor;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.HostRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final VisitorRepository visitorRepository;
    private final HostRepository hostRepository;

    public AppointmentServiceImpl(
            AppointmentRepository appointmentRepository,
            VisitorRepository visitorRepository,
            HostRepository hostRepository) {
        this.appointmentRepository = appointmentRepository;
        this.visitorRepository = visitorRepository;
        this.hostRepository = hostRepository;
    }

    // =========================
    // EXISTING METHODS (KEEP)
    // =========================

    @Override
    public Appointment create(Long visitorId, Long hostId, Appointment appointment) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
        Host host = hostRepository.findById(hostId)
                .orElseThrow(() -> new RuntimeException("Host not found"));

        appointment.setVisitor(visitor);
        appointment.setHost(host);

        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Override
    public List<Appointment> getByHost(Long hostId) {
        return appointmentRepository.findByHostId(hostId);
    }

    @Override
    public List<Appointment> getByVisitor(Long visitorId) {
        return appointmentRepository.findByVisitorId(visitorId);
    }

    // =========================
    // METHODS REQUIRED BY TESTS
    // =========================

    // Test calls: createAppointment(visitorId, hostId)
    public Appointment createAppointment(Long visitorId, Long hostId) {
        Appointment appointment = new Appointment();
        return create(visitorId, hostId, appointment);
    }

    // Test calls: getAppointment(id)
    public Appointment getAppointment(Long id) {
        return getById(id);
    }

    // Test calls: getAppointmentsForHost(hostId)
    public List<Appointment> getAppointmentsForHost(Long hostId) {
        return getByHost(hostId);
    }

    // Test calls: getAppointmentsForVisitor(visitorId)
    public List<Appointment> getAppointmentsForVisitor(Long visitorId) {
        return getByVisitor(visitorId);
    }
}
