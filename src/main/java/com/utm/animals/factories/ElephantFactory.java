package com.utm.animals.factories;

import com.utm.animals.Animal;
import com.utm.animals.Elephant;

import java.util.Random;

public class ElephantFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        Random random = new Random();
        Elephant elephant = new Elephant();
        elephant.setMale(random.nextBoolean());
        elephant.setIll(random.nextInt(100) % 10 == 0);
        elephant.setHungry(random.nextBoolean());
        elephant.setAge(random.nextInt(32) + 1);
        if (elephant.getAge() < 4 && elephant.isMale()) {
            elephant.setWeight(random.nextInt(70) + 50);
            elephant.setHeight(random.nextInt(70) + 40);
        } else if (elephant.getAge() < 4 && !elephant.isMale()) {
            elephant.setWeight(random.nextInt(60) + 50);
            elephant.setHeight(random.nextInt(50) + 40);
        } else if (elephant.getAge() > 4 && elephant.isMale()) {
            elephant.setWeight(random.nextInt(4000) + 2500);
            elephant.setHeight(random.nextInt(200) + 200);
        } else if (elephant.getAge() > 4 && !elephant.isMale()) {
            elephant.setWeight(random.nextInt(3000) + 2500);
            elephant.setHeight(random.nextInt(100) + 200);
        }
        return elephant;
    }
}
