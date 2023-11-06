package com.utm.simulation.observers;

import com.utm.simulation.Simulation;

public interface Observer {
    void update(Event event, Simulation simulation);
}