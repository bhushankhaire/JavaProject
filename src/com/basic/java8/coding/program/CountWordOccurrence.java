package com.basic.java8.coding.program;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWordOccurrence {

    //Count the no of occurrence of word in the string using java 8.
    public static void main(String[] args) {
        String s = "welcome to code decode and code decode welcome you";
        List<String> list = Arrays.asList(s.split(" "));
        Map<String, Long> l = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(l);

    }

}
