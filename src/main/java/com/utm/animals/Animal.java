package com.utm.animals;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Animal {
    private int weight;
    private int height;
    private int age;
    private boolean isMale;
    private boolean isIll;
    private boolean isHungry;
    private int hoursFed;

    public Animal() {
        super();
        this.isMale = false;
        this.isIll = false;
        this.isHungry = false;
        this.hoursFed = 0;
    }

    abstract public void makeSound();
}
