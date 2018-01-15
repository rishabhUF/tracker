package risshar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import risshar.entity.Reading;
import risshar.entity.Tire;
import risshar.exception.BadRequestException;
import risshar.exception.ResourceNotFoundException;
import risshar.repository.ReadingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ReadingsServiceImpl implements ReadingsService {
    @Autowired
    ReadingRepository readingRepository;

    public List<Reading> findAllReadings() {
        return readingRepository.findAllReadings();
    }

    public List<Reading> findReadingByVin(String vin) {
        return readingRepository.findReadingsByVin(vin);
    }

    public Reading findById(String Id) {
        Reading existingReading = readingRepository.findById(Id);
        if(existingReading == null)
        {
            throw new ResourceNotFoundException("Resource Not found");
        }
        return existingReading;
    }

    @Transactional
    public Reading createReadings(Reading readings) {
        Tire tires=readings.getTires();

        if(tires == null)
        {
            throw new BadRequestException("Tires are not given in reading");
        }
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

    @Transactional
    public Reading updateReadings(Reading readings) {
        readingRepository.updateReadings(readings);

        return readings;
    }

    @Transactional
    public void deleteReadings(String vehicleId) {
        readingRepository.deleteReadings(vehicleId);
    }
}
