package risshar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import risshar.entity.Vehicle;
import risshar.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;
    @RequestMapping(method = RequestMethod.GET)

    //All vehicles endpoints.
    public List<Vehicle> findAll()
    {
        System.out.println("Inside findAll VehicleController");
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public Vehicle findOne(@PathVariable("id") String vehicleId)
    {
        System.out.println("Inside findOne VehicleController");
        return service.findOne(vehicleId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Vehicle create(@RequestBody Vehicle[] vehicles)
    {
        System.out.println("Inside create VehicleController");
        return service.create(vehicles);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> update(@RequestBody Vehicle[] vehicles)
    {
        System.out.println("Inside update PUT REQUEST VehicleController");
        return service.update(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/{id}")
    public void delete(@PathVariable("id") String vehicleId)
    {
        System.out.println("Inside Delete VehicleController");
        return service.delete(vehicleId);
    }
}