package com.basic.threads.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class InterThreadCommunicationExample {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        Producer p=new Producer(queue,5,"producer");
        Consumer c=new Consumer(queue,5,"consumer");
        Producer p1=new Producer(queue,5,"producer1");
        Consumer c1=new Consumer(queue,5,"consumer1");
        Producer p2=new Producer(queue,5,"producer2");
        Consumer c2=new Consumer(queue,5,"consumer2");
        p.start();;
        c.start();
        p1.start();;
        c1.start();
        p2.start();;
        c2.start();
       /* Executor executor= Executors.newFixedThreadPool(4);
        executor.execute(p);
        executor.execute(c);
        executor.execute(p1);
        executor.execute(c1);
        executor.execute(p2);
        executor.execute(c2);*/
    }
}
