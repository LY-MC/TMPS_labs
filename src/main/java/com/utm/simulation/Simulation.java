package com.utm.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import com.utm.animals.factories.ElephantFactory;
import com.utm.animals.factories.HorseFactory;
import com.utm.animals.factories.LionFactory;
import com.utm.animals.factories.MonkeyFactory;
import com.utm.clients.Client;
import com.utm.miscellaneous.Cage;
import com.utm.miscellaneous.CompositeCage;
import com.utm.simulation.behaviors.*;
import com.utm.simulation.handlers.*;
import com.utm.simulation.observers.Event;
import com.utm.simulation.observers.Observer;
import com.utm.util.ConfigurationManager;
import com.utm.util.Printer;
import com.utm.util.StaticUtils;
import com.utm.zooworkers.Cashier;
import com.utm.zooworkers.SecurityGuard;
import com.utm.zooworkers.Veterinarian;
import com.utm.zooworkers.Zookeeper;

public class Simulation {
    public Cage monkeyCage;
    public Cage elephantCage;
    public Cage horseCage;
    public Cage lionCage;
    private final ClientBehavior clientBehavior;
    public boolean clientWantsToEnter;
    public Client client;
    public final Cashier cashier;
    public final Veterinarian veterinarian;
    public final Zookeeper zookeeper;
    public final SecurityGuard securityGuard;
    public Properties props;
    public boolean clientCanEnter;
    public int wrongFood;
    public int simulationHour = StaticUtils.OPENING_HOUR;
    CompositeCage africanSavannah = new CompositeCage();
    public CompositeCage zoo = new CompositeCage();
    private List<Observer> timeObservers = new ArrayList<>();
    private List<SimulationMemento> mementos = new ArrayList<>();



    public Simulation(Cage monkeyCage, Cage elephantCage, Cage horseCage, Cage lionCage,
                      Cashier cashier, Veterinarian veterinarian, Zookeeper zookeeper,
                      SecurityGuard securityGuard) {
        this.monkeyCage = monkeyCage;
        this.elephantCage = elephantCage;
        this.horseCage = horseCage;
        this.lionCage = lionCage;
        this.cashier = cashier;
        this.veterinarian = veterinarian;
        this.zookeeper = zookeeper;
        this.securityGuard = securityGuard;
        this.props = ConfigurationManager.getInstance().getProperties();
        africanSavannah.addCage(monkeyCage);
        africanSavannah.addCage(elephantCage);
        africanSavannah.addCage(lionCage);
        zoo.addCage(africanSavannah);
        zoo.addCage(horseCage);

        this.clientBehavior = new ClientBehavior(new ClientBehaviorHandler());
        CleaningAndFeedingBehavior cleaningAndFeedingBehavior = new CleaningAndFeedingBehavior(new CleaningAndFeedingHandler());
        SecurityGuardBehaviorBehavior securityGuardBehaviorBehavior = new SecurityGuardBehaviorBehavior(new SecurityGuardBehaviorHandler());
        AnimalTreatingBehavior animalTreatingBehavior = new AnimalTreatingBehavior(new AnimalTreatingHandler());
        HorseRidingBehavior horseRidingBehavior = new HorseRidingBehavior(new HorseRidingHandler());
        TippingBehavior tippingBehavior = new TippingBehavior(new TippingHandler());

        clientBehavior.setNextBehavior(securityGuardBehaviorBehavior);
        securityGuardBehaviorBehavior.setNextBehavior(cleaningAndFeedingBehavior);
        cleaningAndFeedingBehavior.setNextBehavior(animalTreatingBehavior);
        animalTreatingBehavior.setNextBehavior(horseRidingBehavior);
        horseRidingBehavior.setNextBehavior(tippingBehavior);
    }

    public void runSimulation() throws InterruptedException {
        populateCages();
        Printer.printInCages(zoo);
        initAnimalsAge();

        while (simulationHour < StaticUtils.CLOSING_HOUR) {
            incrementHour();
            clientBehavior.performBehavior(this);
            System.out.println();
            Thread.sleep(5000);
        }
    }

    public void populateCages() {
        monkeyCage.populateCage(Integer.parseInt(props.getProperty("numberOfMonkeys")), new MonkeyFactory());
        elephantCage.populateCage(Integer.parseInt(props.getProperty("numberOfElephants")), new ElephantFactory());
        horseCage.populateCage(Integer.parseInt(props.getProperty("numberOfHorses")), new HorseFactory());
        lionCage.populateCage(Integer.parseInt(props.getProperty("numberOfLions")), new LionFactory());
    }

    void incrementHour() {
        simulationHour++;
        notifyObservers(Event.TIME_CHANGE);
    }


    private void initAnimalsAge() {
        new InitAnimalsAge().initAgeProps(elephantCage, horseCage, lionCage, monkeyCage, props);
    }

    public void registerTimeObserver(Observer observer) {
        timeObservers.add(observer);
    }

    public void notifyObservers(Event event) {
        if (Objects.requireNonNull(event) == Event.TIME_CHANGE) {
            for (Observer observer : timeObservers) {
                observer.update(event, this);
            }
        }
    }

    public SimulationMemento createMemento() {
        return new SimulationMemento(monkeyCage, elephantCage, horseCage, lionCage, client, simulationHour, props, wrongFood);
    }

    public void restoreFromMemento(SimulationMemento memento) {
        this.monkeyCage = memento.getMonkeyCage();
        this.elephantCage = memento.getElephantCage();
        this.horseCage = memento.getHorseCage();
        this.lionCage = memento.getLionCage();
        this.client = memento.getClient();
        this.simulationHour = memento.getSimulationHour();
        this.props = memento.getProps();
        this.wrongFood = memento.getWrongFood();
    }

    public void saveCheckpoint() {
        mementos.add(createMemento());
    }

    public void restoreToCheckpoint(int checkpointIndex) {
        if (checkpointIndex >= 0 && checkpointIndex < mementos.size()) {
            restoreFromMemento(mementos.get(checkpointIndex));
        }
    }
}