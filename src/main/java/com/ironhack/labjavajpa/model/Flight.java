package com.ironhack.labjavajpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    private String aircraft;
    private int seatsNumber;
    private int flightMileage;
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<FlightBooking> bookings;

    public Flight() {
    }

    public Flight(String flightNumber, String aircraft, int seatsNumber, int flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.seatsNumber = seatsNumber;
        this.flightMileage = flightMileage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public int getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(int flightMileage) {
        this.flightMileage = flightMileage;
    }
}
