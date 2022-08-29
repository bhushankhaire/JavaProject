package com.basic.examples;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Stack;

public class Example1 {

    /*static {
        try{
            int a =10/0;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    int[] num={1,1,1,1,1};

    public static void main(String[] args) {
        Example1 example1=new Example1();
        for(int i=0;i<example1.num.length;i++)
            System.out.println(example1.num[i]);

        // reverse string
        Stack<Character> stack=new Stack<>();
        String a="Hello";
        for (char c:a.toCharArray()) {
            stack.push(c);
        }
        String b="";
        while(!stack.empty()){
            b=b+stack.pop();
        }
        System.out.println(b);
        System.out.println(checkPalindrome("helleh"));

    }
    static boolean checkPalindrome(String s){
        for (int i=0,j=s.length()-1;i<s.length() ;i++,j--){
            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            } else if (i==j || j<i) {
                System.out.println(s.charAt(i));
                return true;
            }
        }
        return true;
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
