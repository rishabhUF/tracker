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

        if(readings.isEngineCoolantLow() || readings.isCheckEngineLightOn())
        {
            readingRepository.createAlert(readings.getVin(),"LOW","Engine Light is Low or Coolant is low");
        }
        if(tires.getFrontLeft() < 32 || tires.getFrontLeft() > 36 || tires.getFrontRight() < 32 || tires.getFrontRight() > 36
                || tires.getRearLeft() < 32 || tires.getRearLeft() > 36 || tires.getRearRight() < 32 || tires.getRearRight() > 36)
        {
            readingRepository.createAlert(readings.getVin(),"LOW", "Tire pressure is low than minimum level");
        }
        return readingRepository.createReadings(readings,tires);
    }

    public Reading updateReadings(Reading readings) {
        readingRepository.updateReadings(readings);

        return readings;
    }

    public void deleteReadings(String vehicleId) {
        readingRepository.deleteReadings(vehicleId);
    }
}
