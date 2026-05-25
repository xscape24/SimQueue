package com.simqueue.simqueue;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simqueue.simqueue.simulation.SimulationService;

@RestController
@CrossOrigin(origins = "*") // Allows your frontend interface to call this API safely
public class SimulationController {

    private final SimulationService simulationService;

    // Fixed the constructor injection to target your actual SimulationService
    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("/start-simulation")
    public String startSimulation() {
        // Run the simulation in a background thread so it doesn't block the API response
        new Thread(() -> {
            try {
                simulationService.runSimulation();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Simulation thread was interrupted: " + e.getMessage());
            }
        }).start();

        return "Simulation started successfully!";
    }
}