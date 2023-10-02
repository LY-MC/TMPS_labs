package com.utm.simulation;

import java.util.Properties;

import com.utm.animals.ElephantFactory;
import com.utm.animals.HorseFactory;
import com.utm.animals.LionFactory;
import com.utm.animals.MonkeyFactory;
import com.utm.clients.Client;
import com.utm.miscellaneous.Cage;
import com.utm.util.ConfigurationManager;
import com.utm.util.Printer;
import com.utm.util.StaticUtils;
import com.utm.zooworkers.Cashier;
import com.utm.zooworkers.SecurityGuard;
import com.utm.zooworkers.Veterinarian;
import com.utm.zooworkers.Zookeeper;

public class Simulation {
    final Cage monkeyCage;
    final Cage elephantCage;
    final Cage horseCage;
    final Cage lionCage;
    Client client;
    final Cashier cashier;
    final Veterinarian veterinarian;
    final Zookeeper zookeeper;
    final SecurityGuard securityGuard;

    final Properties props;

    int simulationHour = StaticUtils.OPENING_HOUR;

    boolean discountAvailable;

    boolean clientCanEnter;

    boolean clientWantsToEnter;

    int wrongFood = StaticUtils.random.nextInt(100);

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
    }

    public void runSimulation() throws InterruptedException {
        populateCages();
        Printer.printInCages(elephantCage, horseCage, lionCage, monkeyCage);
        initAnimalsAge();

        while (simulationHour < StaticUtils.CLOSING_HOUR) {
            renderHour();
        }
    }

    void populateCages() {
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
        new ClientBehaviorHandler().handle(this);
    }

    void handleSecurityGuardBehavior() {
        new SecurityGuardBehaviorHandler().handle(this);
    }

    void handleCleaningAndFeeding() {
        new CleaningAndFeedingHandler().handle(this);
    }

    void handleAnimalTreating() {
        new AnimalTreatingHandler().handle(this);
    }

    void handleHorseRiding() {
        new HorseRidingHandler().handle(this);
    }

    void handleTipping() {
        new TippingHandler().handle(this);
    }
}