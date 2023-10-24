package com.utm.simulation.behaviors;

import com.utm.simulation.handlers.AnimalTreatingHandler;
import com.utm.simulation.Simulation;

public class AnimalTreatingBehavior implements SimulationBehavior {
    private final AnimalTreatingHandler handler;

    public AnimalTreatingBehavior(AnimalTreatingHandler handler) {
        this.handler = handler;
    }

    @Override
    public void performBehavior(Simulation simulation) {
        handler.handle(simulation);
    }
}
