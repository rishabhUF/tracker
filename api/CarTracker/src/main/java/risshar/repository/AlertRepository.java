package risshar.repository;

import org.springframework.stereotype.Repository;
import risshar.entity.Alert;

import java.util.List;

@Repository
public interface AlertRepository {
    List<Alert> findAllAlerts();

    List<Alert> findHighPriorityAlerts();

    List<Alert> findAlertsByVin(String vin);
}
