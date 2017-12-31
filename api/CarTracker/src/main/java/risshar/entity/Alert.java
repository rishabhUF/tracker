package risshar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Alert {
    @Id
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

    public Alert()
    {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
