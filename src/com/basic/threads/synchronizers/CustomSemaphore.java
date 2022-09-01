package com.basic.threads.synchronizers;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomSemaphore {
    volatile int permits = 0;
    static volatile int counter = 0;
    static Object lock = new Object();
    public CustomSemaphore(int permits) {
        this.permits = permits;
    }
    public void acquire() throws InterruptedException {
        synchronized (lock) {
            while (counter == permits) {
                lock.wait();
            }
            if (counter < permits) {
                counter++;
                lock.notifyAll();
            }
        }
    }
    public void release() throws InterruptedException {
        synchronized (lock) {
            while (counter == 0) {
                lock.wait();
            }
            counter--;
            lock.notifyAll();
        }
    }
}
