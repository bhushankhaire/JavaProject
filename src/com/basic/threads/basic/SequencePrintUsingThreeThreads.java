package com.basic.threads.basic;

public class SequencePrintUsingThreeThreads {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Task(1), "Task1");
        Thread t2 = new Thread(new Task(2), "Task2");
        Thread t3 = new Thread(new Task(0), "Task3");
        t1.start();
        t2.start();
        t3.start();
    }

}

class Task implements Runnable {
    public int MAX_NUMBER = 10;
    int remainder;
    static int number = 1;
    static Object lock = new Object();

    public Task(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < MAX_NUMBER - 1) {
            synchronized (lock) {
                while ((number % 3) != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number = number + 1;
                lock.notifyAll();
            }
        }
    }
}
