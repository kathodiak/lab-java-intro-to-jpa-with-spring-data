package com.ironhack.labjavajpa.controller;

import com.ironhack.labjavajpa.model.Customer;
import com.ironhack.labjavajpa.model.FlightBooking;
import com.ironhack.labjavajpa.repository.CustomerRepository;
import com.ironhack.labjavajpa.service.CustomerService;
import com.ironhack.labjavajpa.service.FlightBookingService;
import org.aspectj.weaver.ast.Literal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flightdata/bookings")
public class FlightBookingController {
    private final FlightBookingService flightBookingService;

    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @GetMapping
    public List<FlightBooking> findAll() {
        return flightBookingService.findAll();
    }

    // GET /flightdata/bookings/customer_id?customer_id={customerId}
    @GetMapping("/customerId")
    public List<FlightBooking> findBookingsByCustomerId(@RequestParam("customerId") Long customerId) {
        return flightBookingService.findBookingsByCustomerId(customerId);
    }

    // GET /flightdata/bookings/flight_id?flight_id={flightId}
    @GetMapping("/fligthId")
    public List<FlightBooking> findBookingsByFlightId(@RequestParam("flightId") Long flightId) {
        return flightBookingService.findBookingsByFlightId(flightId);
    }
}
