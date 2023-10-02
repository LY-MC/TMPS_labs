package com.utm.miscellaneous;

public class CageBuilder {
    private final CageDimensions dimensions;
    private boolean hasTrees = false;
    private boolean hasLake = false;
    private boolean hasDoubleFencing = false;

    public CageBuilder(CageDimensions dimensions) {
        this.dimensions = dimensions;
    }

    public CageBuilder withTrees() {
        this.hasTrees = true;
        return this;
    }

    public CageBuilder withLake() {
        this.hasLake = true;
        return this;
    }
    public CageBuilder withDoubleFencing() {
        this.hasDoubleFencing = true;
        return this;
    }

    public Cage build() {
        return new Cage(hasTrees, hasLake, hasDoubleFencing);
    }
}

