package com.utm.simulation.behaviors;

import com.utm.simulation.Simulation;
import com.utm.simulation.handlers.TippingHandler;

public class TippingBehavior implements SimulationBehavior {
    private final TippingHandler handler;
    private SimulationBehavior nextBehavior;

    public TippingBehavior(TippingHandler handler) {
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
