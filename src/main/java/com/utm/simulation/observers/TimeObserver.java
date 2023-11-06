package com.utm.simulation.observers;

import com.utm.simulation.Simulation;
import com.utm.util.Printer;
import com.utm.util.StaticUtils;

public class TimeObserver implements Observer {
    @Override
    public void update(Event event, Simulation simulation) {
        if (event == Event.TIME_CHANGE) {

            if (simulation.simulationHour >= StaticUtils.CLOSING_HOUR) {
                simulation.simulationHour = StaticUtils.OPENING_HOUR;
            }

            int currentHour = simulation.simulationHour;

            if (currentHour == Integer.parseInt(simulation.props.getProperty("timeForDiscount"))) {
                Printer.printTicketsWithDiscount(true);
            }

            Printer.printSimulationHour(simulation.simulationHour);
        }
    }
}

