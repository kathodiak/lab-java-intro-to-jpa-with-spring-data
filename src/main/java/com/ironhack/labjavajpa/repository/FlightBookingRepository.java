package com.ironhack.labjavajpa.repository;

import com.ironhack.labjavajpa.model.Flight;
import com.ironhack.labjavajpa.model.FlightBooking;
import com.ironhack.labjavajpa.model.enums.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {

    // Find booking by customer ID
    List<FlightBooking> findFlightBookingByCustomerId(Long customerId);

    // Find booking by flight ID
    List<FlightBooking> findFlightBookingByFlightId(Long flightId);

    Flight flight(Flight flight);
}
