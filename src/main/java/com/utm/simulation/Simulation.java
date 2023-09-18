package com.utm.simulation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.utm.clients.Client;
import com.utm.enums.AnimalType;
import com.utm.miscellaneous.Cage;
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
    private final Veterinarian veterinarian;
    private final Zookeeper zookeeper;
    private final SecurityGuard securityGuard;

    private Properties props;

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
    }

    public void runSimulation() throws IOException, InterruptedException {
        initProps();
        populateCages();
        Printer.printInCages(elephantCage, horseCage, lionCage, monkeyCage);
        initAnimalsAge();

        while (simulationHour < StaticUtils.CLOSING_HOUR) {
            renderHour();
        }
    }

    void initProps() throws IOException {
        props = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
                + "/src/main/resources/config.properties");
        props.load(ip);
    }

    void populateCages() {
        monkeyCage.populateCage(Integer.parseInt(props.getProperty("numberOfMonkeys")), AnimalType.MONKEY);
        elephantCage.populateCage(Integer.parseInt(props.getProperty("numberOfElephants")), AnimalType.ELEPHANT);
        horseCage.populateCage(Integer.parseInt(props.getProperty("numberOfHorses")), AnimalType.HORSE);
        lionCage.populateCage(Integer.parseInt(props.getProperty("numberOfLions")), AnimalType.LION);
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
        new ClientBehaviorHandler().handle(this, props);
    }

    void handleSecurityGuardBehavior() {
        new SecurityGuardBehaviorHandler().handle(this, securityGuard);
    }

    void handleCleaningAndFeeding() {
        new CleaningAndFeedingHandler().handle(this, simulationHour, zookeeper, wrongFood);
    }

    void handleAnimalTreating() {
        new AnimalTreatingHandler().handle(this, props, zookeeper, veterinarian);
    }

    void handleHorseRiding() {
        new HorseRidingHandler().handle(this, props);
    }

    void handleTipping() {
        new TippingHandler().handle(this, props);
    }
}