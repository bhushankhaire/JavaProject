package com.basic.java8.coding.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumberCheck {
    static Predicate<Integer> isPrime = inumber -> IntStream.range(2, inumber).noneMatch(n -> inumber % n == 0);
    static Function<Integer, Double> checkPrimeAdd = i -> Math.sqrt(i);

    //chekc if the given number is prime
    public static void main(String[] args) {

        Integer number = 7;


        System.out.println(" Is Prime number:" + number + " :" + isPrime.test(number));

        //CHECK IF NUMBER IS PREIME THEN ADD THE SQUARE ROOT OF IT TO A LIST
        //do above with list
        List<Double> newSqrt10Prime= Stream.iterate(1,i->i+1).filter(isPrime).peek(System.out::println).map(checkPrimeAdd).limit(10).collect(Collectors.toList());
        System.out.println(newSqrt10Prime);
    }

}
