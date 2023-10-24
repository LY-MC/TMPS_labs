# Structural Design Patterns


## Author: Maria Lesenco


## Objectives:

* Study and understand the Structural Design Patterns.
* As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.
* Implement some additional functionalities, or create a new project using structural design patterns.


## Used Creational Design Patterns:

* Bridge
* Composite
* Decorator
* Facade

## Implementation

### Bridge
I decided to use Bridge to decouple the abstractions (behaviors) from the implementations (handlers).

This represents the high-level behavior, which is independent of the specific handlers.
```
public interface SimulationBehavior {
    void performBehavior(Simulation simulation);
}
```

Then I created specific simulation behaviors that use the handler implementations. They look like this:
```
public class AnimalTreatingBehavior implements SimulationBehavior {
    private final AnimalTreatingHandler handler;

    public AnimalTreatingBehavior(AnimalTreatingHandler handler) {
        this.handler = handler;
    }

    @Override
    public void performBehavior(Simulation simulation) {
        handler.handle(simulation);
    }
}
```

### Composite
The Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies. I used it to create a hierarchical structure for the cages and animals within the zoo.
I created a CageComponent Interface with some common methods for Cage and CompositeCage
```
public interface CageComponent {
    int getWidth();
    int getLength();
    int countHungryAnimals();
    int countIllAnimals();
    void feedAnimals(int counter, int wrongFood);
    void becomeHungry();
    void treatAnimals();
    void treatAnimal();
    void printAnimalsInCage();
}

package com.utm.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class CompositeCage implements CageComponent {
    private final List<CageComponent> cages;

    public CompositeCage() {
        this.cages = new ArrayList<>();
    }

    //other methods that were implemented 

    public void addCage(CageComponent cage) {
        cages.add(cage);
    }

}

public class Cage implements CageComponent {
    //code
}

```

### Decorator
Then I implemented a Decorator pattern for handling happiness of the client.

```
public abstract class ClientHappinessDecorator extends Client {
    protected Client decoratedClient;

    public ClientHappinessDecorator(Client decoratedClient) {
        this.decoratedClient = decoratedClient;
    }

    public abstract int getHappiness();

    public abstract void setHappiness(int happiness);
}
```

### Facade
A ZooFacade provides a simplified interface for common zoo operations.

```
public class ZooFacade {
    private final Simulation simulation;

    public ZooFacade() {
        CageDimensions cageDimensions = new CageDimensions();
        Cage cageWithLake = Cage.builder(cageDimensions)
                .withLake()
                .build();
        Cage cageWithTrees = Cage.builder(cageDimensions)
                .withTrees()
                .build();
        Cage cageWithTreesAndDoubleFencing = Cage.builder(cageDimensions)
                .withTrees()
                .withDoubleFencing()
                .build();
        Cage cage = Cage.builder(cageDimensions)
                .build();
        simulation = new Simulation(
                cageWithTrees, cageWithLake, cage , cageWithTreesAndDoubleFencing, new Cashier(),
                new Veterinarian(), new Zookeeper(), new SecurityGuard()
        );
    }

    public void startSimulation() throws InterruptedException {
        simulation.runSimulation();
    }

}
```

## Conclusions
The utilization of Structural Design Patterns, such as Bridge, Composite, Decorator, and Facade, has enhanced the zoo simulation project by providing a more organized and flexible architecture. These patterns have enabled a clear separation of concerns, streamlined the management of complex hierarchical structures, and allowed for dynamic extension of client behavior. The implementation of a ZooFacade further simplifies interactions and contributes to a user-friendly experience, making the codebase more maintainable and comprehensible.
