package risshar.entity;

import java.util.UUID;

public class Alert {
    String id;
    String vehicleVin;
    String priority;
    String alertMessage;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleVin() {
        return vehicleVin;
    }

    public void setVehicleVin(String vehicleVin) {
        this.vehicleVin = vehicleVin;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public Alert(String vehicleVin, String priority, String alertMessage)
    {
        this.id = UUID.randomUUID().toString();
        this.vehicleVin = vehicleVin;
        this.priority = priority;
        this.alertMessage = alertMessage;
    }
}
