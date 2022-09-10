package com.basic.design.patterns.creational.builder;

public class ConcreteHouseBuilder implements HouseBuilder{
    House house;
    public ConcreteHouseBuilder() {
        this.house = new House();
    }
    @Override
    public ConcreteHouseBuilder withFoundation() {
        house.setFoundation("Concrete foundation");
        return this;
    }
    @Override
    public ConcreteHouseBuilder withStructure( ) {
        house.setStructure("Concrete Structure");
        return this;
    }
    @Override
    public ConcreteHouseBuilder withRoof() {
        house.setRoof("Concrete roof");
        return this;
    }
    @Override
    public ConcreteHouseBuilder withPaint() {
        house.setPaint("Concrete paint");
        return this;
    }
    @Override
    public House build() {
        return house;
    }
}
