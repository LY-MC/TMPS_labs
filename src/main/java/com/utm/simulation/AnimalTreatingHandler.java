package com.utm.simulation;

import com.utm.util.Printer;
import com.utm.util.StaticUtils;
import com.utm.zooworkers.Veterinarian;
import com.utm.zooworkers.Zookeeper;

import java.util.Properties;

public class AnimalTreatingHandler {

    public void handle(Simulation simulation, Properties props, Zookeeper zookeeper, Veterinarian veterinarian) {
        int counterIllAnimals = simulation.lionCage.countIllAnimals() + simulation.monkeyCage.countIllAnimals() + simulation.elephantCage.countIllAnimals() + simulation.horseCage.countIllAnimals();
        if (simulation.clientWantsToEnter && simulation.client.getAge() < Integer.parseInt(props.getProperty("ageOfMajority")) && simulation.clientCanEnter) {
            simulation.client.setHappiness(simulation.client.getHappiness() - Integer.parseInt(props.getProperty("childHappinessCoefficient")) * counterIllAnimals);
        } else if (simulation.clientWantsToEnter && simulation.clientCanEnter) {
            simulation.client.setHappiness(simulation.client.getHappiness() - Integer.parseInt(props.getProperty("adultHappinessCoefficient")) * counterIllAnimals);
        }

        if (counterIllAnimals != 0) {
            veterinarian.setTreating(true);
            if (simulation.wrongFood % 10 == 0 && !zookeeper.isCleaning()) {
                Printer.printVeterinarianIsTreating();
                if (simulation.simulationHour == 9 || simulation.simulationHour == 18) {
                    simulation.lionCage.treatAnimals();
                } else if (simulation.simulationHour == 10 || simulation.simulationHour == 13 || simulation.simulationHour == 16) {
                    simulation.monkeyCage.treatAnimals();
                } else if (simulation.simulationHour == 11 || simulation.simulationHour == 17) {
                    simulation.elephantCage.treatAnimals();
                } else if (simulation.simulationHour == 12 || simulation.simulationHour == 15 || simulation.simulationHour == 19) {
                    simulation.horseCage.treatAnimals();
                }
            } else {
                int animalType = StaticUtils.random.nextInt(5) + 1;
                switch (animalType) {
                    case 1:
                        simulation.monkeyCage.treatAnimal();
                        Printer.printTreatingAnimal("a monkey");
                        break;
                    case 2:
                        simulation.elephantCage.treatAnimal();
                        Printer.printTreatingAnimal("an elephant");
                        break;
                    case 3:
                        simulation.horseCage.treatAnimal();
                        Printer.printTreatingAnimal("a horse");
                        break;
                    case 4:
                        simulation.lionCage.treatAnimal();
                        Printer.printTreatingAnimal("a lion");
                        break;
                }
            }
        }
    }
}
