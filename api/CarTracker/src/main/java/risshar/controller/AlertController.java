package risshar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import risshar.entity.Alert;
import risshar.service.AlertService;

import java.util.List;

@RestController
@RequestMapping(value = "/alerts")
@CrossOrigin(origins = {"http://mocker.egen.io","http://localhost:8080"}, maxAge = 3600)
public class AlertController {

    // ENDPOINTS TO SUPPORT MY FRONTEND REQUIREMENTS
    @Autowired
    AlertService alertService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> findAllAlerts()
    {
        return alertService.findAllAlerts();
    }

    @RequestMapping(method = RequestMethod.GET, value="/high")
    public List<Alert> findHighPriorityAlerts()
    {
        return alertService.findHighPriorityAlerts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<Alert> findAlertsByVin(@PathVariable("vin") String vehicleVin)
    {
        return alertService.findAlertsByVin(vehicleVin);
    }
}
