package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.Customer;
import web.service.CustomerService;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @PostMapping("/customers")
    public List<Customer> addCustomer(@RequestBody Customer customer) {
        service.add(customer);
        return service.getCustomers();
    }

    @GetMapping(value = "/customer/{id}")
    public Customer getCustomer(@PathVariable("id") long id) {
        return service.getCustomer(id);
    }

    @PatchMapping(value = "/customers")
    public List<Customer> editCustomer(@RequestBody Customer customer) {
        service.update(customer);
        return service.getCustomers();
    }
}
