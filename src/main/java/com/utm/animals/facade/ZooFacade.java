package com.utm.animals.facade;

import com.utm.miscellaneous.Cage;
import com.utm.miscellaneous.CageDimensions;
import com.utm.simulation.Simulation;
import com.utm.simulation.observers.TimeObserver;
import com.utm.zooworkers.Cashier;
import com.utm.zooworkers.SecurityGuard;
import com.utm.zooworkers.Veterinarian;
import com.utm.zooworkers.Zookeeper;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ZooFacade {
    private final Simulation simulation;
    private final TimeObserver timeObserver = new TimeObserver();

    public ZooFacade() {
        CageDimensions cageDimensions = new CageDimensions();
        Cage cageWithLake = Cage.builder(cageDimensions)
                .withLake()
                .build();
        Cage cageWithTrees = Cage.builder(cageDimensions)
                .withTrees()
                .build();
        Cage cageWithTreesAndDoubleFencing = Cage.builder(cageDimensions)
                .withTrees()
                .withDoubleFencing()
                .build();
        Cage cage = Cage.builder(cageDimensions)
                .build();
        simulation = new Simulation(
                cageWithTrees, cageWithLake, cage, cageWithTreesAndDoubleFencing, new Cashier(),
                new Veterinarian(), new Zookeeper(), new SecurityGuard()
        );

        simulation.registerTimeObserver(timeObserver);
    }

    public void startSimulation() throws InterruptedException {
        simulation.runSimulation();
    }

    public void pauseSimulationAndSaveCheckpoint() {
        simulation.saveCheckpoint();
    }

    public void restoreSimulationFromCheckpoint(int checkpointIndex) {
        simulation.restoreToCheckpoint(checkpointIndex);
    }

    public void runSimulationWithUserInput() {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(2); // Two threads: one for simulation and one for user input.
        Future<?> simulationTask = null;

        while (true) {
            System.out.println("1. Start Simulation");
            System.out.println("2. Create Checkpoint");
            System.out.println("3. Restore from Checkpoint");
            System.out.println("4. Exit");
            System.out.println("Select an option: ");
            System.out.println();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (simulationTask == null || simulationTask.isDone()) {
                        simulationTask = executor.submit(() -> {
                            try {
                                startSimulation();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                    } else {
                        System.out.println("Simulation is already running.");
                    }
                    break;
                case 2:
                    pauseSimulationAndSaveCheckpoint();
                    System.out.println("Checkpoint created.");
                    break;
                case 3:
                    System.out.print("Enter checkpoint index: ");
                    int checkpointIndex = scanner.nextInt();
                    restoreSimulationFromCheckpoint(checkpointIndex);
                    System.out.println("Restored from checkpoint " + checkpointIndex);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}