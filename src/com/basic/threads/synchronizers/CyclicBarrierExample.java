package com.basic.threads.synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    private static CyclicBarrier barrier=new CyclicBarrier(3,new MasterBarrier());

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));
       // barrier.await();
       // System.out.println("Thanks all for completing the work");
        executorService.shutdown();
    }

}
class MasterBarrier implements Runnable{
    @Override
    public void run() {
        System.out.println("Thanks all for completing the work");
    }
}
class Task implements Runnable{
    CyclicBarrier barrier;

    public Task(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    @Override
    public void run() {
        // do some task
        System.out.println(Thread.currentThread().getName()+" task done");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
