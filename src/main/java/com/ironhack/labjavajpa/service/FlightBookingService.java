package com.ironhack.labjavajpa.service;

import com.ironhack.labjavajpa.model.FlightBooking;
import com.ironhack.labjavajpa.repository.CustomerRepository;
import com.ironhack.labjavajpa.repository.FlightBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightBookingService {
    private final FlightBookingRepository flightBookingRepository;

    public FlightBookingService(FlightBookingRepository flightBookingRepository) {
        this.flightBookingRepository = flightBookingRepository;
    }

    public List<FlightBooking> findAll() {
        return flightBookingRepository.findAll();
    }

    public List<FlightBooking> findBookingsByCustomerId(Long customerId) {
        return flightBookingRepository.findFlightBookingByCustomerId(customerId);
    }

    public List<FlightBooking> findBookingsByFlightId(Long flightId) {
        return flightBookingRepository.findFlightBookingByFlightId(flightId);
    }
}
