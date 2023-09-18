package com.utm;

import com.utm.miscellaneous.Cage;
import com.utm.simulation.Simulation;
import com.utm.zooworkers.Cashier;
import com.utm.zooworkers.SecurityGuard;
import com.utm.zooworkers.Veterinarian;
import com.utm.zooworkers.Zookeeper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        var simulation = new Simulation(
                new Cage(), new Cage(), new Cage(), new Cage(), new Cashier(),
                new Veterinarian(), new Zookeeper(), new SecurityGuard()
        );
        simulation.runSimulation();
    }
}