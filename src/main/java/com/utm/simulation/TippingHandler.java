package com.utm.simulation;

import com.utm.util.Printer;
import com.utm.util.StaticUtils;

import java.util.Properties;

public class TippingHandler {
    public void handle(Simulation simulation, Properties props) {
        if (simulation.clientWantsToEnter && simulation.clientCanEnter
                && simulation.client.getHappiness() >= Integer.parseInt(props.getProperty("tipHappinessRate"))) {
            int tips = StaticUtils.random.nextInt(Integer.parseInt(props.getProperty("maxTipValue"))) + 1;
            simulation.cashier.setTips(tips);
            Printer.printTipping(tips);
        } else if ((simulation.clientWantsToEnter && simulation.clientCanEnter
                && (simulation.client.getHappiness() < Integer.parseInt(props.getProperty("returnAdultHappinessRate")))
                || simulation.client.getHappiness() < Integer.parseInt(props.getProperty("returnChildHappinessRate")))) {
            Printer.printUnhappyClientRefund(simulation.cashier.getTicketPrice() / 2);
        }
    }
}
