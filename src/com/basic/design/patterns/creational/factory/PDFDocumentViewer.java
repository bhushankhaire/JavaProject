package com.basic.design.patterns.creational.factory;

import com.basic.design.patterns.creational.factory.documents.PDFDocument;

public class PDFDocumentViewer implements FileTypeDocumentViewer<PDFDocument> {

    @Override
    public void readDocument(PDFDocument pdfDocument) {
        pdfDocument.read();
    }
}
