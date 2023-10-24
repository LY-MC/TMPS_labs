package com.utm.clients.decorators;

import com.utm.clients.Client;

public class ClientHappinessReducerDecorator extends ClientHappinessDecorator {
    private int happinessReduction;

    public ClientHappinessReducerDecorator(Client decoratedClient, int happinessReduction) {
        super(decoratedClient);
        this.happinessReduction = happinessReduction;
    }

    @Override
    public int getHappiness() {
        return decoratedClient.getHappiness() - happinessReduction;
    }

    @Override
    public void buyTicket() {

    }

    @Override
    public void enterZoo(boolean canEnter) {

    }

    @Override
    public void setHappiness(int happiness) {

    }
}
