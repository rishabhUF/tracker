package risshar.service;

import org.springframework.stereotype.Service;
import risshar.entity.Alert;

import java.util.List;

@Service
public interface AlertService {

    List<Alert> findAllAlerts();

    List<Alert> findHighPriorityAlerts();

    List<Alert> findAlertsByVin(String vin);
}
