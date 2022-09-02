package com.basic.examples;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcurrentModification {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

        // example1(list);
       Thread t1= new Thread(() -> {
           Iterator<Integer> iterator = list.listIterator();
           while (iterator.hasNext()) {
               System.out.println(iterator.next());
               try {
                   TimeUnit.MILLISECONDS.sleep(100);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
            System.out.println("Finished");
        });
        Thread t2=new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.remove(10);
            System.out.println("Removed");
        });
        t1.start();
        t2.start();
    }

    private static void example1(List<Integer> list) {
        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add(iterator.next());
            list.remove(iterator.next());
        }
    }
}
