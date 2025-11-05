package com.simqueue.simqueue.simulation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimulationRunner implements CommandLineRunner {

    private final SimulationService simulationService;

    public SimulationRunner(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @Override
    public void run(String... args) throws Exception {
        simulationService.runSimulation();
    }
}
