package com.utm.simulation.behaviors;

import com.utm.simulation.Simulation;
import com.utm.simulation.behaviors.SimulationBehavior;
import com.utm.simulation.handlers.ClientBehaviorHandler;

public class ClientBehavior implements SimulationBehavior {
    private final ClientBehaviorHandler handler;

    public ClientBehavior(ClientBehaviorHandler handler) {
        this.handler = handler;
    }

    @Override
    public void performBehavior(Simulation simulation) {
        handler.handle(simulation);
    }
}
