package com.utm.clients.decorators;

import com.utm.clients.Client;

public abstract class ClientHappinessDecorator extends Client {
    protected Client decoratedClient;

    public ClientHappinessDecorator(Client decoratedClient) {
        this.decoratedClient = decoratedClient;
    }

    public abstract int getHappiness();

    public abstract void setHappiness(int happiness);
}
