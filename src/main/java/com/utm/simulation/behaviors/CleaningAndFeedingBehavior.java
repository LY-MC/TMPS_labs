package com.utm.simulation.behaviors;

import com.utm.simulation.handlers.CleaningAndFeedingHandler;
import com.utm.simulation.Simulation;

public class CleaningAndFeedingBehavior implements SimulationBehavior {
    private final CleaningAndFeedingHandler handler;
    private SimulationBehavior nextBehavior;

    public CleaningAndFeedingBehavior(CleaningAndFeedingHandler handler) {
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
