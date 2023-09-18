package com.utm.simulation;

import com.utm.clients.Adult;
import com.utm.clients.Child;
import com.utm.util.Printer;
import com.utm.util.StaticUtils;

import java.util.Arrays;
import java.util.Properties;

class ClientBehaviorHandler {

    public void handle(Simulation simulation, Properties props) {
        int randomSeed = StaticUtils.random.nextInt(100);
        simulation.clientWantsToEnter = randomSeed % 2 == 0;
        simulation.clientCanEnter = randomSeed % 20 != 0;
        int newAge = StaticUtils.random.nextInt(80);
        final int AGE_OF_MAJORITY = Integer.parseInt(props.getProperty("ageOfMajority"));

        if (simulation.clientWantsToEnter) {
            if (newAge < AGE_OF_MAJORITY) {
                simulation.client = new Child();
            } else {
                simulation.client = new Adult();
            }

            simulation.client.setAge(newAge);
            simulation.client.buyTicket();

            if (simulation.simulationHour < Integer.parseInt(props.getProperty("timeForDiscount"))) {
                simulation.cashier.setTicketPrice(Integer.parseInt(props.getProperty("ticketPrice")));
            } else {
                simulation.cashier.setTicketPrice(Integer.parseInt(props.getProperty("ticketPriceWithDiscount")));
            }
            simulation.cashier.sellTicket(simulation.clientCanEnter, newAge);

            simulation.client.enterZoo(simulation.clientCanEnter);
            if (randomSeed % 18 == 0) {
                Printer.printCashierRude();
                simulation.client.setHappiness(75);
            } else {
                simulation.client.setHappiness(100);
            }

            if (simulation.clientCanEnter) {
                Printer.printAnimalSounds(Arrays.asList(
                        simulation.elephantCage, simulation.horseCage,
                        simulation.lionCage, simulation.monkeyCage
                ));
            }
        }
    }
}
