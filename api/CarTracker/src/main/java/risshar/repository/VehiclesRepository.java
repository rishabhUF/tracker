package risshar.repository;

import org.springframework.stereotype.Repository;
import risshar.entity.Vehicle;

import java.util.List;

@Repository
public interface VehiclesRepository {

    List<Vehicle> findAll();
    Vehicle findOne(String id);
    Vehicle create(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    Vehicle[] update(Vehicle[] vehicles);
    void delete(Vehicle vehicle);
}
