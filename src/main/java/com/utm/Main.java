package com.utm;

import com.utm.miscellaneous.Cage;
import com.utm.miscellaneous.CageDimensions;
import com.utm.simulation.Simulation;
import com.utm.zooworkers.Cashier;
import com.utm.zooworkers.SecurityGuard;
import com.utm.zooworkers.Veterinarian;
import com.utm.zooworkers.Zookeeper;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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

        var simulation = new Simulation(
                cageWithTrees, cageWithLake, cage , cageWithTreesAndDoubleFencing, new Cashier(),
                new Veterinarian(), new Zookeeper(), new SecurityGuard()
        );
        simulation.runSimulation();
    }
}