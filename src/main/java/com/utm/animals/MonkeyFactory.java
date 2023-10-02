package com.utm.animals;

import java.util.Random;

public class MonkeyFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        Random random = new Random();
        Monkey monkey = new Monkey();
        monkey.setMale(random.nextBoolean());
        monkey.setIll(random.nextInt(100) % 10 == 0);
        monkey.setHungry(random.nextBoolean());
        monkey.setAge(random.nextInt(26) + 1);
        if (monkey.getAge() < 3 && monkey.isMale()) {
            monkey.setWeight(random.nextInt(4) + 1);
            monkey.setHeight(random.nextInt(20) + 10);
        } else if (monkey.getAge() < 3 && !monkey.isMale()) {
            monkey.setWeight(random.nextInt(3) + 1);
            monkey.setHeight(random.nextInt(25) + 10);
        } else if (monkey.getAge() > 3 && monkey.isMale()) {
            monkey.setWeight(random.nextInt(4) + 3);
            monkey.setHeight(random.nextInt(25) + 40);
        } else if (monkey.getAge() > 3 && !monkey.isMale()) {
            monkey.setWeight(random.nextInt(3) + 3);
            monkey.setHeight(random.nextInt(20) + 40);
        }
        return monkey;
    }
}
