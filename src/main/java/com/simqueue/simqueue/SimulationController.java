package com.simqueue.simqueue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simqueue.simqueue.simulation.SimulationRunner;
import com.simqueue.simqueue.simulation.SimulationService;

@RestController
public class SimulationController {

    private final SimulationService simulationService;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("/start-simulation")
    public String startSimulation() throws InterruptedException, Exception {
        SimulationRunner runner = new SimulationRunner(simulationService);
        runner.run(); // run the simulation when frontend requests
        return "Simulation started!";
    }
}
