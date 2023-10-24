package com.utm.simulation.handlers;

import com.utm.simulation.Simulation;
import com.utm.util.Printer;
import com.utm.util.StaticUtils;

public class TippingHandler implements Handler{
    @Override
    public void handle(Simulation simulation) {
        if (simulation.clientWantsToEnter && simulation.clientCanEnter
                && simulation.client.getHappiness() >= Integer.parseInt(simulation.props.getProperty("tipHappinessRate"))) {
            int tips = StaticUtils.random.nextInt(Integer.parseInt(simulation.props.getProperty("maxTipValue"))) + 1;
            simulation.cashier.setTips(tips);
            Printer.printTipping(tips);
        } else if ((simulation.clientWantsToEnter && simulation.clientCanEnter
                && (simulation.client.getHappiness() < Integer.parseInt(simulation.props.getProperty("returnAdultHappinessRate")))
                || simulation.client.getHappiness() < Integer.parseInt(simulation.props.getProperty("returnChildHappinessRate")))) {
            Printer.printUnhappyClientRefund(simulation.cashier.getTicketPrice() / 2);
        }
    }
}
