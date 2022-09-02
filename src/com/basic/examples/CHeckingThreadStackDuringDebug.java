package com.basic.examples;


public class CHeckingThreadStackDuringDebug {

    public static void main(String[] args) {
        Integer i=1;
        Integer j=2;
        Integer result=sum(i,j);
        System.out.println(result);
    }

    private static int sum(int i, int j) {
        int result=i+j;
        return result;
    }
}
