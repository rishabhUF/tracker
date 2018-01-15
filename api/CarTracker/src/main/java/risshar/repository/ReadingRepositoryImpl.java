package risshar.repository;

import org.springframework.stereotype.Repository;
import risshar.entity.Alert;
import risshar.entity.Reading;
import risshar.entity.Tire;
import risshar.entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Reading> findAllReadings() {
        TypedQuery<Reading> query=entityManager.createNamedQuery("Reading.findAllReading",Reading.class);
        List<Reading> resultList=query.getResultList();
        return resultList;

    }

    public List<Reading> findReadingsByVin(String vin) {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findReadingsByVin",Reading.class);
        query.setParameter("paramVehicleVin",vin);
        List<Reading> resultList = query.getResultList();
        return resultList;
    }

    public Reading findById(String id) {
        TypedQuery<Reading> query=entityManager.createNamedQuery("Reading.findOneReading",Reading.class);
        query.setParameter("paramVehicleId",id);
        List<Reading> resultList=query.getResultList();
        if(resultList!=null && resultList.size()==1)
            return resultList.get(0);
        else
            return  null;
    }


    public Reading createReadings(Reading readings, Tire tire) {
        TypedQuery<Vehicle> query=entityManager.createNamedQuery("Vehicle.findOne",Vehicle.class);
        query.setParameter("paramVehicleId",readings.getVin());
        Vehicle existingVehicle = query.getResultList().get(0);
        if((existingVehicle.getMaxFuelVolume()*0.1) > readings.getFuelVolume())
        {
            createAlert(readings.getVin(),"MEDIUM","Fuel is low");
        }
        if((existingVehicle.getRedlineRpm() < readings.getEngineRpm())) {
            createAlert(readings.getVin(),"HIGH","RPM is very high");
        }
        entityManager.persist(tire);
        entityManager.persist(readings);
        return readings;
    }

    public void updateReadings(Reading readings) {
        entityManager.merge(readings);
    }

    public void deleteReadings(String vehicleId) {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findOneReading",Reading.class);
        query.setParameter("paramVehicleId",vehicleId);
        Reading queryResult = query.getSingleResult();
        entityManager.remove(queryResult);
    }

    public void createAlert(String vehicleVin, String priority, String alertMessage) {
        Alert alert = new Alert(vehicleVin, priority, alertMessage);
        entityManager.persist(alert);

    }
}
