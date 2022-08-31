package com.basic.threads.future.completeablefuture;


import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class Payments implements Callable {

    boolean isInventoryPresent;

    public Payments() {
    }

    public Consumer consumer=(i)->{
        System.out.println(" Payments isDone:" + i);
    };
    public Payments(boolean isInventoryPresent) {
        this.isInventoryPresent = isInventoryPresent;
    }

    @Override
    public Object call() throws Exception {
        //Thread.sleep(100);
        return isInventoryPresent;
    }
}
