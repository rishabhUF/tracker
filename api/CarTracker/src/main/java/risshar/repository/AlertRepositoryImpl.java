package risshar.repository;

import org.springframework.stereotype.Repository;
import risshar.entity.Alert;
import risshar.entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Alert> findAllAlerts() {
        Date currentDate = new Date();
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAllAlerts",Alert.class);
        query.setParameter("paramCurrentTime",currentDate);
        List<Alert> resultList=query.getResultList();
        return resultList;
    }

    public List<Alert> findHighPriorityAlerts() {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findHighPriorityAlerts",Alert.class);
        query.setParameter("paramHigh","HIGH");
        List<Alert> resultList=query.getResultList();
        return resultList;
    }

    public List<Alert> findAlertsByVin(String vin) {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAlertsByVin",Alert.class);
        query.setParameter("paramVehicleVin",vin);
        List<Alert> resultList=query.getResultList();
        return resultList;
    }
}
