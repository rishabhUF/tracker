package risshar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name= "findAllAlerts", query = "SELECT alert FROM Alert"),
        @NamedQuery(name= "findHighPriorityAlerts", query = "SELECT alert FROM Alert alert WHERE alert.priority = :paramsHigh"),
        @NamedQuery(name = "findAlertsByVin", query = "SELECT alert FROM Alert alert WHERE alert.vin = :paramVehicleVin")
})
public class Alert {
    @Id
    String id;
    String vehicleVin;
    String priority;
    String alertMessage;
    Date timestamp;

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

        this.timestamp = new Date();
        System.out.println(this.timestamp+"ALert is made");
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
