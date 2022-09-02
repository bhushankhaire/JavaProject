package com.basic.threads.synchronizers;


public class CustomSemaphoreNew {
    private int permits = 0;
    private static volatile int counter = 0;
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

}
