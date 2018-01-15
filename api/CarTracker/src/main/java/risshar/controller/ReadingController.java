package risshar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import risshar.entity.Reading;
import risshar.service.ReadingsService;

import java.util.List;

@RestController
@RequestMapping(value = "/readings")
@CrossOrigin(origins = {"http://mocker.egen.io","http://localhost:8080"}, maxAge = 3600)

public class ReadingController {

    @Autowired
    ReadingsService readingsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reading> findAllReadings()
    {
        return readingsService.findAllReadings();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public Reading findOneReadings(@PathVariable("id") String readingId)
    {
        return readingsService.findById(readingId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Reading createReadings(@RequestBody Reading reading)
    {
        return readingsService.createReadings(reading);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Reading updateReadings(@RequestBody Reading reading)
    {
        return readingsService.updateReadings(reading);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/{id}")
    public void deleteReadings(@PathVariable("id") String readingId)
    {
        readingsService.deleteReadings(readingId);
    }


    //Get endpoints for the UI readings
    @RequestMapping(method = RequestMethod.GET, value="/{vin}")
    public List<Reading> findReadingsByVin(@PathVariable("vin") String readingVin)
    {
        return readingsService.findReadingByVin(readingVin);
    }
}
