package com.basic.threads.future.completeablefuture;

import com.basic.threads.producer.consumer.Consumer;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class Inventory implements Callable {
    int orderNumber;

    public Inventory() {
    }

    public Inventory(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Function<Integer,Boolean> function=(o)->{
        if(o%2==0)
            return true;
        else
            return false;
    };
    @Override
    public Object call() throws Exception {
       // Thread.sleep(100);
        if(orderNumber%2==0)
            return true;
        else
            return false;

    }
}
