package com.simqueue.simqueue.simulation;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.simqueue.simqueue.EventService;

@Service
public class SimulationService {

    private final EventService eventService;
    private final Random random = new Random();

    public SimulationService(EventService eventService) {
        this.eventService = eventService;
    }

    public void runSimulation() throws InterruptedException {
        // Simple demo now: 5 customers with random "service times"
        int numCustomers = 5;

        eventService.sendEvent("Simulation started with " + numCustomers + " customers.");

        for (int i = 1; i <= numCustomers; i++) {
            String name = "Customer " + i;

            // Poisson-ish arrival: exponential interarrival times (λ = 0.5 customers/sec)
            double lambda = 0.5; // arrivals per second
            double uArr = random.nextDouble();
            double interArrival = -Math.log(1 - uArr) / lambda; // exponential
            long interArrivalMs = (long) (interArrival * 1000);

            Thread.sleep(interArrivalMs);
            eventService.sendEvent(name + " arrived after " + (interArrivalMs / 1000.0) + "s.");

            // Exponential service time (μ = 0.4 customers/sec)
            double mu = 0.4;
            double uServ = random.nextDouble();
            double serviceTime = -Math.log(1 - uServ) / mu;
            long serviceTimeMs = (long) (serviceTime * 1000);

            eventService.sendEvent("Cashier 1 started serving " + name +
                    " (service time ≈ " + String.format("%.2f", serviceTime) + "s).");

            Thread.sleep(500); // just pacing visuals a bit

            eventService.sendEvent("Cashier 1 finished serving " + name + ".");
        }

        eventService.sendEvent("Simulation finished.");
    }
}