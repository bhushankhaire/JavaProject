package com.basic.threads.synchronizers;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomSemaphoreNewReentrantLock {
    private int permits = 0;
    public static volatile int counter = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public CustomSemaphoreNewReentrantLock(int permits) {
        this.permits = permits;
        this.counter = permits;
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (counter == 0) {
                notEmpty.await();
            }
            counter--;
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void release() throws InterruptedException {
        lock.lock();
        try {
            while (counter == permits) {
                notFull.await();
            }
            counter++;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
