package com.basic.threads.liveliness;

public class DeadLock {
    Resource resource1 =new Resource();
    Resource resource2 =new Resource();
    public void method1(){
        synchronized (resource1){
            System.out.println("Acquired lock on resource 1 " +Thread.currentThread());
            synchronized (resource2){
                System.out.println("Acquired lock on resource 2");
            }
        }
    }
    public void method2(){
        synchronized (resource2){
            System.out.println("Acquired lock on resource 2 "+Thread.currentThread());
            synchronized (resource1){
                System.out.println("Acquired lock on resource 1");
            }
        }
    }
    public static void main(String[] args) {
        DeadLock d=new DeadLock();
        Thread t1=new Thread(new MyThread(d),"Theard 1");
        Thread t2=new Thread(new MyThread2(d),"Theard 2");
        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable{
    DeadLock d;

    public MyThread(DeadLock d) {
        this.d = d;
    }

    public void run(){
        d.method1();
    }
}
class MyThread2 implements Runnable{
    DeadLock d;

    public MyThread2(DeadLock d) {
        this.d = d;
    }

    public void run(){
        d.method2();
    }
}
class Resource{}
