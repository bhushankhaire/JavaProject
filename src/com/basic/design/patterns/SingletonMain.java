package com.basic.design.patterns;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonMain {
    static SingletonExample instanceOne=SingletonExample.getInstance();
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException {

        Thread t1=new Thread( ()->{
            SingletonExample singletonExample=SingletonExample.getInstance();
            update(singletonExample);
            System.out.println(singletonExample.getI() +" "+singletonExample.hashCode());
        });
        Thread t2=new Thread( ()->{
            SingletonExample singletonExample=SingletonExample.getInstance();
            update(singletonExample);
            System.out.println(singletonExample.getI() +" "+singletonExample.hashCode());
        });
        Thread t3=new Thread( ()->{
            SingletonExample singletonExample=SingletonExample.getInstance();
            update(singletonExample);
            System.out.println(singletonExample.getI() +" "+singletonExample.hashCode());
        });
        List<Thread> tList= new ArrayList<>();
        tList.add(t1);
        tList.add(t2);
        tList.add(t3);


        Executor executor= Executors.newFixedThreadPool(4);
        tList.parallelStream().forEach(t->executor.execute(t));

        ((ExecutorService) executor).shutdown();
        breakSingletonUsingSerializable();
        breakSingletonUsingReflection();
        SingletonExample instanceTwo = (SingletonExample) instanceOne.clone();
        System.out.println("hashCode of instance 1 - " + instanceOne.hashCode());
        System.out.println("hashCode of instance 2 - " + instanceTwo.hashCode());
    }

    private static void breakSingletonUsingSerializable() throws IOException, ClassNotFoundException {

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        instanceOne.setI(20);

        // Serialize to a file
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SingletonExample instanceTwo = (SingletonExample) in.readObject();
        in.close();

        System.out.println(instanceOne.getI() +" "+instanceOne.hashCode());
        System.out.println(instanceTwo.getI() +" "+instanceTwo.hashCode());
    }
    private static void breakSingletonUsingReflection() throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingletonExample instanceTwo = null;
        Constructor[] constructors =
                SingletonExample.class.getDeclaredConstructors();
        for (Constructor constructor : constructors)
        {
            // Below code will destroy the singleton pattern
            constructor.setAccessible(true);
            instanceTwo = (SingletonExample) constructor.newInstance();
            break;
        }

        System.out.println(instanceOne.getI() +" "+instanceOne.hashCode());
        System.out.println(instanceTwo.getI() +" "+instanceTwo.hashCode());
    }

    private static synchronized void update(SingletonExample singletonExample) {
        singletonExample.setI(singletonExample.getI()+1);

    }
}
