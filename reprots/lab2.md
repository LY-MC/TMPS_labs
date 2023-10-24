# Creational Design Patterns


## Author: Maria Lesenco


## Objectives:

* Study and understand the Creational Design Patterns.
* Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
* Use some creational design patterns for object instantiation in a sample project.


## Used Creational Design Patterns:

* Singleton
* Builder
* Prototype
* Factory Method

## Implementation

### Singleton
I decided to use Singleton for Global Access and Consistency, because using a Singleton pattern guarantees that you always work with the same set of configuration properties throughout your application, preventing inconsistencies. Also, I need to access configuration properties from various parts of my project, a Singleton ensures that you have a single, globally accessible instance of the configuration manager. For this reasons I created a ConfigurationManager class that loads and manages configuration properties.
I use it in Simulation class to create properties.
```
this.props = ConfigurationManager.getInstance().getProperties();
```

### Factory Method
Then I wanted to use Factory Method for encapsulation, flexibility and extensibility, separation of concerns
I created an interface AnimalFactory and then created factories for each animal type (like HorseFactory in example below) that I have with the code related to initialization.
```
public interface AnimalFactory {
    Animal createAnimal();
}

public class HorseFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        Random random = new Random();
        Horse horse = new Horse();
        horse.setMale(random.nextBoolean());
        horse.setIll(random.nextInt(100) % 10 == 0);
        horse.setHungry(random.nextBoolean());
        horse.setAge(random.nextInt(29) + 1);
        horse.setWeight(random.nextInt(90) + 360);
        horse.setHeight(random.nextInt(15) + 140);
        return horse;
    }
}
```

### Builder
Then I implemented a Builder pattern for creating not just a cage for each type, but to have a possibility to create a cage with or without lake/trees/double fencing
Now I have a CageBuilder class with the appropriate build method:

```
public class CageBuilder {
    private final CageDimensions dimensions;
    private boolean hasTrees = false;
    private boolean hasLake = false;
    private boolean hasDoubleFencing = false;

    public CageBuilder(CageDimensions dimensions) {
        this.dimensions = dimensions;
    }

    public CageBuilder withTrees() {
        this.hasTrees = true;
        return this;
    }

    public CageBuilder withLake() {
        this.hasLake = true;
        return this;
    }

    public CageBuilder withDoubleFencing() {
        this.hasDoubleFencing = true;
        return this;
    }

    public Cage build() {
        return new Cage(hasTrees, hasLake, hasDoubleFencing);
    }
}

```
and this is how I used it:
```
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
```

### Prototype
I decided to implement Prototype for design exploration and experimentation because my project is getting bigger and it is hard to experiment on it or to look for changes because I have many things printed in output. This approach allows me to experiment with various animal types and their behaviors without modifying the existing code for each animal
I modified the Animal class and created the Experiment class to see the output.

```
public abstract class Animal implements Cloneable

    @Override
    public Animal clone() {
        try {
            return (Animal) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

package com.utm;

import com.utm.animals.Animal;
import com.utm.animals.Elephant;
import com.utm.animals.Horse;

public class Experiment {
        public static void main(String[] args) {
            Animal elephantPrototype = new Elephant();
            Animal horsePrototype = new Horse();

            // Experiment 1: Create and modify instances
            Animal elephant1 = elephantPrototype.clone();
            Animal elephant2 = elephantPrototype.clone();
            Animal horse1 = horsePrototype.clone();

            elephant1.setAge(10);
            horse1.setAge(5);

            System.out.println("Experiment 1:");
            System.out.println("Elephant 1: " + elephant1.toString());
            System.out.println("Elephant 2: " + elephant2.toString());
            System.out.println("Horse 1: " + horse1.toString());
            System.out.println();

            //more experiments...

        }
    }

```

## Conclusions
The utilization of creational design patterns, including Singleton, Builder, Prototype, and Factory Method, in software development has proven to enhance code maintainability and scalability. Singleton ensures a single instance of a class, Builder simplifies complex object construction, Prototype facilitates object cloning, and Factory Method provides an interface for object creation. Employing these patterns strategically can result in more flexible and efficient software systems, ultimately improving development workflows and the quality of the final product.

