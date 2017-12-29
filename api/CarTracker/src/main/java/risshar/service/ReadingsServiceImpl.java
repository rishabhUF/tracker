package risshar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import risshar.entity.Reading;
import risshar.entity.Tire;
import risshar.repository.ReadingRepository;

import java.util.List;

@Repository
public class ReadingsServiceImpl implements ReadingsService {
    @Autowired
    ReadingRepository readingRepository;

    public List<Reading> findAllReadings() {
        return readingRepository.findAllReadings();
    }

    public Reading findById(String Id) {
        Reading existingReading = readingRepository.findById(Id);
        if(existingReading == null)
        {
            //throw new ResourceNotFoundException("");
        }
        return existingReading;
    }

    public Reading createReadings(Reading readings) {
        Tire tires=readings.getTire();

        
        return readingRepository.createReadings(readings,tires);
    }

    public void updateReadings(Reading readings) {
        readingRepository.updateReadings(readings);

    }

    public void deleteReadings(String vehicleId) {
        readingRepository.deleteReadings(vehicleId);
    }
}
