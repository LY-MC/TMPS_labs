# Behavioral Design Patterns


## Author: Maria Lesenco


## Objectives:

* Study and understand the Behavioral Design Patterns.
* As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.
* Create a new Project or add some additional functionalities using behavioral design patterns.


## Used Behavioral Design Patterns:

* Chain of Responsibility
* Observer
* Memento

## Implementation

### Chain of Responsibility
This pattern allows you to pass a request along a chain of handlers, each of which decides whether to process the request or pass it to the next handler.

My chain:
ClientBehavior -> SecurityGuardBehavior -> CleaningAndFeedingBehavior -> AnimalTreatingBehavior -> HorseRidingBehavior -> TippingBehavior

Each behavior has the option to handle a specific aspect of the simulation, and if it can't handle it, it passes the request to the next behavior in the chain. This approach provides flexibility and makes it easy to add, remove, or modify behaviors without changing the core logic of the simulation.

```
this.clientBehavior = new ClientBehavior(new ClientBehaviorHandler());
clientBehavior.setNextBehavior(securityGuardBehaviorBehavior);
securityGuardBehaviorBehavior.setNextBehavior(cleaningAndFeedingBehavior);
cleaningAndFeedingBehavior.setNextBehavior(animalTreatingBehavior);
animalTreatingBehavior.setNextBehavior(horseRidingBehavior);
horseRidingBehavior.setNextBehavior(tippingBehavior);
```
Now I can call only clientBehavior and it will call other behaviors.
```
while (simulationHour < StaticUtils.CLOSING_HOUR) {
    //other code
    clientBehavior.performBehavior(this);
    //other code
}
```

### Observer
I have created an Event enum to represent the different types of events that can be observed, and I have defined an Observer interface with the update method. The TimeObserver class implements this interface and responds to changes in the simulation time.
```
public enum Event {
    TIME_CHANGE
}

public interface Observer {
    void update(Event event, Simulation simulation);
}

public class TimeObserver implements Observer {
    @Override
    public void update(Event event, Simulation simulation) {
        if (event == Event.TIME_CHANGE) {
            if (simulation.simulationHour >= StaticUtils.CLOSING_HOUR) {
                simulation.simulationHour = StaticUtils.OPENING_HOUR;
            }
            int currentHour = simulation.simulationHour;
            if (currentHour == Integer.parseInt(simulation.props.getProperty("timeForDiscount"))) {
                Printer.printTicketsWithDiscount(true);
            }
            Printer.printSimulationHour(simulation.simulationHour);
        }
    }
}

```

### Memento

My implementation of the Memento pattern is in SimulationMemento class and its usage in Simulation and Main classes. 

Here are some points to consider regarding the Memento pattern implementation:
* Encapsulation: I am encapsulating the state of my Simulation class in the SimulationMemento, which is a good practice to ensure data integrity.
* Restoration: I have implemented methods for creating and restoring from mementos, which allows me to save and restore the state of my simulation. This is the primary purpose of the Memento pattern.

```
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
```

## Conclusions
Behavioral design patterns like Chain of Responsibility, Observer, and Memento promote flexible, decoupled, and maintainable software architectures, facilitating tasks like event handling, communication between objects, and state management for undo/redo functionality. These patterns are powerful tools for enhancing the modularity and adaptability of software systems.