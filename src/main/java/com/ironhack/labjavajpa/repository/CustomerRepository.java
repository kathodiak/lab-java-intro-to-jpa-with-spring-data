package com.ironhack.labjavajpa.repository;

import com.ironhack.labjavajpa.model.Customer;
import com.ironhack.labjavajpa.model.FlightBooking;
import com.ironhack.labjavajpa.model.enums.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByStatus(CustomerStatus status);

    //Find customer by status
    @Query("SELECT c FROM Customer c WHERE c.status = :status")
    List<Customer> findCustomerByStatus(CustomerStatus status);

    // Find customers with mileage above ...... miles
    List<Customer> findByTotalMileageGreaterThan(Long mileage);
}
