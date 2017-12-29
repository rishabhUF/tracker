package risshar.service;

import risshar.entity.Reading;

import java.util.List;

public interface ReadingsService {

    List<Reading> findAllReadings();

    Reading findById(String vin);

    Reading createReadings(Reading readings);

    void updateReadings(Reading readings);

    void deleteReadings(String vehicleId);
}
