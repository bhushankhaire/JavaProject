package com.basic.java8.coding.program;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MultiplyTwoNumber {

    public static void main(String[] args) {
        BiFunction<Integer, Integer , Integer > multiply= (x, y)-> x*y;

        System.out.println(multiply.apply(5,6));
    }



}
