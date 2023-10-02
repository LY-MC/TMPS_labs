package com.utm.simulation;

import com.utm.util.Printer;
import com.utm.zooworkers.Zookeeper;

public class CleaningAndFeedingHandler implements Handler {

    @Override
    public void handle(Simulation simulation) {
        int counterHungryMonkeys = simulation.monkeyCage.countHungryAnimals();
        int counterHungryElephants = simulation.elephantCage.countHungryAnimals();
        int counterHungryHorses = simulation.horseCage.countHungryAnimals();
        int counterHungryLions = simulation.lionCage.countHungryAnimals();
        simulation.zookeeper.setFeeding(true);
        if (simulation.simulationHour == 8 || simulation.simulationHour == 14 || simulation.simulationHour == 20) {
            Printer.printZookeeperBehavior(true);
            simulation.zookeeper.setCleaning(true);
        } else {
            simulation.zookeeper.setCleaning(false);
            if (simulation.simulationHour == 9 || simulation.simulationHour == 18) {
                simulation.lionCage.feedAnimals(simulation.zookeeper.getSpeed(), simulation.wrongFood);
            } else if (simulation.simulationHour == 10 || simulation.simulationHour == 13 || simulation.simulationHour == 16) {
                simulation.monkeyCage.feedAnimals(simulation.zookeeper.getSpeed(), simulation.wrongFood);
            } else if (simulation.simulationHour == 11 || simulation.simulationHour == 17) {
                simulation.elephantCage.feedAnimals(simulation.zookeeper.getSpeed(), simulation.wrongFood);
            } else if (simulation.simulationHour == 12 || simulation.simulationHour == 15 || simulation.simulationHour == 19) {
                simulation.horseCage.feedAnimals(simulation.zookeeper.getSpeed(), simulation.wrongFood);
            }
            Printer.printAnimalFeeding(counterHungryMonkeys, counterHungryElephants, counterHungryHorses, counterHungryLions);
        }

        simulation.elephantCage.becomeHungry();
        simulation.horseCage.becomeHungry();
        simulation.lionCage.becomeHungry();
        simulation.monkeyCage.becomeHungry();
    }
}
