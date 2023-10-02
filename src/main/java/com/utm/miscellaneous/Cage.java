package com.utm.miscellaneous;

import com.utm.animals.Animal;
import com.utm.util.Printer;
import com.utm.animals.AnimalFactory;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private final CageDimensions dimensions;
    private final List<Animal> animalList;
    private final AnimalHealthManager animalHealthManager;
    private final boolean hasTrees;
    private final boolean hasLake;
    private final boolean hasDoubleFencing;

    Cage(boolean hasTrees, boolean hasLake, boolean hasDoubleFencing) {
        this.dimensions = new CageDimensions();
        this.animalList = new ArrayList<>();
        this.animalHealthManager = new AnimalHealthManager();
        this.hasTrees = hasTrees;
        this.hasLake = hasLake;
        this.hasDoubleFencing = hasDoubleFencing;
    }

    public int getWidth() {
        return dimensions.getWidth();
    }

    public int getLength() {
        return dimensions.getLength();
    }

    public boolean hasTrees() {
        return hasTrees;
    }

    public boolean hasLake() {
        return hasLake;
    }

    public boolean hasDoubleFencing() {
        return hasDoubleFencing;
    }
    public void populateCage(int count, AnimalFactory animalFactory) {
        while (count-- > 0) {
            Animal animal = animalFactory.createAnimal();
            animalList.add(animal);
        }
    }

    public int countHungryAnimals() {
        return animalHealthManager.countHungryAnimals(animalList);
    }

    public int countIllAnimals() {
        return animalHealthManager.countIllAnimals(animalList);
    }

    public void feedAnimals(int counter, int wrongFood) {
        animalHealthManager.feedAnimals(animalList, counter, wrongFood);
    }

    public void becomeHungry() {
        animalHealthManager.becomeHungry(animalList);
    }

    public void treatAnimals() {
        animalHealthManager.treatAnimals(animalList);
    }

    public void treatAnimal() {
        animalHealthManager.treatAnimal(animalList);
    }

    public void printAnimalsInCage() {
        Printer.printAnimalsInCage(animalList);
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }
    public static CageBuilder builder(CageDimensions dimensions) {
        return new CageBuilder(dimensions);
    }

}
