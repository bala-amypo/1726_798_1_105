@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository alertRepo;
    private final VisitLogRepository visitLogRepo;

    public AlertNotificationServiceImpl(
            AlertNotificationRepository alertRepo,
            VisitLogRepository visitLogRepo) {
        this.alertRepo = alertRepo;
        this.visitLogRepo = visitLogRepo;
    }

    @Override
    public AlertNotification sendAlert(Long visitLogId) {
        VisitLog log = visitLogRepo.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));

        if (Boolean.TRUE.equals(log.getAlertSent())) {
            throw new RuntimeException("Alert already sent");
        }

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setAlertMessage("Visitor arrived");
        alert.setSentTo("HOST");

        log.setAlertSent(true);
        visitLogRepo.save(log);

        return alertRepo.save(alert);
    }

    @Override
    public AlertNotification getById(Long id) {
        return alertRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    @Override
    public List<AlertNotification> getAll() {
        return alertRepo.findAll();
    }

    // ===== test wrappers =====
    @Override
    public AlertNotification getAlert(Long id) {
        return getById(id);
    }

    @Override
    public List<AlertNotification> getAlerts() {
        return getAll();
    }
}
