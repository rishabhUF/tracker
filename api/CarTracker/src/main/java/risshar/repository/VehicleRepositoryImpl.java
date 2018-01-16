package risshar.repository;

import org.springframework.stereotype.Repository;
import risshar.entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehiclesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAll() {

        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        List<Vehicle> resultList = query.getResultList();
        return resultList;
    }

    public Vehicle findOne(String id) {

        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findOne", Vehicle.class);
        query.setParameter("paramVehicleId", id);

        List<Vehicle> resultList=query.getResultList();

        if(resultList!=null && resultList.size()==1)
            return resultList.get(0);
        else
            return  null;
    }

    public Vehicle create(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return  vehicle;
    }

    public Vehicle update(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    public Vehicle[] update(Vehicle[] vehicles) {
        for(Vehicle veh : vehicles)
            entityManager.merge(veh);
        return vehicles;
    }


    public void delete(Vehicle vehicle) {
        TypedQuery<Vehicle> query=entityManager.createNamedQuery("Vehicle.findOne",Vehicle.class);
        query.setParameter("paramVehicleId",vehicle.getVin());

        Vehicle existing=query.getResultList().get(0);

        entityManager.remove(existing);
    }
}
