package risshar.repository;

import org.springframework.stereotype.Repository;
import risshar.entity.Alert;
import risshar.entity.Reading;
import risshar.entity.Tire;

import java.util.List;

@Repository
public interface ReadingRepository {

    List<Reading> findAllReadings();

    Reading findById(String id);

    Reading createReadings(Reading readings, Tire tire);

    void updateReadings(Reading readings);

    void deleteReadings(String vehicleId);

    // Alerts Function definitions
    void createAlert(String vehicleVin, String priority, String alertMessage);

}
