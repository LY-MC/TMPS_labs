package com.utm.miscellaneous;

import com.utm.animals.Animal;

import java.util.List;

public class AnimalHealthManager {
    public void feedAnimals(List<Animal> animalList, int counter, int wrongFood) {
        int myCounter = 0;
        for (Animal animal : animalList) {
            if (animal.isHungry()) {
                animal.setHungry(false);
                if (wrongFood % 10 == 0) {
                    animal.setIll(true);
                }
                myCounter++;
                if (counter == myCounter) {
                    break;
                }
            }
        }
    }

    public void becomeHungry(List<Animal> animalList) {
        for (Animal animal : animalList) {
            if (!animal.isHungry()) {
                animal.setHoursFed(animal.getHoursFed() + 1);
            }

            if (animal.getHoursFed() > 4) {
                animal.setHungry(true);
                animal.setHoursFed(0);
            }
        }
    }

    public void treatAnimals(List<Animal> animalList) {
        for (Animal animal : animalList) {
            animal.setIll(false);
        }
    }

    public void treatAnimal(List<Animal> animalList) {
        for (Animal animal : animalList) {
            if (animal.isIll()) {
                animal.setIll(false);
                break;
            }
        }
    }

    public int countHungryAnimals(List<Animal> animalList) {
        return (int) animalList.stream()
                .filter(Animal::isHungry)
                .count();
    }

    public int countIllAnimals(List<Animal> animalList) {
        return (int) animalList.stream()
                .filter(Animal::isIll)
                .count();
    }
}
