package com.basic.threads.producer.consumer;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayBlockingQueue {
    static java.util.concurrent.ArrayBlockingQueue<Integer> arrayBlockingQueue=new java.util.concurrent.ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        Runnable producer=()->{
            int i=0;
            while(true) {
                try {
                    arrayBlockingQueue.put(++i);
                    System.out.println("Queue is added with "+i);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        Runnable consumer=()->{

            while(true) {
                try {
                    int i=arrayBlockingQueue.take();
                    System.out.println("Queue is consumed "+i);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.shutdown();
    }
}
