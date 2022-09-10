package com.basic.design.patterns.creational.factory.documents;

import com.basic.design.patterns.creational.factory.DocType;

public class XMLDocument {
    DocType docType=DocType.XML;
    public void read() {
        System.out.println(DocType.XML+" document read");
    }
}
