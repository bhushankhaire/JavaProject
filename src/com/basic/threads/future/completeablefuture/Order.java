package com.basic.threads.future.completeablefuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Order implements Callable {
    Random random=new Random();

   public Supplier  supplier=()->{
        return random.nextInt();
    };
    @Override
    public Object call() throws Exception {
        //Thread.sleep(100);
        return random.nextInt();

    }
}
