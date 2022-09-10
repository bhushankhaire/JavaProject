package com.basic.design.patterns.behaviour.observer;

public class UserA implements Observer{

    @Override
    public void update(String msg) {
        System.out.println("Got msg "+msg);
    }
}
