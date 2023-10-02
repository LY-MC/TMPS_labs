package com.utm.animals;

import java.util.Random;

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
