package com.basic.threads.synchronizers;


public class CustomSemaphoreNew {
    public static volatile int permits = 0;
    public static volatile int counter = 0;

    private Object lock = new Object();

    public CustomSemaphoreNew(int permits) {
        this.permits = permits;
        this.counter=permits;
    }

    public void acquire() throws InterruptedException {
        synchronized (this) {
            while(counter==0){
                this.wait();
            }
            counter--;
            notifyAll();
        }
    }

    public  void release() throws InterruptedException {
        synchronized (this) {
            while(counter==permits){
                this.wait();
            }
            counter++;
            notifyAll();
        }
    }

    public static int getPermits() {
        return permits;
    }

    public static void setPermits(int permits) {
        CustomSemaphoreNew.permits = permits;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        CustomSemaphoreNew.counter = counter;
    }
}
