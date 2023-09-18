package com.utm.simulation;

public class RenderHour {
    public void renderHour(Simulation simulation) throws InterruptedException {
        simulation.incrementHour();
        simulation.checkForDiscount();
        simulation.handleClientBehavior();
        simulation.handleSecurityGuardBehavior();
        simulation.handleCleaningAndFeeding();
        simulation.handleAnimalTreating();
        simulation.handleHorseRiding();
        simulation.handleTipping();

        System.out.println();
        Thread.sleep(3000);
    }
}

