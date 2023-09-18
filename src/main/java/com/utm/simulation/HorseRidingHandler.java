package com.utm.simulation;

import com.utm.animals.Horse;
import com.utm.clients.Child;
import com.utm.util.Printer;
import com.utm.util.StaticUtils;

import java.util.Properties;

public class HorseRidingHandler {
    public void handle(Simulation simulation, Properties props) {
        int noHorse = StaticUtils.random.nextInt(Integer.parseInt(props.getProperty("numberOfHorses")));

        if (simulation.clientWantsToEnter && simulation.client instanceof Child && simulation.clientCanEnter) {
            ((Child) simulation.client).wantsRideHorse();
            if (simulation.client.getAge() >= Integer.parseInt(props.getProperty("acceptableAge")) && (((Horse) simulation.horseCage.getAnimalList().get(noHorse)).isRideable())) {
                Printer.printHorseRiding(true, true);
                simulation.client.setHappiness(simulation.client.getHappiness() + Integer.parseInt(props.getProperty("childHappinessCoefficient")));

            }
        }
    }
}
