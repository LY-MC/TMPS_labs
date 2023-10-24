package com.utm.simulation.handlers;

import com.utm.simulation.Simulation;
import com.utm.util.Printer;

import java.util.Arrays;

public class SecurityGuardBehaviorHandler implements Handler {
    @Override
    public void handle(Simulation simulation) {
        simulation.securityGuard.updateSleeping();
        if (simulation.securityGuard.isSleeping()) {
            simulation.securityGuard.setHoursSlept(simulation.securityGuard.getHoursSlept() + 1);
        }
        if (simulation.securityGuard.getHoursSlept() > 2) {
            simulation.securityGuard.setSleeping(false);
            simulation.securityGuard.setHoursSlept(0);
        }
        if (simulation.securityGuard.isSleeping() && !simulation.clientCanEnter) {
            Printer.printSecurityGuardBehavior(true);
            Printer.printClientSneaks();
            Printer.printAnimalSounds(Arrays.asList(simulation.elephantCage, simulation.horseCage, simulation.lionCage, simulation.monkeyCage));
        } else Printer.printSecurityGuardBehavior(simulation.securityGuard.isSleeping());
    }
}
