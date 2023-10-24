package com.utm.simulation.behaviors;

import com.utm.simulation.handlers.HorseRidingHandler;
import com.utm.simulation.Simulation;

public class HorseRidingBehavior implements SimulationBehavior {
    private final HorseRidingHandler handler;

    public HorseRidingBehavior(HorseRidingHandler handler) {
        this.handler = handler;
    }

    @Override
    public void performBehavior(Simulation simulation) {
        handler.handle(simulation);
    }
}
