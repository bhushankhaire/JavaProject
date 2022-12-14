package com.basic.threads.synchronizers;

import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 4; i++) {
            Runnable task1 = () -> {
                test();
            };
            executorService.submit(task1);
        }
        executorService.shutdown();
    }
    private static void test() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " Permit Acquired  ");
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " Permit Released  ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
