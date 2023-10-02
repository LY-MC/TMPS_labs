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

            // Experiment 2: Check if animals make sounds
            System.out.println("Experiment 2:");
            Animal[] animals = {elephantPrototype, horsePrototype, elephant1};
            for (Animal animal : animals) {
                animal.makeSound();
            }
            System.out.println();

            // Experiment 3: Check if horses are rideable
            System.out.println("Experiment 3:");
            Animal horse2 = horsePrototype.clone();
            Animal horse3 = horsePrototype.clone();
            horse2.setIll(true);
            horse3.setIll(false);

            System.out.println("Is horse 1 rideable? " + ((Horse) horse1).isRideable());
            System.out.println("Is horse 2 rideable? " + ((Horse) horse2).isRideable());
            System.out.println("Is horse 3 rideable? " + ((Horse) horse3).isRideable());
        }
    }


