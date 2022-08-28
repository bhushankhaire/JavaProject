package com.basic.threads.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    List<Integer> list;

    public Sorter(List<Integer> list) {
        this.list=list;
    }

    @Override
    public List<Integer> call() throws Exception {

        if(list.size()<=1)
            return list;
        int mid=list.size()/2;
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        for(int i=0;i<mid;i++)
            left.add(list.get(i));
        for(int i=mid;i<list.size();i++)
            right.add(list.get(i));
        ExecutorService executorService= Executors.newCachedThreadPool();
        Future<List<Integer>> leftFuture= executorService.submit(new Sorter(left));
        Future<List<Integer>> rightFuture= executorService.submit(new Sorter(right));
        List<Integer> leftSort=leftFuture.get();
        List<Integer> rightSort=rightFuture.get();

        List<Integer> answer = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < leftSort.size() && j < rightSort.size()) {
            if (leftSort.get(i) <= rightSort.get(j)) {
                answer.add(leftSort.get(i));
                ++i;
            } else {
                answer.add(rightSort.get(j));
                ++j;
            }
        }

        while (i < leftSort.size()) {
            answer.add(leftSort.get(i));
            i++;
        }

        while (j < rightSort.size()) {
            answer.add(rightSort.get(j));
            j++;
        }

        return answer;
    }


}
