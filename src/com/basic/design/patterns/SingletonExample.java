package com.basic.design.patterns;

import java.io.Serializable;
import java.util.SimpleTimeZone;

public class SingletonExample implements Serializable,Cloneable {

    private volatile static SingletonExample instance;
    private int i;
    private SingletonExample() {
        if (instance != null) {
            throw  new RuntimeException("Invalid usage");
        }
    }

    public static SingletonExample getInstance() {
        //single check
        if (instance == null) {
            //thread safe
            synchronized (SingletonExample.class) {
                //Double check
                if (instance == null) {
                    instance = new SingletonExample();
                }
            }
        }
        return instance;
    }

    public SingletonExample clone() throws CloneNotSupportedException {
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
