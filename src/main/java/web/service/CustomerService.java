package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CustomerDao;
import web.model.Customer;

import java.util.List;

@Service
public class CustomerService {
    CustomerDao dao;

    @Autowired
    public CustomerService(CustomerDao dao) {
        this.dao = dao;
    }

    public CustomerService() {
    }

    @Transactional
    public List<Customer> getCustomers() {
        return dao.getCustomers();
    }

    @Transactional
    public void add(Customer customer) {
        dao.add(customer);
    }

    @Transactional
    public void delete(long id) {
        dao.delete(id);
    }

    @Transactional
    public void update(Customer customer) {
        dao.update(customer);
    }

    @Transactional
    public Customer getCustomer(long id) {
        return dao.getCustomer(id);
    }
}
