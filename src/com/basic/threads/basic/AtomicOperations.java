package com.basic.threads.basic;

import java.util.stream.Stream;

public class AtomicOperations {


    public static void main(String[] args) {
        MyClass m=new MyClass();
        Thread t1=new Thread(()->{
            Stream.iterate(1,i->i+1).limit(10).forEach( i-> m.setI(i));
        });
        Thread t2=new Thread(()->{
            Stream.iterate(1,i->i+1).limit(10).forEach( i-> m.getI());
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("latest value of i is "+ m.getI());
    }
}

class MyClass{
    volatile int i=1;

    synchronized public int getI() {
        System.out.println("current value of i is "+ i);
        return i;
    }

    synchronized public void setI(int i) {
        System.out.println("new value of i is "+ i);
        this.i = i;
    }
}
