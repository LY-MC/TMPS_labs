package com.utm.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class CompositeCage implements CageComponent {
    private final List<CageComponent> cages;

    public CompositeCage() {
        this.cages = new ArrayList<>();
    }

    public int getWidth() {
        int totalWidth = 0;
        for (CageComponent cage : cages) {
            totalWidth += cage.getWidth();
        }
        return totalWidth;
    }

    public int getLength() {
        int totalLength = 0;
        for (CageComponent cage : cages) {
            totalLength += cage.getLength();
        }
        return totalLength;
    }

    public int countHungryAnimals() {
        int totalHungryAnimals = 0;
        for (CageComponent cage : cages) {
            totalHungryAnimals += cage.countHungryAnimals();
        }
        return totalHungryAnimals;
    }

    public int countIllAnimals() {
        int totalIllAnimals = 0;
        for (CageComponent cage : cages) {
            totalIllAnimals += cage.countIllAnimals();
        }
        return totalIllAnimals;
    }

    public void feedAnimals(int counter, int wrongFood) {
        for (CageComponent cage : cages) {
            cage.feedAnimals(counter, wrongFood);
        }
    }

    public void becomeHungry() {
        for (CageComponent cage : cages) {
            cage.becomeHungry();
        }
    }

    public void treatAnimals() {
        for (CageComponent cage : cages) {
            cage.treatAnimals();
        }
    }

    public void treatAnimal() {
        for (CageComponent cage : cages) {
            cage.treatAnimal();
        }
    }

    public void printAnimalsInCage() {
        for (CageComponent cage : cages) {
            cage.printAnimalsInCage();
        }
    }

    public void addCage(CageComponent cage) {
        cages.add(cage);
    }

}
