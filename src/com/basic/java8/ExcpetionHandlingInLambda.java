package com.basic.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExcpetionHandlingInLambda {


    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7);
        int divideBy=0;

        //list.stream().forEach( i-> System.out.println(i/divideBy));

       /* list.stream().forEach( i->{
            try {
                System.out.println(i / divideBy);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        });*/
        list.stream().forEach( wrapperConsumer(i-> System.out.println(i/divideBy)));
        List<String> parselist= Arrays.asList("121","123","def");
       /* parselist.stream().forEach( i->{
            try {
                System.out.println(Integer.parseInt(i));
            }catch (Exception ex){
                System.out.println("Parsing Exception: "+ex.getMessage());
            }
        });*/
        parselist.stream().forEach(wrapperConsumer(i->System.out.println(Integer.parseInt(i))));
        // instead create a wrapper Consumer
    }

    static <Target> Consumer<Target> wrapperConsumer(Consumer<Target>  targetConsumer){

        return obj-> {
            try {
                targetConsumer.accept(obj);
            }catch (Exception ex){
                System.out.println("Exception: "+obj+" "+ex.getMessage());
            }
        };
    }


}
