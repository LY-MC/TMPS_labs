package com.utm.simulation.behaviors;

import com.utm.simulation.Simulation;

public interface SimulationBehavior {
    void performBehavior(Simulation simulation);

    void setNextBehavior(SimulationBehavior nextBehavior);
}

