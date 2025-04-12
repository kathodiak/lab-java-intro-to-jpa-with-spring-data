package com.ironhack.labjavajpa.controller;

import com.ironhack.labjavajpa.model.Customer;
import com.ironhack.labjavajpa.model.enums.CustomerStatus;
import com.ironhack.labjavajpa.repository.CustomerRepository;
import com.ironhack.labjavajpa.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flightdata/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
    }

    // GET /flightdata/customers
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    // GET /flightdata/customers/status?status={status}
    @GetMapping("/status")
    public List<Customer> getCustomersByStatus(@RequestParam("status")CustomerStatus status) {
        return customerService.getCustomersByStatus(status);
    }

    // GET /flightdata/customers/mileage?mileage={mileage}
    @GetMapping("/mileage")
    public List<Customer> getCustomersWithMileageAbove(@RequestParam("mileage") Long mileage) {
        return customerService.getCustomersWithMileageAbove(mileage);
    }
}