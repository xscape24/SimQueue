package com.simqueue.simqueue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simqueue.simqueue.simulation.SimulationRunner;

@RestController
public class SimulationController {

    private final SimulationRunner simulationRunner;

    public SimulationController(SimulationRunner simulationRunner) {
        this.simulationRunner = simulationRunner;
    }

    @GetMapping("/start-simulation")
    public String startSimulation() throws Exception {
        simulationRunner.startSimulation(); // this runs the simulation and triggers eventService internally
        return "Simulation started!";
    }
}
