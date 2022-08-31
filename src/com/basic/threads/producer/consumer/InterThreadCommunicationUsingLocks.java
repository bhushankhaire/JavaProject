package com.basic.threads.producer.consumer;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class InterThreadCommunicationUsingLocks {

    public static void main(String[] args) {
        MyBlockingQueueUsingLock<Integer> mqueue=new MyBlockingQueueUsingLock<>(16);

        Thread producer=new Thread(()->{
            while(true) {
                Random r = new Random();
                int i = r.nextInt();
                mqueue.add(i);
                System.out.println("Item add to  Queue is :" + i + " " + Thread.currentThread().getName());
            }
        },"producer");

        Thread consumer=new Thread(()->{
            while(true) {
                int i = mqueue.take();
                System.out.println("Item consumed from Queue is :" + i + " " + Thread.currentThread().getName());
            }
        },"consumer");
        Thread producer1=new Thread(()->{
            while(true) {
                Random r = new Random();
                int i = r.nextInt();
                mqueue.add(i);
                System.out.println("Item add to  Queue is :" + i + " " + Thread.currentThread().getName());
            }
        },"producer1");

        Thread consumer1=new Thread(()->{
            while(true) {
                int i = mqueue.take();
                System.out.println("Item consumed from Queue is :" + i + " " + Thread.currentThread().getName());
            }
        },"consumer1");

  /*  producer.start();
    consumer.start();
    producer1.start();
    consumer1.start();*/
        Executor executor= Executors.newFixedThreadPool(4);
        executor.execute(producer);
        executor.execute(consumer);
        executor.execute(producer1);
        executor.execute(consumer1);
    }
}
