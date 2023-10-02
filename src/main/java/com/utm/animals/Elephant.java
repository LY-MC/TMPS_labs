package com.utm.animals;

public class Elephant extends Animal {
    public Elephant() {
        super();
    }


    @Override
    public void makeSound() {
        System.out.println("Elephant" + " : " + "ugh, ugh");
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "weight=" + getWeight() +
                ", height=" + getHeight() +
                ", age=" + getAge() +
                ", isMale=" + isMale() +
                ", isIll=" + isIll() +
                ", isHungry=" + isHungry() +
                '}';
    }
}
