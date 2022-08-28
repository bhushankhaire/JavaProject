package com.basic.examples;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Example1 {

    static {
        try{
            int a =10/0;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    int[] num={1,1,1,1,1};

    public static void main(String[] args) {
        Example1 example1=new Example1();
        for(int i=0;i<example1.num.length;i++)
            System.out.println(example1.num[i]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Example1)) return false;
        Example1 example1 = (Example1) o;
        return Arrays.equals(num, example1.num);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(num);
    }
}
