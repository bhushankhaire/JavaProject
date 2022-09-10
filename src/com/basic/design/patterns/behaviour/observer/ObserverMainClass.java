package com.basic.design.patterns.behaviour.observer;

public class ObserverMainClass {

    public static void main(String[] args) {
        Inventory library=new Inventory();
        library.registerObserver(new UserA());
        library.registerObserver(new UserB());
        library.setStock(new Stock());
    }
}
