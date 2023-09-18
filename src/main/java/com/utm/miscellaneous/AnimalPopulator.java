package com.utm.miscellaneous;

import com.utm.animals.*;
import com.utm.enums.AnimalType;

import java.util.ArrayList;
import java.util.List;

public class AnimalPopulator {
    private final List<Animal> animalList = new ArrayList<>();

    public void populateCage(int count, AnimalType animalType) {
        while (count-- > 0) {
            switch (animalType) {
                case MONKEY:
                    this.animalList.add(new Monkey());
                    break;
                case ELEPHANT:
                    this.animalList.add(new Elephant());
                    break;
                case HORSE:
                    this.animalList.add(new Horse());
                    break;
                case LION:
                    this.animalList.add(new Lion());
                    break;
            }
        }
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }
}
