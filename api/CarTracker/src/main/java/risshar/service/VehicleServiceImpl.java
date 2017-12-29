package risshar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import risshar.entity.Vehicle;
import risshar.repository.VehiclesRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehiclesRepository vehiclesRepository;


    public List<Vehicle> findAll() {
        return vehiclesRepository.findAll();
    }

    public Vehicle findOne(String id) {
        Vehicle existing = vehiclesRepository.findOne(id);
        if(existing == null)
        {
            //throw new ResourceNotFoundException("");
        }
        return existing;
    }

    @Transactional
    public void create(Vehicle[] vehicle) {
        for(Vehicle vehicle1 : vehicle)
        {
            vehiclesRepository.create(vehicle1);
        }

    }

    @Transactional
    public Vehicle[] update(Vehicle[] vehicle)
    {
        return vehiclesRepository.update(vehicle);
    }

    @Transactional
    public void delete(String id) {
        Vehicle existing=vehiclesRepository.findOne(id);

        if(existing==null){
            //throw new ResourceNotFoundException("Resource Not found with Vehicles id ="+i`d);
        }
        vehiclesRepository.delete(existing);

    }
}
