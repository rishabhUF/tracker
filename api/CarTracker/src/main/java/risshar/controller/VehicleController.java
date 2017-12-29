package risshar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import risshar.entity.Vehicle;
import risshar.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
@CrossOrigin(origins = {"http://mocker.egen.io","http://localhost:8080"}, maxAge = 3600)
public class VehicleController {

    @Autowired
    VehicleService vehicleService;
    @RequestMapping(method = RequestMethod.GET)

    //All vehicles endpoints.
    public List<Vehicle> findAll()
    {
        System.out.println("Inside findAll VehicleController");
        return vehicleService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public Vehicle findOne(@PathVariable("id") String vehicleId)
    {
        System.out.println("Inside findOne VehicleController");
        return vehicleService.findOne(vehicleId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Vehicle create(@RequestBody Vehicle[] vehicles)
    {
        System.out.println("Inside create VehicleController");
        //return service.create(vehicles);
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Vehicle[] update(@RequestBody Vehicle[] vehicles)
    {
        System.out.println("Inside update PUT REQUEST VehicleController");
        return vehicleService.update(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/{id}")
    public void delete(@PathVariable("id") String vehicleId)
    {
        System.out.println("Inside Delete VehicleController");
        vehicleService.delete(vehicleId);
    }
}