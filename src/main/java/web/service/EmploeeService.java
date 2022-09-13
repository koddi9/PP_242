package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.EmploeeDao;
import web.model.Employee;

import java.util.List;

@Service
public class EmploeeService {

    EmploeeDao dao;

    @Autowired
    public EmploeeService(EmploeeDao dao) {
        this.dao = dao;
    }

    public EmploeeService() {
    }

    @Transactional
    public List<Employee> getEmploees() {
        return dao.getEmploees();
    }

    @Transactional
    public void add(Employee employee) {
        dao.add(employee);
    }

    @Transactional
    public void delete(long id) {
        dao.delete(id);
    }

    @Transactional
    public void update(Employee employee) {
        dao.update(employee);
    }

    @Transactional
    public Employee getEmploee(long id) {
        return dao.getEmploee(id);
    }
}
