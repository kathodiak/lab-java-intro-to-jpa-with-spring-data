package com.ironhack.labjavajpa;

import com.ironhack.labjavajpa.model.Customer;
import com.ironhack.labjavajpa.model.Flight;
import com.ironhack.labjavajpa.model.FlightBooking;
import com.ironhack.labjavajpa.model.enums.CustomerStatus;
import com.ironhack.labjavajpa.repository.CustomerRepository;
import com.ironhack.labjavajpa.repository.FlightBookingRepository;
import com.ironhack.labjavajpa.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabJavaJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabJavaJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CustomerRepository customerRepository,
                          FlightRepository flightRepository,
                          FlightBookingRepository flightBookingRepository) {
        return args -> {
            Customer alice = customerRepository.save(new Customer("Alice", CustomerStatus.GOLD, 120000));
            Customer bob = customerRepository.save(new Customer("Bob", CustomerStatus.SILVER, 12500));
            Customer rob = customerRepository.save(new Customer("Rob", CustomerStatus.NONE, 40560));
            Flight flight1 = flightRepository.save(new Flight("AB123", "Boeing 122", 300, 400));
            Flight flight2 = flightRepository.save(new Flight("AB124", "Boeing 747", 500, 450));
            Flight flight3 = flightRepository.save(new Flight("BB223", "Airbus 500", 1100, 1200));
            flightBookingRepository.save(new FlightBooking(alice, flight1));
            flightBookingRepository.save(new FlightBooking(bob, flight2));
            flightBookingRepository.save(new FlightBooking(rob, flight3));
//            flightBookingRepository.save(new FlightBooking(alice.getId(), flight1.getId()));
//            flightBookingRepository.save(new FlightBooking(bob.getId(), flight2.getId()));
//            flightBookingRepository.save(new FlightBooking(rob.getId(), flight3.getId()));
        };
    }

}
