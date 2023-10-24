package com.utm.miscellaneous;

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


