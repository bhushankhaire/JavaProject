package com.basic.java8.coding.program;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements {

    // find duplicate elements in integer list
    public static void main(String[] args) {
        final List<Integer> list = Arrays.asList(1, 3, 45, 56, 6, 3, 2, 4, 1, 2, 3);
        //brute force
        List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);
        List<Integer> duplicate = distinct.stream().filter(c -> list.stream().filter(i -> i == c).count() > 1).peek(System.out::println).collect(Collectors.toList());
        System.out.println("Duplicate elements:" + duplicate);

        //using set
        Set<Integer> distinctSet = duplicateSet(list);
        System.out.println("Duplicate elements with set:" + distinctSet);
    }

    public static <T> Set<T> duplicateSet(List<T> t) {
        Set<T> set = new HashSet<T>();
        return t.stream().filter(i -> !set.add(i)).collect(Collectors.toSet());
    }

 /*   public Integer add( Integer a, Integer b){
        return a+b;
    }*/

    public static<T extends Number> T add(T x, T y){

        if (x == null || y == null) {
            return null;
        }

        if (x instanceof Double) {
            return (T) new Double(x.doubleValue() + y.doubleValue());
        } else if (x instanceof Integer) {
            return (T)new Integer(x.intValue() + y.intValue());
        } else {
            throw new IllegalArgumentException("Type " + x.getClass() + " is not supported by this method");
        }
    }
}
