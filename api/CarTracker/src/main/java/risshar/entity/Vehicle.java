package risshar.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll", query = "SELECT veh FROM Vehicle veh ORDER BY veh.make DESC"),
        @NamedQuery(name = "Vehicle.findOne", query = "SELECT veh FROM Vehicle veh where veh.vin=:paramVehicleId")
})
public class Vehicle {

    @Id
    private String vin;
    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private Double maxFuelVolume;
    private Date lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public Double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(Double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
