package com.basic.threads.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankTransfer {
    private String name;
    private Double balance;
    static private ReentrantLock lock=new ReentrantLock();

    public BankTransfer(String name, Double amount) {
        this.name = name;
        this.balance = amount;
    }

    public boolean deposit(Double amount) throws InterruptedException {
        if(lock.tryLock()) {
            Thread.sleep(200);
            this.balance = this.balance + amount;
            lock.unlock();
            return true;
        }
        return false;
    }

    public boolean withdraw(Double amount) throws InterruptedException {
        if(lock.tryLock()) {
            Thread.sleep(200);
            this.balance = this.balance - amount;
            lock.unlock();
            return true;
        }
        return false;
    }

    public boolean transfer(BankTransfer to,Double amount) throws InterruptedException {
        if(withdraw(amount)){
            System.out.println(" Amount :"+amount+" withdrawn from account "+name+" and remaining balance is :"+balance);
            if(to.deposit(amount)){
                System.out.println(" Amount :"+amount+" deposited to account "+to.name+" and total balance is :"+to.balance);
                return true;
            }else{
                while(!deposit(amount)){
                    continue;
                }
                System.out.println(" Amount :"+amount+" withdrawn from account "+name+" reversed and final balance is :"+balance);
            }
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        BankTransfer student=new BankTransfer("Student1",50000.0);

        BankTransfer university=new BankTransfer("University",100000.0);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

            Runnable s1 = () -> {
                System.out.println(Thread.currentThread().getName() +" Executing Transfer :");
                try {
                    while(!student.transfer(university, 1000.0)){
                        Thread.sleep(200);
                        continue;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() +" transfer done :");
            };

        for(int i=0;i<20;i++) {
            executorService.execute(s1);
        }
        executorService.shutdown();
        while(!executorService.awaitTermination(10, TimeUnit.SECONDS)){
            System.out.println("Still waiting for shutdown");
        }

        System.out.println(" Final student balance :" +student.balance);
        System.out.println(" Final University balance :" +university.balance);

    }
}
