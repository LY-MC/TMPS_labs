package com.utm.simulation.behaviors;

import com.utm.simulation.handlers.HorseRidingHandler;
import com.utm.simulation.Simulation;

public class HorseRidingBehavior implements SimulationBehavior {
    private final HorseRidingHandler handler;
    private SimulationBehavior nextBehavior;

    public HorseRidingBehavior(HorseRidingHandler handler) {
        this.handler = handler;
    }

    @Override
    public void performBehavior(Simulation simulation) {
        if (simulation.client != null){
            handler.handle(simulation);
        }
        if (nextBehavior != null) {
            nextBehavior.performBehavior(simulation);
        }
    }
    @Override
    public void setNextBehavior(SimulationBehavior nextBehavior) {
        this.nextBehavior = nextBehavior;
    }
}
