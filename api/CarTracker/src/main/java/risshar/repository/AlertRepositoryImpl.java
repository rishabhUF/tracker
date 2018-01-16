package risshar.repository;

import org.springframework.stereotype.Repository;
import risshar.entity.Alert;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
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

    // return all the alerts within 20 mins and particular to number.
    public List<Alert> findAlertsByVinRepo(String vin) {
        int secs = 20 * 60; //All the alerts till 20 min before current time.
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAlertsByVin",Alert.class);
        query.setParameter("paramVehicleVin",vin);
        query.setParameter("paramTimestamp",new Date(System.currentTimeMillis() - secs*1000), TemporalType.DATE);

        List<Alert> resultList=query.getResultList();
        Alert result = resultList.get(0);
        System.out.println("hello");
        System.out.println(result);
        return resultList;
    }
}