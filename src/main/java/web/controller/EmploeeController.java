package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.Employee;
import web.service.EmploeeService;

import java.util.List;

@RestController
public class EmploeeController {

    @Autowired
    EmploeeService service;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return service.getEmploees();
    }

    @PostMapping("/employees")
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        service.add(employee);
        return service.getEmploees();
    }

    @GetMapping(value = "/employee/{id}")
    public Employee getEmployee(@PathVariable("id") long id) {
        return service.getEmploee(id);
    }

    @PatchMapping(value = "/employees")
    public List<Employee> editEmplyoee(@RequestBody Employee employee) {
        service.update(employee);
        return service.getEmploees();
    }
}
