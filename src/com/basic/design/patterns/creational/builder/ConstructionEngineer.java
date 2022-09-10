package com.basic.design.patterns.creational.builder;

public class ConstructionEngineer {
    HouseBuilder houseBuilder;

    public ConstructionEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House buildHouse(){
        return houseBuilder.withFoundation().withStructure().withRoof().withPaint().build();
    }

    public static void main(String[] args) {
        ConstructionEngineer engineer=new ConstructionEngineer(new ConcreteHouseBuilder());
        House house=engineer.buildHouse();
        System.out.println(house.toString());

        engineer=new ConstructionEngineer(new WoodHouseBuilder());
        house=engineer.buildHouse();
        System.out.println(house.toString());
    }
}
