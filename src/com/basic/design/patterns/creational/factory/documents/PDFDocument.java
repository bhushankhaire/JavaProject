package com.basic.design.patterns.creational.factory.documents;

import com.basic.design.patterns.creational.factory.DocType;

public class PDFDocument {
    DocType docType=DocType.PDF;
    public void read() {
        System.out.println("PDF document read");
    }
}
