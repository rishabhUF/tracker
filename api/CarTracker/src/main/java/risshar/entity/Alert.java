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

    public String getVehicleVin() {
        return vehicleVin;
    }

    public String getPriority() {
        return priority;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public Alert(String vehicleVin, String priority, String alertMessage)
    {

        this.id = UUID.randomUUID().toString();
        this.vehicleVin = vehicleVin;
        this.priority = priority;
        this.alertMessage = alertMessage;

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
