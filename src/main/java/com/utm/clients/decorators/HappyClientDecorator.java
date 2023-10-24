package com.utm.clients.decorators;

import com.utm.clients.Client;

public class HappyClientDecorator extends ClientHappinessDecorator {
    public HappyClientDecorator(Client decoratedClient) {
        super(decoratedClient);
        setHappiness(100);
    }

    @Override
    public int getHappiness() {
        return 100;
    }

    @Override
    public void setHappiness(int happiness) {
    }

    @Override
    public void buyTicket() {
        decoratedClient.buyTicket();
        System.out.println("Happy Client: Enjoying the visit with 100% happiness!");
    }

    @Override
    public void enterZoo(boolean canEnter) {
        decoratedClient.enterZoo(canEnter);
        if (canEnter) {
            System.out.println("Happy Client: Entering the zoo with 100% happiness!");
        } else {
            System.out.println("Happy Client: Cannot enter the zoo.");
        }
    }
}