package risshar.controller;

import org.springframework.web.bind.annotation.*;
import risshar.entity.Reading;

import java.util.List;

@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Reading> findAllReadings()
    {
        System.out.println("Inside the findAll ReadingsController");
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public Reading findOneReadings(@PathVariable("id") String ReadingId)
    {
        System.out.println("Inside the findOne ReadingsController");
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Reading createReadings(@RequestBody Reading reading)
    {
        System.out.println("Inside the create ReadingsController");
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Reading updateReadings(@RequestBody Reading reading)
    {
        System.out.println("Inside the update ReadingsController");
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/{id}")
    public void deleteReadings(@PathVariable("id") String ReadingId)
    {
        System.out.println("Inside the delete ReadingsController");
        return;
    }

}
