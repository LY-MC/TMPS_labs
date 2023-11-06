package com.utm.simulation;

import com.utm.clients.Client;
import com.utm.miscellaneous.Cage;

import java.util.Properties;

public class SimulationMemento {
    private final Cage monkeyCage;
    private final Cage elephantCage;
    private final Cage horseCage;
    private final Cage lionCage;
    private final Client client;
    private final int simulationHour;
    private final Properties props;
    private final int wrongFood;

    public SimulationMemento(Cage monkeyCage, Cage elephantCage, Cage horseCage, Cage lionCage, Client client, int simulationHour, Properties props, int wrongFood) {
        this.monkeyCage = monkeyCage;
        this.elephantCage = elephantCage;
        this.horseCage = horseCage;
        this.lionCage = lionCage;
        this.client = client;
        this.simulationHour = simulationHour;
        this.props = props;
        this.wrongFood = wrongFood;
    }

    public Cage getMonkeyCage() {
        return monkeyCage;
    }

    public Cage getElephantCage() {
        return elephantCage;
    }

    public Cage getHorseCage() {
        return horseCage;
    }

    public Cage getLionCage() {
        return lionCage;
    }

    public Client getClient() {
        return client;
    }

    public int getSimulationHour() {
        return simulationHour;
    }

    public Properties getProps() {
        return props;
    }

    public int getWrongFood() {
        return wrongFood;
    }
}

