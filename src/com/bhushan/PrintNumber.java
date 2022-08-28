package com.bhushan;

public class PrintNumber implements Runnable {
    private int number;

    public PrintNumber(int number) {
        super();
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " Number:" + number);

    }
}
