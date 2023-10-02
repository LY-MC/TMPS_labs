package com.utm.animals;

public class Monkey extends Animal {
    public Monkey() {
        super();
    }

    @Override
    public void makeSound() {
        System.out.println("Monkey" + " : " + "U U U, a a a");
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "weight=" + getWeight() +
                ", height=" + getHeight() +
                ", age=" + getAge() +
                ", isMale=" + isMale() +
                ", isIll=" + isIll() +
                ", isHungry=" + isHungry() +
                '}';
    }
}
