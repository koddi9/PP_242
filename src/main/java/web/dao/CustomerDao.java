package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerDao {
    @PersistenceContext(unitName = "getEntityManagerFactory")
    private EntityManager entityManager;

    public void add(Customer customer) {
        entityManager.persist(customer);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> getCustomers() {
        return entityManager.createQuery("from Customer").getResultList();
    }

    public void delete(long id) {
        entityManager.remove(getCustomer(id));
    }

    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    public Customer getCustomer(long id) {
        return entityManager.find(Customer.class,id);
    }
}
