package com.basic.examples;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MySerializable implements Serializable {

    private int id;
    private String name;

    public MySerializable(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MySerializable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream os) throws Exception{
        os.defaultWriteObject();
        os.writeObject(this.name+"abc ");
    }
    private void readObject(ObjectInputStream is) throws Exception{
        is.defaultReadObject();
        this.name = (String) is.readObject();
        this.name=this.name.replace("abc","");
    }



}
