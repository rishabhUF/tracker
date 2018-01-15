package risshar.service;

import org.springframework.stereotype.Service;
import risshar.entity.Reading;

import java.util.List;

@Service
public interface ReadingsService {

    List<Reading> findAllReadings();

    List<Reading> findReadingByVin(String vin);

    Reading findById(String vin);

    Reading createReadings(Reading readings);

    Reading updateReadings(Reading readings);

    void deleteReadings(String vehicleId);
}
