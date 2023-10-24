package com.utm.simulation.handlers;

import com.utm.animals.Horse;
import com.utm.clients.Child;
import com.utm.simulation.Simulation;
import com.utm.util.Printer;
import com.utm.util.StaticUtils;

public class HorseRidingHandler implements Handler {
    @Override
    public void handle(Simulation simulation) {
        int noHorse = StaticUtils.random.nextInt(Integer.parseInt(simulation.props.getProperty("numberOfHorses")));

        if (simulation.clientWantsToEnter && simulation.client instanceof Child && simulation.clientCanEnter) {
            ((Child) simulation.client).wantsRideHorse();
            if (simulation.client.getAge() >= Integer.parseInt(simulation.props.getProperty("acceptableAge")) && (((Horse) simulation.horseCage.getAnimalList().get(noHorse)).isRideable())) {
                Printer.printHorseRiding(true, true);
                simulation.client.setHappiness(simulation.client.getHappiness() + Integer.parseInt(simulation.props.getProperty("childHappinessCoefficient")));

            }
        }
    }
}
