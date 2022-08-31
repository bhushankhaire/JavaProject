package com.basic.threads.future.completeablefuture;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();

            Order order = new Order();
            Future f1 = executorService.submit(order);
            System.out.println(" Order Number:" + f1.get());

            Inventory inventory = new Inventory((Integer) f1.get());
            Future f2 = executorService.submit(inventory);
            System.out.println(" Inventory isPresent:" + f2.get());

            Payments payments = new Payments((Boolean) f2.get());
            Future f3 = executorService.submit(payments);
            System.out.println(" Payments isDone:" + f3.get());
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start));
        }
        long end1= System.currentTimeMillis();
        System.out.println("Total Time taken: " + (end1 - start1));
        executorService.shutdown();
    }


}
