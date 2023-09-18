package com.utm.miscellaneous;

import java.util.Random;

public class CageDimensions {
    private int width;
    private int length;

    public CageDimensions() {
        Random random = new Random();
        this.width = random.nextInt(250) + 50;
        this.length = random.nextInt(250) + 50;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
}
