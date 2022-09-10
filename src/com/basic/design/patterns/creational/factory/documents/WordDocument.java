package com.basic.design.patterns.creational.factory.documents;

import com.basic.design.patterns.creational.factory.DocType;

public class WordDocument {
    DocType docType=DocType.WORD;
    public void read() {
        System.out.println("WORD document read");
    }
}
