public interface VisitLogService {

    VisitLog checkIn(Long visitorId, Long hostId, String purpose);

    VisitLog checkoutVisitor(Long visitLogId);  // REQUIRED

    VisitLog getVisitLog(Long id);               // REQUIRED
}
