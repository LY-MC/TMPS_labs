package com.utm.miscellaneous;

import com.utm.animals.Animal;
import com.utm.enums.AnimalType;
import com.utm.util.Printer;

import java.util.List;

public class Cage {
    private final CageDimensions dimensions;
    private final AnimalPopulator animalPopulator;
    private final AnimalHealthManager animalHealthManager;

    public Cage() {
        dimensions = new CageDimensions();
        animalPopulator = new AnimalPopulator();
        animalHealthManager = new AnimalHealthManager();
    }

    public int getWidth() {
        return dimensions.getWidth();
    }

    public int getLength() {
        return dimensions.getLength();
    }

    public void populateCage(int count, AnimalType animalType) {
        animalPopulator.populateCage(count, animalType);
    }

    public int countHungryAnimals() {
        List<Animal> animalList = animalPopulator.getAnimalList();
        return animalHealthManager.countHungryAnimals(animalList);
    }

    public int countIllAnimals() {
        return animalHealthManager.countIllAnimals(animalPopulator.getAnimalList());
    }

    public void feedAnimals(int counter, int wrongFood) {
        animalHealthManager.feedAnimals(animalPopulator.getAnimalList(), counter, wrongFood);
    }

    public void becomeHungry() {
        animalHealthManager.becomeHungry(animalPopulator.getAnimalList());
    }

    public void treatAnimals() {
        animalHealthManager.treatAnimals(animalPopulator.getAnimalList());
    }

    public void treatAnimal() {
        animalHealthManager.treatAnimal(animalPopulator.getAnimalList());
    }

    public void printAnimalsInCage() {
        Printer.printAnimalsInCage(animalPopulator.getAnimalList());
    }

    public List<Animal> getAnimalList() {
        return animalPopulator.getAnimalList();
    }
}
