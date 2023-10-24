package com.utm.simulation.behaviors;

import com.utm.simulation.Simulation;
import com.utm.simulation.handlers.TippingHandler;

public class TippingBehavior implements SimulationBehavior {
    private final TippingHandler handler;

    public TippingBehavior(TippingHandler handler) {
        this.handler = handler;
    }

    @Override
    public void performBehavior(Simulation simulation) {
        handler.handle(simulation);
    }
}
