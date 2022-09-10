package com.basic.design.patterns.creational;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonMain {
    static SingletonPattern instanceOne= SingletonPattern.getInstance();
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException {

        Thread t1=new Thread( ()->{
            SingletonPattern singletonPattern = SingletonPattern.getInstance();
            update(singletonPattern);
            System.out.println(singletonPattern.getI() +" "+ singletonPattern.hashCode());
        });
        Thread t2=new Thread( ()->{
            SingletonPattern singletonPattern = SingletonPattern.getInstance();
            update(singletonPattern);
            System.out.println(singletonPattern.getI() +" "+ singletonPattern.hashCode());
        });
        Thread t3=new Thread( ()->{
            SingletonPattern singletonPattern = SingletonPattern.getInstance();
            update(singletonPattern);
            System.out.println(singletonPattern.getI() +" "+ singletonPattern.hashCode());
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
        SingletonPattern instanceTwo = (SingletonPattern) instanceOne.clone();
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
        SingletonPattern instanceTwo = (SingletonPattern) in.readObject();
        in.close();

        System.out.println(instanceOne.getI() +" "+instanceOne.hashCode());
        System.out.println(instanceTwo.getI() +" "+instanceTwo.hashCode());
    }
    private static void breakSingletonUsingReflection() throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingletonPattern instanceTwo = null;
        Constructor[] constructors =
                SingletonPattern.class.getDeclaredConstructors();
        for (Constructor constructor : constructors)
        {
            // Below code will destroy the singleton pattern
            constructor.setAccessible(true);
            instanceTwo = (SingletonPattern) constructor.newInstance();
            break;
        }

        System.out.println(instanceOne.getI() +" "+instanceOne.hashCode());
        System.out.println(instanceTwo.getI() +" "+instanceTwo.hashCode());
    }

    private static synchronized void update(SingletonPattern singletonPattern) {
        singletonPattern.setI(singletonPattern.getI()+1);

    }
}
