package com.basic.threads.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueUsingLock<E> {
    Queue<E> queue;
    int size;

    ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();
    ;

    public MyBlockingQueueUsingLock(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public void add(E e) {
        lock.lock();
        try {
            while (queue.size() == size) {
                notFull.await();
            }
            this.queue.add(e);
            notEmpty.signalAll();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            E e = this.queue.remove();
            notFull.signalAll();
            return e;
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            lock.unlock();
        }
    }
}
