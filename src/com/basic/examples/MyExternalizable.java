package com.basic.examples;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MyExternalizable implements Externalizable{

    int id;
    String name;
    String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public MyExternalizable() {
    }

    public MyExternalizable(int id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyExternalizable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.data);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
       this.data= (String) in.readObject();
    }
}
