package com.utm.clients.decorators;

import com.utm.clients.Client;

public class UnhappyClientDecorator extends ClientHappinessDecorator {
    public UnhappyClientDecorator(Client decoratedClient) {
        super(decoratedClient);
        setHappiness(75);
    }

    @Override
    public int getHappiness() {
        return 75;
    }

    @Override
    public void setHappiness(int happiness) {
    }

    @Override
    public void buyTicket() {
        decoratedClient.buyTicket();
        System.out.println("Not so Happy Client: Enjoying the visit with only 75% happiness.");
    }

    @Override
    public void enterZoo(boolean canEnter) {
        decoratedClient.enterZoo(canEnter);
        if (canEnter) {
            System.out.println("Not so Happy Client: Entering the zoo with 75% happiness.");
        } else {
            System.out.println("Not so Happy Client: Cannot enter the zoo.");
        }
    }
}
