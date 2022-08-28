package com.basic.java8;

import com.oracle.jrockit.jfr.Producer;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExamples {

    public static void main(String[] args) {
        //Legacy code 1
        MyRunnable r1 = new MyRunnable();
        Thread t1 = new Thread(r1);
        t1.start();

        //Legacy code 2 anonymous class
        MyRunnable ra = new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Legacy code anonymous class");
            }
        };
        Thread ta = new Thread(ra);
        ta.start();

        //Lambda as Variable
        Runnable r2 = () -> {
            System.out.println("Lambda as Variable");
        };
        Thread t2 = new Thread(r2);
        t2.start();

        //Lambda as function parameter
        Thread t3 = new Thread(() -> {
            System.out.println("Lambda as function");
        });
        t3.start();

        //Lambda returning value
        FunctionalInterface fa = s -> s.length();
        System.out.println(fa.getLength("Hello"));



    }
}



class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Legacy code");
    }
}
