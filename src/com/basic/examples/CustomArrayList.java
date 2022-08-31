package com.basic.examples;

import java.util.ArrayList;
import java.util.List;

//CustomArraylist to avoid duplicate
public class CustomArrayList<E> extends ArrayList {

    @Override
    public boolean add(Object o) {
        if(super.contains(o)){
            return false;
        }
        return super.add(o);
    }

    public static void main(String[] args) {
        List<String> customList=new CustomArrayList<>();
        customList.add("A");
        customList.add("A");
        customList.add("A");
        customList.add("B");

        System.out.println(customList);

    }
}
