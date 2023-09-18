package com.utm.simulation;

import com.utm.util.Printer;
import com.utm.zooworkers.Zookeeper;

public class CleaningAndFeedingHandler {

    public void handle(Simulation simulation, int simulationHour, Zookeeper zookeeper, int wrongFood) {
        int counterHungryMonkeys = simulation.monkeyCage.countHungryAnimals();
        int counterHungryElephants = simulation.elephantCage.countHungryAnimals();
        int counterHungryHorses = simulation.horseCage.countHungryAnimals();
        int counterHungryLions = simulation.lionCage.countHungryAnimals();
        zookeeper.setFeeding(true);
        if (simulationHour == 8 || simulationHour == 14 || simulationHour == 20) {
            Printer.printZookeeperBehavior(true);
            zookeeper.setCleaning(true);
        } else {
            zookeeper.setCleaning(false);
            if (simulationHour == 9 || simulationHour == 18) {
                simulation.lionCage.feedAnimals(zookeeper.getSpeed(), wrongFood);
            } else if (simulationHour == 10 || simulationHour == 13 || simulationHour == 16) {
                simulation.monkeyCage.feedAnimals(zookeeper.getSpeed(), wrongFood);
            } else if (simulationHour == 11 || simulationHour == 17) {
                simulation.elephantCage.feedAnimals(zookeeper.getSpeed(), wrongFood);
            } else if (simulationHour == 12 || simulationHour == 15 || simulationHour == 19) {
                simulation.horseCage.feedAnimals(zookeeper.getSpeed(), wrongFood);
            }
            Printer.printAnimalFeeding(counterHungryMonkeys, counterHungryElephants, counterHungryHorses, counterHungryLions);
        }

        simulation.elephantCage.becomeHungry();
        simulation.horseCage.becomeHungry();
        simulation.lionCage.becomeHungry();
        simulation.monkeyCage.becomeHungry();
    }
}
