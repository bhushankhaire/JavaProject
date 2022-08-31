package com.basic.threads.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueueUsingWaitNotifyAll<E> {
    Queue<E> queue;
    int size;
    public MyBlockingQueueUsingWaitNotifyAll(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public synchronized void add(E e) {
        synchronized (queue) {
            try {
                while (queue.size() == size) {
                    queue.wait();
                }
                this.queue.add(e);
                queue.notifyAll();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public  E take() {
            synchronized (queue) {
                try {
                    while (queue.size() == 0) {
                        queue.wait();
                    }
                    E e = this.queue.remove();
                    queue.notifyAll();
                    return e;
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

}
