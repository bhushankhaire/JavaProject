package com.basic.threads.mergesort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = Arrays.asList(23, 21, 27, 19, 44, 33);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(arrayToSort);

        Future<List<Integer>> sortedArrayFuture =
                executorService.submit(sorter);

        List<Integer> sortedArray = sortedArrayFuture.get();

        for (Integer ints: sortedArray) {
            System.out.println(ints);
        }
        executorService.shutdownNow();
    }
}
