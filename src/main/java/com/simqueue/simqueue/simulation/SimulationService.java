package com.simqueue.simqueue.simulation;
import com.simqueue.simqueue.EventService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SimulationService {

    private final EventService eventService;
    private final Random random = new Random();

    public SimulationService(EventService eventService) {
        this.eventService = eventService;
    }

    public void runSimulation() throws InterruptedException {
        List<String> dataList = new LinkedList<>();
        int totalServiceTime = 0;

        eventService.sendEvent("Welcome to the Supermarket Simulator.");
        Thread.sleep(1000);

        int numOfCashiers = random.nextInt(3) + 3; // 3–5
        eventService.sendEvent("Number of cashiers: " + numOfCashiers);

        List<Cashier> cashierList = new LinkedList<>();
        for (int i = 0; i < numOfCashiers; i++) {
            Cashier cashier = new Cashier(new CashierQueue());
            cashierList.add(cashier);
            eventService.sendEvent("Cashier " + cashier.cashierId + " is at queue " + cashier.queue.queueID + ".");
        }

        WaitingLine line = new WaitingLine();

        String[] randomNamesArr = {"John", "Emma", "Olivia", "Liam", "Mason", "Sophia", "Noah", "Ava", "Ethan", "Isabella"};
        List<String> randomNames = new ArrayList<>(Arrays.asList(randomNamesArr));

        int numOfCustomers = random.nextInt(6) + 5; // 5–10
        eventService.sendEvent("Number of customers: " + numOfCustomers);

        for (int i = 0; i < numOfCustomers; i++) {
            int randomIndex = random.nextInt(randomNames.size());
            String customerName = randomNames.remove(randomIndex);
            Customer customer = new Customer(customerName);
            line.line.add(customer);
            eventService.sendEvent(customer.name + " has entered the line.");
            Thread.sleep(300);
        }

        for (Cashier cashier : cashierList) {
            cashier.serveCustomer(line.line.poll());
        }

        while (!line.line.isEmpty()) {
            for (Cashier cashier : cashierList) {
                if (!cashier.isOccupied) {
                    int m = cashier.serveCustomer(line.line.poll());
                    totalServiceTime += m;
                    if (line.line.isEmpty()) break;
                }
            }
        }

        eventService.sendEvent("The simulation is complete!");
        eventService.sendEvent("Average service time: " + ((totalServiceTime / numOfCustomers) / 1000) + " seconds");
    }
}