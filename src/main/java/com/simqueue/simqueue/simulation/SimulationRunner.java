package com.simqueue.simqueue.simulation;

import org.springframework.stereotype.Service;

@Service
public class SimulationRunner {//only the engine to start the simulation by instantiating a SimulationServiceObject and using it's runSimulation() method.

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
 
