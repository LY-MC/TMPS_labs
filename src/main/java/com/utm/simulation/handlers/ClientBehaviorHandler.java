package com.utm.simulation.handlers;

import com.utm.clients.Adult;
import com.utm.clients.Child;
import com.utm.clients.decorators.HappyClientDecorator;
import com.utm.clients.decorators.UnhappyClientDecorator;
import com.utm.simulation.Simulation;
import com.utm.util.Printer;
import com.utm.util.StaticUtils;

import java.util.Arrays;

public class ClientBehaviorHandler implements Handler{

    @Override
    public void handle(Simulation simulation) {
        int randomSeed = StaticUtils.random.nextInt(100);
        simulation.clientWantsToEnter = randomSeed % 2 == 0;
        simulation.clientCanEnter = randomSeed % 20 != 0;
        int newAge = StaticUtils.random.nextInt(80);
        final int AGE_OF_MAJORITY = Integer.parseInt(simulation.props.getProperty("ageOfMajority"));

        if (simulation.clientWantsToEnter) {
            if (newAge < AGE_OF_MAJORITY) {
                simulation.client = new Child();
            } else {
                simulation.client = new Adult();
            }

            simulation.client.setAge(newAge);
            simulation.client.buyTicket();

            if (simulation.simulationHour < Integer.parseInt(simulation.props.getProperty("timeForDiscount"))) {
                simulation.cashier.setTicketPrice(Integer.parseInt(simulation.props.getProperty("ticketPrice")));
            } else {
                simulation.cashier.setTicketPrice(Integer.parseInt(simulation.props.getProperty("ticketPriceWithDiscount")));
            }
            simulation.cashier.sellTicket(simulation.clientCanEnter, newAge);


            if (randomSeed % 18 == 0) {
                Printer.printCashierRude();
                UnhappyClientDecorator unhappyClient = new UnhappyClientDecorator(simulation.client);
                unhappyClient.enterZoo(simulation.clientCanEnter);
            } else {
                HappyClientDecorator happyClient = new HappyClientDecorator(simulation.client);
                happyClient.enterZoo(simulation.clientCanEnter);
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
