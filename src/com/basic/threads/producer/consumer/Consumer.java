package com.basic.threads.producer.consumer;

import java.util.Queue;

public class Consumer extends Thread {
    Queue<Integer> queue;
    int size;

    public Consumer(Queue<Integer> queue, int size, String name) {
        super(name);
        this.queue = queue;
        this.size = size;
    }

    public void run() {
        while (true) {
            synchronized (queue) {
                while (!isEmpty()) {
                    consumeItem();
                }
            }
        }
    }

    private void consumeItem() {
        int i = queue.remove();
        System.out.println("Item consumed from Queue is :" + i +" "+Thread.currentThread().getName());
        queue.notifyAll();
    }

    private boolean isEmpty() {
        if (queue.size() == 0) {
            try {
                System.out.println(" Queue is empty cannot consume items till queue has item "+Thread.currentThread().getName() );
                queue.wait();
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
