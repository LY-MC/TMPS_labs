package com.utm.simulation.behaviors;

import com.utm.simulation.handlers.AnimalTreatingHandler;
import com.utm.simulation.Simulation;

public class AnimalTreatingBehavior implements SimulationBehavior {
    private final AnimalTreatingHandler handler;
    private SimulationBehavior nextBehavior;

    public AnimalTreatingBehavior(AnimalTreatingHandler handler) {
        this.handler = handler;
    }

    @Override
    public void performBehavior(Simulation simulation) {
        handler.handle(simulation);

        if (nextBehavior != null) {
            nextBehavior.performBehavior(simulation);
        }
    }
    @Override
    public void setNextBehavior(SimulationBehavior nextBehavior) {
        this.nextBehavior = nextBehavior;
    }
}
