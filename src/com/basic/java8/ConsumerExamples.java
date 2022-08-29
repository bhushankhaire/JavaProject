package com.basic.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExamples {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6);
        Consumer<List<Integer>> displayList= i->i.stream().forEach(System.out::println);
        Consumer<List<Integer>> modifyList= integerList->{
            for(int i=0;i<integerList.size();i++) {
                list.set(i, 2 * list.get(i));
            }
        };
        modifyList.andThen(displayList).accept(list);

    }
}
