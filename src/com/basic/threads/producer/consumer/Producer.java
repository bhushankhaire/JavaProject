package com.basic.threads.producer.consumer;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {

    Queue<Integer> queue;
    int size;

    public Producer(Queue<Integer> queue, int size, String name) {
        super(name);
        this.queue = queue;
        this.size = size;
    }

    public void run() {
        while (true) {
            synchronized (queue){
                while (!isFull()) {
                    produceItem();
                }
            }
        }
    }

    private void produceItem() {
        Random r = new Random();
        int i = r.nextInt();
        System.out.println("Item add to  Queue is :" + i+" "+Thread.currentThread().getName());
        queue.add(i);
        queue.notifyAll();
    }

    private boolean isFull() {
        if (queue.size() == size) {
            try {
                System.out.println(" Queue is full cannot produce items till queue is having space "+Thread.currentThread().getName());
                queue.wait();
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
