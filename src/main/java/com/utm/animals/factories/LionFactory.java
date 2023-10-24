package com.utm.animals.factories;

import com.utm.animals.Animal;
import com.utm.animals.Lion;

import java.util.Random;

public class LionFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        Random random = new Random();
        Lion lion = new Lion();
        lion.setMale(random.nextBoolean());
        lion.setIll(random.nextInt(100) % 10 == 0);
        lion.setHungry(random.nextBoolean());
        lion.setAge(random.nextInt(15) + 1);
        lion.setHeight(random.nextInt(20) + 100);
        if (lion.isMale()) {
            lion.setWeight(random.nextInt(100) + 150);
        } else {
            lion.setWeight(random.nextInt(60) + 120);
        }
        return lion;
    }
}
