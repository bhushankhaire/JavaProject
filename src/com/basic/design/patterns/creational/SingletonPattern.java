package com.basic.design.patterns.creational;

import java.io.Serializable;

public class SingletonPattern implements Serializable,Cloneable {

    private volatile static SingletonPattern instance;
    private int i;
    private SingletonPattern() {
        if (instance != null) {
            throw  new RuntimeException("Invalid usage");
        }
    }

    public static SingletonPattern getInstance() {
        //single check
        if (instance == null) {
            //thread safe
            synchronized (SingletonPattern.class) {
                //Double check
                if (instance == null) {
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }

    public SingletonPattern clone() throws CloneNotSupportedException {
        throw  new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return instance;
    }
    public  int getI() {
        return i;
    }

    public  void setI(int i) {
        this.i = i;
    }
}
