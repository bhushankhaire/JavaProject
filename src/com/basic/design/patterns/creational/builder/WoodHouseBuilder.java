package com.basic.design.patterns.creational.builder;

public class WoodHouseBuilder implements HouseBuilder {
    House house;
    public WoodHouseBuilder() {
        this.house = new House();
    }
    @Override
    public WoodHouseBuilder withFoundation() {
        house.setFoundation("Wood foundation");
        return this;
    }
    @Override
    public WoodHouseBuilder withStructure() {
        house.setStructure("Wood Structure");
        return this;
    }
    @Override
    public WoodHouseBuilder withRoof() {
        house.setRoof("Wood roof");
        return this;
    }
    @Override
    public WoodHouseBuilder withPaint() {
        house.setPaint("Wood paint");
        return this;
    }
    @Override
    public House build() {
        return house;
    }
}
