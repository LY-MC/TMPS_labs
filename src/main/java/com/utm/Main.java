package com.utm;

import com.utm.animals.facade.ZooFacade;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ZooFacade zooFacade = new ZooFacade();
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
                                zooFacade.startSimulation();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                    } else {
                        System.out.println("Simulation is already running.");
                    }
                    break;
                case 2:
                    zooFacade.pauseSimulationAndSaveCheckpoint();
                    System.out.println("Checkpoint created.");
                    break;
                case 3:
                    System.out.print("Enter checkpoint index: ");
                    int checkpointIndex = scanner.nextInt();
                    zooFacade.restoreSimulationFromCheckpoint(checkpointIndex);
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
