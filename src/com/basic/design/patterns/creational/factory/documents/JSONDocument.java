package com.basic.design.patterns.creational.factory.documents;

import com.basic.design.patterns.creational.factory.DocType;

public class JSONDocument {
    DocType docType=DocType.JSON;
    public void read() {
        System.out.println(DocType.JSON+" document read");
    }
}
