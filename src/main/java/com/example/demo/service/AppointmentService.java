public interface AppointmentService {

    Appointment create(Long visitorId, Long hostId, Appointment appointment);

    Appointment getById(Long id);

    List<Appointment> getByHost(Long hostId);

    List<Appointment> getByVisitor(Long visitorId);

    // ===== required by tests =====
    Appointment createAppointment(Long visitorId, Long hostId);

    Appointment getAppointment(Long id);

    List<Appointment> getAppointmentsForHost(Long hostId);

    List<Appointment> getAppointmentsForVisitor(Long visitorId);
}
