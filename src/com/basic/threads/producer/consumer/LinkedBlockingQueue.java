package com.basic.threads.producer.consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LinkedBlockingQueue {
    static java.util.concurrent.LinkedBlockingQueue<Integer> linkedBlockingQueue =new java.util.concurrent.LinkedBlockingQueue<>(5);
    static int i=0;
    public static void main(String[] args) {

        Runnable producer=()->{

            while(true) {
                try {
                    linkedBlockingQueue.put(++i);
                    System.out.println(Thread.currentThread().getName() +" Queue is added with "+i);
                    
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        Runnable consumer=()->{

            while(true) {
                try {
                    int j= linkedBlockingQueue.take();
                    System.out.println(Thread.currentThread().getName() +" Queue is consumed "+j);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        Runnable producer1=()->{

            while(true) {
                try {
                    linkedBlockingQueue.put(++i);
                    System.out.println(Thread.currentThread().getName() +" Queue is added with "+i);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        Runnable consumer1=()->{

            while(true) {
                try {
                    int j= linkedBlockingQueue.take();
                    System.out.println(Thread.currentThread().getName() +" Queue is consumed "+j);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.submit(producer1);
        executorService.submit(consumer1);

        executorService.shutdown();
    }
}
