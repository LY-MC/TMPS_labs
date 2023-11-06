package com.utm.simulation.behaviors;

import com.utm.simulation.handlers.SecurityGuardBehaviorHandler;
import com.utm.simulation.Simulation;

public class SecurityGuardBehaviorBehavior implements SimulationBehavior {
    private final SecurityGuardBehaviorHandler handler;
    private SimulationBehavior nextBehavior;

    public SecurityGuardBehaviorBehavior(SecurityGuardBehaviorHandler handler) {
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
