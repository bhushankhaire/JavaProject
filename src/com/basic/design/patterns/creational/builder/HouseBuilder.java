package com.basic.design.patterns.creational.builder;

public interface HouseBuilder {

    public HouseBuilder withFoundation();
    public HouseBuilder withStructure();
    public HouseBuilder withRoof();
    public HouseBuilder withPaint();
    public House build();

}
