package com.simqueue.simqueue.simulation;

import org.springframework.stereotype.Service;

@Service
public class SimulationRunner {

    private final SimulationService simulationService;

    public SimulationRunner(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    public void startSimulation() {
        try {
            simulationService.runSimulation();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 