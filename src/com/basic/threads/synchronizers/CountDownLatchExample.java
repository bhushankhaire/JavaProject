package com.basic.threads.synchronizers;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CountDownLatchExample {

    static int arr []= IntStream.rangeClosed(1,5000).toArray();
    static int sum= IntStream.rangeClosed(1,5000).sum();
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CountDownLatch countDownLatch=new CountDownLatch(2);
        Callable<Integer> c1=()->{
            int sum=0;
            for(int i=0;i< arr.length/2;i++){
                sum=sum+arr[i];
            }
            countDownLatch.countDown();
            return sum;
        };
        Callable<Integer> c2=()->{
            int sum=0;
            for(int i=arr.length/2;i< arr.length;i++){
                sum=sum+arr[i];
            }
            countDownLatch.countDown();
            return sum;
        };
        List<Callable<Integer>> callableList=new ArrayList<>();
        callableList.add(c1);
        callableList.add(c2);
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        List<Future<Integer>> results=executorService.invokeAll(callableList);
        countDownLatch.await();
        int finalSum=0;
        int k=1;
        for (Future result:results){
            System.out.println(" Sum of callable"+k +" is:"+(Integer)result.get());
            finalSum=finalSum+(Integer)result.get();
        }
        System.out.println(" finalSum is:"+finalSum);
        System.out.println(" Sum is:"+sum);
        executorService.shutdown();
    }

}
