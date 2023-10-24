package com.utm.simulation;

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
import com.utm.util.ConfigurationManager;
import com.utm.util.Printer;
import com.utm.util.StaticUtils;
import com.utm.zooworkers.Cashier;
import com.utm.zooworkers.SecurityGuard;
import com.utm.zooworkers.Veterinarian;
import com.utm.zooworkers.Zookeeper;

public class Simulation {
    public final Cage monkeyCage;
    public final Cage elephantCage;
    public final Cage horseCage;
    public final Cage lionCage;
    public boolean clientWantsToEnter;
    public Client client;
    public final Cashier cashier;
    public final Veterinarian veterinarian;
    public final Zookeeper zookeeper;
    public final SecurityGuard securityGuard;

    public final Properties props;
    public boolean clientCanEnter;
    public int wrongFood;

    public int simulationHour = StaticUtils.OPENING_HOUR;

    boolean discountAvailable;

    CompositeCage africanSavannah = new CompositeCage();
    public CompositeCage zoo = new CompositeCage();

    private final SimulationBehavior cleaningAndFeedingBehavior;
    private final SimulationBehavior clientBehavior;
    private final SimulationBehavior animalTreatingBehavior;
    private final SimulationBehavior horseRidingBehavior;
    private final SimulationBehavior tippingBehavior;
    private final SimulationBehavior securityGuardBehavior;

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
        this.cleaningAndFeedingBehavior = new CleaningAndFeedingBehavior(new CleaningAndFeedingHandler());
        this.clientBehavior = new ClientBehavior(new ClientBehaviorHandler());
        this.securityGuardBehavior = new SecurityGuardBehaviorBehavior(new SecurityGuardBehaviorHandler());
        this.animalTreatingBehavior = new AnimalTreatingBehavior(new AnimalTreatingHandler());
        this.horseRidingBehavior = new HorseRidingBehavior(new HorseRidingHandler());
        this.tippingBehavior = new TippingBehavior(new TippingHandler());
    }

    public void runSimulation() throws InterruptedException {
        populateCages();
        Printer.printInCages(zoo);
        initAnimalsAge();

        while (simulationHour < StaticUtils.CLOSING_HOUR) {
            renderHour();
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

        if (simulationHour >= StaticUtils.CLOSING_HOUR) {
            simulationHour = StaticUtils.OPENING_HOUR;
        }

        Printer.printSimulationHour(simulationHour);
    }

    void checkForDiscount() {
        discountAvailable = simulationHour == Integer.parseInt(props.getProperty("timeForDiscount"));
        Printer.printTicketsWithDiscount(discountAvailable);
    }

    private void initAnimalsAge() {
        new InitAnimalsAge().initAgeProps(elephantCage, horseCage, lionCage, monkeyCage, props);
    }

    private void renderHour() throws InterruptedException {
        new RenderHour().renderHour(this);
    }

    void handleClientBehavior() {
        clientBehavior.performBehavior(this);
    }

    void handleSecurityGuardBehavior() {
        securityGuardBehavior.performBehavior(this);
    }

    void handleCleaningAndFeeding() {
        cleaningAndFeedingBehavior.performBehavior(this);
    }

    void handleAnimalTreating() {
        animalTreatingBehavior.performBehavior(this);
    }

    void handleHorseRiding() {
        horseRidingBehavior.performBehavior(this);
    }

    void handleTipping() {
        tippingBehavior.performBehavior(this);
    }
}