package risshar.service;

import org.springframework.stereotype.Service;
import risshar.entity.Alert;
import risshar.repository.AlertRepository;

import java.util.List;
@Service
public class AlertServiceImpl implements AlertService {

    AlertRepository alertRepository;
    public List<Alert> findAllAlerts() {
        return alertRepository.findAllAlerts();
    }

    public List<Alert> findHighPriorityAlerts() {
        return alertRepository.findHighPriorityAlerts();
    }

    public List<Alert> findAlertsByVin(String vin) {
        return alertRepository.findAlertsByVin(vin);
    }
}
