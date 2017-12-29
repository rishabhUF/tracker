package risshar.repository;

import org.springframework.stereotype.Repository;
import risshar.entity.Reading;
import risshar.entity.Tire;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    public Reading findById(String id) {
        TypedQuery<Reading> query=entityManager.createNamedQuery("Reading.findOneReading",Reading.class);//createQuery("SELECT emp FROM  Employee emp where emp.email=:paramEmail",Employee.class);
        query.setParameter("paramVehicleId",id);
        List<Reading> resultList=query.getResultList();
        if(resultList!=null && resultList.size()==1)
            return resultList.get(0);
        else
            return  null;
    }

    public Reading createReadings(Reading readings, Tire tire) {
        entityManager.persist(tire);
        readings.setTire(tire);
        entityManager.persist(readings);
        return readings;
    }

    public void updateReadings(Reading readings) {
        entityManager.merge(readings);
    }

    public void deleteReadings(String vehicleId) {

    }
}
