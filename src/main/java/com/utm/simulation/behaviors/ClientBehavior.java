package com.utm.simulation.behaviors;

import com.utm.simulation.Simulation;
import com.utm.simulation.behaviors.SimulationBehavior;
import com.utm.simulation.handlers.ClientBehaviorHandler;

public class ClientBehavior implements SimulationBehavior {
    private final ClientBehaviorHandler handler;

    private SimulationBehavior nextBehavior;

    public ClientBehavior(ClientBehaviorHandler handler) {
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
