package com.basic.threads.future.completeablefuture;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {


            Order order = new Order();
            Inventory inventory = new Inventory();
            Payments payments = new Payments();
            CompletableFuture f1 = CompletableFuture.supplyAsync(order.supplier,es).
                    thenApplyAsync(inventory.function).
                    thenAccept(payments.consumer);



        }

        long end1= System.currentTimeMillis();
        System.out.println("Total Time taken: " + (end1 - start1));
        es.shutdown();
    }


}
