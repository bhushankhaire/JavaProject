package com.basic.threads.synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomSemaphoreNewExample {
    static CustomSemaphoreNew semaphore = new CustomSemaphoreNew(2);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
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
            System.out.println(Thread.currentThread().getName() + "  Permit Acquired");
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            try {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + "  Permit Released");

                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
