package com.bhushan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello World " + Thread.currentThread().getName());
        // Assignment: Print hello world using separate thread

        // print number(1 to 100) with each thread.



        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 100000; i++) {
            if (i == 5000) {
                System.out.println("Stop");
            }
            executor.execute(new PrintNumber(i));
        }
        executor.shutdown();

    }
}
