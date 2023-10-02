package com.utm.animals;

public class Lion extends Animal {
    public Lion() {
        super();
    }


    @Override
    public void makeSound() {
        System.out.println("Lion" + " : " + "roar r-r-r");
    }

    @Override
    public String toString() {
        return "Lion{" +
                "weight=" + getWeight() +
                ", height=" + getHeight() +
                ", age=" + getAge() +
                ", isMale=" + isMale() +
                ", isIll=" + isIll() +
                ", isHungry=" + isHungry() +
                '}';
    }
}
