package com.ironhack.labjavajpa.service;

import com.ironhack.labjavajpa.model.Customer;
import com.ironhack.labjavajpa.model.enums.CustomerStatus;
import com.ironhack.labjavajpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getCustomersByStatus(CustomerStatus status) {
        return customerRepository.findCustomerByStatus(status);
    }

    public List<Customer> getCustomersWithMileageAbove(Long mileage) {
        return customerRepository.findByTotalMileageGreaterThan(mileage);
    }
}