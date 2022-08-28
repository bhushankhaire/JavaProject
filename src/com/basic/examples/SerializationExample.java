package com.basic.examples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample {

    public static void main(String[] args) throws IOException {
        List<MySerializable> list =new ArrayList<>();
        MySerializable mySerializable=new MySerializable(10,"Bhushan");
       /* mySerializable.setId(10);
        mySerializable.setName("Bhushan");*/
        list.add(mySerializable);
        MySerializable mySerializable1=new MySerializable(101,"Hello Bhushan");
        /*mySerializable1.setId(101);
        mySerializable1.setName("Hello Bhushan");*/
        list.add(mySerializable1);
        writeToFile(list);


        List<MySerializable> list1=readFromFile();
        System.out.println(list1);

    }

    private static void writeToFile(List<MySerializable> mySerializable) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        try {

            //Serialize in file
            FileOutputStream fileOutputStream = new FileOutputStream("DataFile.ser");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(mySerializable);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            objectOutputStream.close();
        }
    }

    private static List<MySerializable> readFromFile() throws IOException {
        List<MySerializable> mySerializable;
        ObjectInputStream objectInputStream = null;
        try {
            //Deserialize from file
            FileInputStream fileInputStream = new FileInputStream("DataFile.ser");
            objectInputStream = new ObjectInputStream(fileInputStream);
            mySerializable = (List<MySerializable>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            objectInputStream.close();
        }
        return mySerializable;
    }
}
