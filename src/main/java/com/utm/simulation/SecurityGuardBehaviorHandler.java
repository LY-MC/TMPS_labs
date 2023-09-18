package com.utm.simulation;

import com.utm.util.Printer;
import com.utm.zooworkers.SecurityGuard;

import java.util.Arrays;

public class SecurityGuardBehaviorHandler {

    public void handle(Simulation simulation, SecurityGuard securityGuard) {
        securityGuard.updateSleeping();
        if (securityGuard.isSleeping()) {
            securityGuard.setHoursSlept(securityGuard.getHoursSlept() + 1);
        }
        if (securityGuard.getHoursSlept() > 2) {
            securityGuard.setSleeping(false);
            securityGuard.setHoursSlept(0);
        }
        if (securityGuard.isSleeping() && !simulation.clientCanEnter) {
            Printer.printSecurityGuardBehavior(true);
            Printer.printClientSneaks();
            Printer.printAnimalSounds(Arrays.asList(simulation.elephantCage, simulation.horseCage, simulation.lionCage, simulation.monkeyCage));
        } else Printer.printSecurityGuardBehavior(securityGuard.isSleeping());
    }
}
