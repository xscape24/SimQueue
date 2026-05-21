package com.simqueue.simqueue.simulation.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "simulation_results")
public class SimulationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_of_cashiers")
    private int numOfCashiers;

    @Column(name = "num_of_customers")
    private int numOfCustomers;

    @Column(name = "average_service_time_seconds")
    private double averageServiceTimeSeconds;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Hibernate requires a no-arg constructor
    public SimulationResult() {}

    public SimulationResult(int numOfCashiers, int numOfCustomers, double averageServiceTimeSeconds) {
        this.numOfCashiers = numOfCashiers;
        this.numOfCustomers = numOfCustomers;
        this.averageServiceTimeSeconds = averageServiceTimeSeconds;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getNumOfCashiers() { return numOfCashiers; }
    public void setNumOfCashiers(int numOfCashiers) { this.numOfCashiers = numOfCashiers; }

    public int getNumOfCustomers() { return numOfCustomers; }
    public void setNumOfCustomers(int numOfCustomers) { this.numOfCustomers = numOfCustomers; }

    public double getAverageServiceTimeSeconds() { return averageServiceTimeSeconds; }
    public void setAverageServiceTimeSeconds(double averageServiceTimeSeconds) { this.averageServiceTimeSeconds = averageServiceTimeSeconds; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}