package com.basic.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AlgoKthMex {

    public static void main(String[] args) {
        int[] arr={7,5,7,1};
        int N=4, K=3;
        System.out.println(KthMex(N,K,arr));
        arr= new int[]{0, 1, 5, 6, 7};
        System.out.println(KthMex(5,1,arr));

    }
    static int KthMex(int N,int K,int [] arr){
        Map<Integer, Integer> map=new TreeMap<>();
        for(int i:arr){
                map.put(i,i);
        }
        for(int i=0;i<N;i++){
            if(!map.containsKey(i))
                K--;
            if(K==0)
                return i;
        }

        return -1;
    }
}
