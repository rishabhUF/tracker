package risshar.service;

import org.springframework.stereotype.Service;
import risshar.entity.Vehicle;

import java.util.List;

@Service
public interface VehicleService {

    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    void create(Vehicle[] vehicle);
    Vehicle[] update( Vehicle[] vehicle);
    void delete(String id);
}
