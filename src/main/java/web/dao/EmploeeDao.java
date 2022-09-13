package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmploeeDao {
    @PersistenceContext(unitName = "getEntityManagerFactory")
    private EntityManager entityManager;


    public void add(Employee employee) {
        entityManager.persist(employee);
    }


    @SuppressWarnings("unchecked")
    public List<Employee> getEmploees() {
        return entityManager.createQuery("from Employee").getResultList();
    }


    public void delete(long id) {
        entityManager.remove(getEmploee(id));
    }


    public void update(Employee employee) {
        entityManager.merge(employee);
    }


    public Employee getEmploee(long id) {
        return entityManager.find(Employee.class,id);
    }
}
