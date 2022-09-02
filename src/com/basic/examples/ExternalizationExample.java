package com.basic.examples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExternalizationExample {

    public static void main(String[] args) throws IOException {

        MyExternalizable myExternalizable = new MyExternalizable(10, "Bhushan", "Bhushan is a good boy");
       /* myExternalizable.setId(10);
        myExternalizable.setName("Bhushan");
        myExternalizable.setData("Bhushan is a good boy");*/
        writeToFile(myExternalizable);


        MyExternalizable myExternalizable2 = readFromFile();
        System.out.println(myExternalizable2);

    }

    private static void writeToFile(MyExternalizable myExternalizable) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream("DataFile.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(myExternalizable);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static MyExternalizable readFromFile() throws IOException {
        MyExternalizable myExternalizable;
        ObjectInputStream objectInputStream = null;
        try {
            //Deserialize from file
            FileInputStream fileInputStream = new FileInputStream("DataFile.ser");
            objectInputStream = new ObjectInputStream(fileInputStream);
            myExternalizable = (MyExternalizable) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            objectInputStream.close();
        }
        return myExternalizable;
    }
}
